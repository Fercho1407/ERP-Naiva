package naiva.com.mx.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import naiva.com.mx.erp.DTO.Creates.AlmacenCreateDTO;
import naiva.com.mx.erp.DTO.Creates.DireccionCreateDTO;
import naiva.com.mx.erp.DTO.Responses.AlmacenResponseDTO;
import naiva.com.mx.erp.model.Almacen;
import naiva.com.mx.erp.model.Direccion;
import naiva.com.mx.erp.repository.AlmacenRepository;

@Service
@RequiredArgsConstructor
public class AlmacenService {
    
    private final AlmacenRepository almacenRepository;
    private final DireccionService direccionService;

    /**
     * Recibe todos los datos necesarios para crear un almacen con su respectiva direccion
     * @param almacenCreateDTO
     */
    public AlmacenResponseDTO guardarAlmacen(AlmacenCreateDTO almacenCreateDTO){

        /**
         * Guarda la direccion asociada a un almacen
         */
        DireccionCreateDTO direccionDTO = new DireccionCreateDTO(
            almacenCreateDTO.getCalle(),
            almacenCreateDTO.getNumero_exterior(),
            almacenCreateDTO.getCodigo_postal(),
            almacenCreateDTO.getLocalidad(),
            almacenCreateDTO.getColonia(),
            almacenCreateDTO.getNombre_estado()
        );

        /**
         * Direccion asociada al almacen
         */
        Direccion direccion = direccionService.guardarDireccion1(direccionDTO);

        /**
         * Creacion del nuevo almacen
         */
        

        Almacen almacen = almacenRepository.save(new Almacen(
            null,
            almacenCreateDTO.getNombreAlmacen(),
            direccion            
        ));

        /**
         * Retorna solamente lo necesario
         */
        return new AlmacenResponseDTO(almacen.getNombre());
    }

    /**
     * Metodo que permite obtener todos los almacenes registrados en la base de datos
     * @return Lista de alamcenes  
     */
    public List<Almacen> getListaAlmacenes(){
        var almacenes = almacenRepository.findAll();

        if(almacenes.isEmpty()) throw new RuntimeException("No hay almacenes registrados");

        for(Almacen almacen: almacenes){
            almacen.setDireccion(null);
        }

        return almacenes;
    }
}
