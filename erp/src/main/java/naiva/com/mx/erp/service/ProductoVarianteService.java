package naiva.com.mx.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naiva.com.mx.erp.DTO.Responses.ProductoVarianteResponseDTO;
import naiva.com.mx.erp.repository.producto.ProductoVarianteRepository;

@Service
public class ProductoVarianteService {
    
    @Autowired
    private ProductoVarianteRepository productoVarianteRepository;

    public List<ProductoVarianteResponseDTO> getAllProductosVarianteDescripcion(){
        return productoVarianteRepository.findAllProductosVariante();
    }
    

}
