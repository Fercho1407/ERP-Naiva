package naiva.com.mx.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import naiva.com.mx.erp.DTO.Responses.InventarioAlmacenResponseDTO;
import naiva.com.mx.erp.repository.InventarioAlmacenRepository;

@Service
public class InventarioAlmacenService {
    @Autowired
    private InventarioAlmacenRepository inventarioAlmacenRepository;

    @Transactional
    public List<InventarioAlmacenResponseDTO> getProductosPorAlmacen(Integer idAlmacen){
        return inventarioAlmacenRepository.getInventarioByIdAlmacen(idAlmacen);
    }
}
