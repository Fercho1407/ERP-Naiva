package naiva.com.mx.erp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import naiva.com.mx.erp.DTO.Responses.InventarioAlmacenResponseDTO;
import naiva.com.mx.erp.service.InventarioAlmacenService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin("*")
@RequestMapping("naivaERP")
@RequiredArgsConstructor
public class InventarioAlmacenController {
    private final InventarioAlmacenService inventarioAlmacenService;
    
    @GetMapping("inventario-almacen/{idAlmacen}")
    public ResponseEntity<List<InventarioAlmacenResponseDTO>> getMethodName(@PathVariable("idAlmacen") Integer idAlmacen) {
        var inventarioAlmacen = inventarioAlmacenService.getProductosPorAlmacen(idAlmacen);
        return new ResponseEntity<>(inventarioAlmacen, HttpStatus.OK);
    }
    
}
