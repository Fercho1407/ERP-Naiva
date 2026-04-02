package naiva.com.mx.erp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import naiva.com.mx.erp.DTO.Responses.ProductoVarianteResponseDTO;
import naiva.com.mx.erp.service.ProductoVarianteService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("naivaERP")
@CrossOrigin("*")
public class ProductoVarianteController {
    
    @Autowired
    private ProductoVarianteService productoVarianteService;
    
    @GetMapping("/productos-variante")
    public ResponseEntity<List<ProductoVarianteResponseDTO>> getAllProductos() {
        List<ProductoVarianteResponseDTO> productos = productoVarianteService.getAllProductosVarianteDescripcion();
        
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si la lista está vacía
        }
        
        return ResponseEntity.ok(productos); // Retorna 200 OK con la lista
    }
    
}
