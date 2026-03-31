package naiva.com.mx.erp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import naiva.com.mx.erp.DTO.ProductoCreateDTO;
import naiva.com.mx.erp.DTO.ProductoResponseDTO;
import naiva.com.mx.erp.service.ProductoService;

@RestController
@CrossOrigin("*")
@RequestMapping("naivaERP")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/producto")
    public ResponseEntity<ProductoResponseDTO> guardarAlmacen(@RequestBody ProductoCreateDTO productoCreateDTO) {
        ProductoResponseDTO productoResponseDTO = productoService.guardarProducto(productoCreateDTO);
        return new ResponseEntity<>(productoResponseDTO, HttpStatus.CREATED);
    }
}
