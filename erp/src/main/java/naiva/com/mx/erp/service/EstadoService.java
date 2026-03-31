package naiva.com.mx.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naiva.com.mx.erp.model.Estado;
import naiva.com.mx.erp.repository.EstadoRepository;


@Service
public class EstadoService {
    @Autowired
    EstadoRepository estadoRepository;

    public List<Estado> getEstados (){
        return estadoRepository.findAll();
    }

    public Integer getEstadoByName (String nombre_estado){
        return estadoRepository.findByEstado(nombre_estado).getId_estado();
    }
}
