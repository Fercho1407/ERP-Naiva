package naiva.com.mx.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naiva.com.mx.erp.model.Medida;
import naiva.com.mx.erp.repository.MedidaRepository;

@Service
public class MedidaService {
    @Autowired
    private MedidaRepository medidaRepository;

    public List<Medida> getAllMedidas (){
        return medidaRepository.findAll();
    }

    public Integer getIdMedidaByNombre (String medida){
        Medida m = medidaRepository.findByIdMedida(medida);
        return m.getIdMedida();
    }

    public Optional<Medida> getMedidaById(Integer idMedida){
        return medidaRepository.findById(idMedida);
    }
}
