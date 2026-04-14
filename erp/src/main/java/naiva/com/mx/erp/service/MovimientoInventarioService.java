package naiva.com.mx.erp.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroEntradaDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroEntradaResponseDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroTraspasoDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroTraspasoResponseDTO;
import naiva.com.mx.erp.exception.NegocioException;
import naiva.com.mx.erp.exception.RecursoNoEncontradoException;
import naiva.com.mx.erp.model.Almacen;
import naiva.com.mx.erp.model.InventarioAlmacen;
import naiva.com.mx.erp.model.MovimientoInventario;
import naiva.com.mx.erp.model.ENUM.Tipomovimiento;
import naiva.com.mx.erp.model.producto.ProductoVariante;
import naiva.com.mx.erp.repository.AlmacenRepository;
import naiva.com.mx.erp.repository.InventarioAlmacenRepository;
import naiva.com.mx.erp.repository.MovimientoInventarioRepository;
import naiva.com.mx.erp.repository.producto.ProductoVarianteRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovimientoInventarioService {

    private final MovimientoInventarioRepository movimientoInventarioRepository;
    private final InventarioAlmacenRepository inventarioAlmacenRepository;
    private final ProductoVarianteRepository productoVarianteRepository;
    private final AlmacenRepository almacenRepository;
    
    @Transactional
    public RegistroEntradaResponseDTO registrarEntrada(RegistroEntradaDTO entrada){
        InventarioAlmacen inventarioAlmacen = inventarioAlmacenRepository.findById(entrada.getIdInventarioAlmacen())
                .orElseThrow(() -> new EntityNotFoundException("El registro de inventario no existe"));

        Integer nuevoStock = inventarioAlmacen.getStockActual() + entrada.getCantidad();
        inventarioAlmacen.setStockActual(nuevoStock);
        
        inventarioAlmacenRepository.save(inventarioAlmacen);

        MovimientoInventario movimiento = new MovimientoInventario(
            null,
            entrada.getAutorizacion(),
            Tipomovimiento.ENTRADA,
            entrada.getCantidad(),
            entrada.getCostoUnitario(),
            horaCDMX(),
            entrada.getObservaciones(),
            inventarioAlmacen
        );

        
        movimientoInventarioRepository.save(movimiento);
        return new RegistroEntradaResponseDTO(Tipomovimiento.ENTRADA, horaCDMX(), entrada.getObservaciones());
    }

    @Transactional
    public RegistroTraspasoResponseDTO registrarTraspasoInventario(RegistroTraspasoDTO traspasoInventario){
        try {
            Optional<Long> idInventarioAlmacenDestino = inventarioAlmacenRepository.findIdByProductoAndAlmacen(
                traspasoInventario.getIdProductoInventarioAlmacen(), 
                traspasoInventario.getIdAlmacenDestino()
            );

            //El producto no existe en el inventario destino
            //if(idInventarioAlmacenDestino.isEmpty()){
                return guardarProductoEnAlmacenDestino(traspasoInventario);
            //}
        } catch (RuntimeException e) {
            // Aquí puedes loguear el error antes de que se propague
            log.error("Error en el traspaso: " + e.getMessage());
            throw e; // Re-lanzamos para que @Transactional detecte el error y haga rollback
        }
    }

    public void registrarSalidaInventario(){

    }


    private RegistroTraspasoResponseDTO guardarProductoEnAlmacenDestino(RegistroTraspasoDTO traspasoInventario){
        InventarioAlmacen inventarioAlmacenOrigen = inventarioAlmacenRepository.findById(traspasoInventario.getIdProductoInventarioAlmacen())
                                                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró el registro de inventario solicitado."));

        Almacen almacenOrigen = almacenRepository.findById(traspasoInventario.getIdAlmacenOrigen())
                                                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el almacen de origen."));

        Integer stockActual = inventarioAlmacenOrigen.getStockActual();
        Integer stockTraspaso = traspasoInventario.getStockTraspaso();

        //Validacion de que el stock de traspaso no sea al mayor al que hay en existencia
        if (stockTraspaso > stockActual){
            throw new NegocioException("No se puede traspasar una cantidad mayor al stock disponible.");
        }

        //Establecer el nuevo stock en el almacen de origen
        Integer stockActualizadoOrigen = stockActual - stockTraspaso;
        inventarioAlmacenOrigen.setStockActual(stockActualizadoOrigen);
        
        //Preparacion del nuevo registro en el almacen destino
        ProductoVariante productoVariante = productoVarianteRepository.findById(inventarioAlmacenOrigen.getProductoVariante().getIdProductoVariante())
                                                .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado en el inventario"));

        Almacen almacenDestino = almacenRepository.findById(traspasoInventario.getIdAlmacenDestino())
                                    .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el almacen de destino"));

        InventarioAlmacen inventarioAlmacenDestino = new InventarioAlmacen(
            null,
            almacenDestino,
            productoVariante,
            stockTraspaso,
            traspasoInventario.getNuevaUbicacionInterna()
        );

        //Crear el nuevo registro del movimiento
        String observaciones = "Se traspaso " + stockActual + " de " + productoVariante.getProducto().getNombre() + " desde el almacen " +
                                almacenOrigen.getNombre() + " hacia el almacen " + almacenDestino.getNombre();

        MovimientoInventario movimientoInventario = new MovimientoInventario(
            null,
            traspasoInventario.getAutotizacion(),
            Tipomovimiento.TRASPASO_ALMACEN,
            stockTraspaso,
            traspasoInventario.getCostoTranslado(),
            horaCDMX(),
            observaciones,
            inventarioAlmacenOrigen
        );


        //Actualizar el stock de origen en la base de datos
        inventarioAlmacenRepository.save(inventarioAlmacenOrigen);
        //Guardar el nuevo registro en la base de datos
        inventarioAlmacenRepository.save(inventarioAlmacenDestino);
        //Guardar el registro del movimiento
        movimientoInventarioRepository.save(movimientoInventario);

        return new RegistroTraspasoResponseDTO(stockActualizadoOrigen, stockTraspaso);
    }

    /**
    * Obtener la hora local de la ciudad de mexico
    */
    private Instant horaCDMX(){
        Instant instant = Instant.now(); 
        ZoneId zonaCDMX = ZoneId.of("America/Mexico_City");
        ZonedDateTime horaCDMX = instant.atZone(zonaCDMX);
        Instant horaActual = horaCDMX.toInstant();
        return horaActual;
    }
}