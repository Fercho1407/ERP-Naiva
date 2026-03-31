package naiva.com.mx.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naiva.com.mx.erp.DTO.ProductoCreateDTO;
import naiva.com.mx.erp.DTO.ProductoResponseDTO;
import naiva.com.mx.erp.model.Medida;
import naiva.com.mx.erp.model.Producto;
import naiva.com.mx.erp.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MedidaService medidaService;

    public ProductoResponseDTO guardarProducto(ProductoCreateDTO productoCreateDto){
        Medida medida = medidaService.getMedidaByNombreUnidad(productoCreateDto.getMedida(), productoCreateDto.getUnidadMedida());

        System.out.println("---->" + medida + "<-----");
        
        Producto producto = new Producto(
            null,
            productoCreateDto.getNombreProducto(),
            productoCreateDto.getPrecio(),
            productoCreateDto.getValorMedida(),
            medida
        );

        Producto productoGuardado = productoRepository.save(producto);

        return new ProductoResponseDTO(productoGuardado.getNombre(), productoGuardado.getPrecio());
    }
}
