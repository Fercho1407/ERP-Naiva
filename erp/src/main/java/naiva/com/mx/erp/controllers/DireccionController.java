package naiva.com.mx.erp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import naiva.com.mx.erp.DTO.DireccionCreateDTO;
import naiva.com.mx.erp.DTO.DireccionResponseDTO;
import naiva.com.mx.erp.service.DireccionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("naivaERP")
@CrossOrigin("*")
public class DireccionController {
    
    @Autowired
    DireccionService direccionService;

    @PostMapping("/direccion")
    public ResponseEntity<DireccionResponseDTO> guardarDireccion(@RequestBody DireccionCreateDTO direccion) {
        DireccionResponseDTO direccionGuardada = direccionService.guardarDireccion(direccion);
        return new ResponseEntity<>(direccionGuardada, HttpStatus.CREATED);
    }
    
}