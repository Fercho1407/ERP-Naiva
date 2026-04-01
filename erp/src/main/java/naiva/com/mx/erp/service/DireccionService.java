package naiva.com.mx.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naiva.com.mx.erp.DTO.Creates.DireccionCreateDTO;
import naiva.com.mx.erp.DTO.Responses.DireccionResponseDTO;
import naiva.com.mx.erp.model.Direccion;
import naiva.com.mx.erp.model.Estado;
import naiva.com.mx.erp.repository.DireccionRepository;
import naiva.com.mx.erp.repository.EstadoRepository;

@Service
public class DireccionService {
    
    @Autowired
    DireccionRepository direccionRepository;

    @Autowired
    EstadoRepository estadoRepository;

    public DireccionResponseDTO guardarDireccion (DireccionCreateDTO direccionDTO){
        String nombreEstado = direccionDTO.getNombre_estado();
        Estado estado = estadoRepository.findByEstado(nombreEstado);

        Direccion direccion = new Direccion(
            null,
            direccionDTO.getCalle(),
            direccionDTO.getNumero_exterior(),
            direccionDTO.getCodigo_postal(),
            direccionDTO.getLocalidad(),
            direccionDTO.getColonia(),
            estado
        );

        direccionRepository.save(direccion);

        DireccionResponseDTO direccionResponseDTO = new DireccionResponseDTO(
            direccion.getId_direccion(),
            direccion.getCalle(), 
            direccion.getNumero_exterior(),
            direccion.getCodigo_postal(),
            direccion.getEstado().getEstado()
        );

        return direccionResponseDTO;
    }

    public Direccion guardarDireccion1 (DireccionCreateDTO direccionDTO){
        String nombreEstado = direccionDTO.getNombre_estado();
        Estado estado = estadoRepository.findByEstado(nombreEstado);

        Direccion direccion = new Direccion(
            null,
            direccionDTO.getCalle(),
            direccionDTO.getNumero_exterior(),
            direccionDTO.getCodigo_postal(),
            direccionDTO.getLocalidad(),
            direccionDTO.getColonia(),
            estado
        );


        Direccion direccionGuardada = direccionRepository.save(direccion);

        return direccionGuardada;
    }
}
