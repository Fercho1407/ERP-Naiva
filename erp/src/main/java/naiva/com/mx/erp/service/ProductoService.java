package naiva.com.mx.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naiva.com.mx.erp.DTO.ProductoCreateDTO;
import naiva.com.mx.erp.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public void guardarProducto(ProductoCreateDTO productoCreateDto){

    }
}
