package naiva.com.mx.erp.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroEntradaDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroEntradaResponseDTO;
import naiva.com.mx.erp.model.InventarioAlmacen;
import naiva.com.mx.erp.model.MovimientoInventario;
import naiva.com.mx.erp.model.ENUM.Tipomovimiento;
import naiva.com.mx.erp.repository.InventarioAlmacenRepository;
import naiva.com.mx.erp.repository.MovimientoInventarioRepository;

@Service
public class MovimientoInventarioService {
    @Autowired
    private MovimientoInventarioRepository movimientoInventarioRepository;

    @Autowired
    private InventarioAlmacenRepository inventarioAlmacenRepository;

    
    @Transactional
    public RegistroEntradaResponseDTO registrarEntrada(RegistroEntradaDTO entrada){
        InventarioAlmacen inventarioAlmacen = inventarioAlmacenRepository.findById(entrada.getIdInventarioAlmacen())
                .orElseThrow(() -> new EntityNotFoundException("El registro de inventario no existe"));

        Integer nuevoStock = inventarioAlmacen.getStockActual() + entrada.getCantidad();
        inventarioAlmacen.setStockActual(nuevoStock);
        
        inventarioAlmacenRepository.save(inventarioAlmacen);

        /**
         * Obtener la hora local de la ciudad de mexico
         */
        Instant instant = Instant.now(); 
        ZoneId zonaCDMX = ZoneId.of("America/Mexico_City");
        ZonedDateTime horaCDMX = instant.atZone(zonaCDMX);


        MovimientoInventario movimiento = new MovimientoInventario(
            null,
            entrada.getAutorizacion(),
            Tipomovimiento.ENTRADA,
            entrada.getCantidad(),
            entrada.getCostoUnitario(),
            horaCDMX.toInstant(),
            entrada.getObservaciones(),
            inventarioAlmacen
        );

        
        movimientoInventarioRepository.save(movimiento);
        return new RegistroEntradaResponseDTO(Tipomovimiento.ENTRADA, horaCDMX.toInstant(), entrada.getObservaciones());
    }

}
