package naiva.com.mx.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naiva.com.mx.erp.DTO.AlmacenCreateDTO;
import naiva.com.mx.erp.DTO.AlmacenResponseDTO;
import naiva.com.mx.erp.DTO.DireccionCreateDTO;
import naiva.com.mx.erp.model.Almacen;
import naiva.com.mx.erp.model.Direccion;
import naiva.com.mx.erp.repository.AlmacenRepository;

@Service
public class AlmacenService {
    
    @Autowired
    private AlmacenRepository almacenRepository;
    @Autowired 
    private DireccionService direccionService;

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
}
