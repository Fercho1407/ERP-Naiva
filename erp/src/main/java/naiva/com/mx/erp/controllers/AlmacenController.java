package naiva.com.mx.erp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import naiva.com.mx.erp.DTO.Creates.AlmacenCreateDTO;
import naiva.com.mx.erp.DTO.Responses.AlmacenResponseDTO;
import naiva.com.mx.erp.service.AlmacenService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("naivaERP")
@CrossOrigin("*")
public class AlmacenController {

    @Autowired private AlmacenService almacenService;

    @PostMapping("/almacen")
    public ResponseEntity<AlmacenResponseDTO> guardarAlmacen(@RequestBody AlmacenCreateDTO almacenCreateDTO) {
        AlmacenResponseDTO almacenGuardado = almacenService.guardarAlmacen(almacenCreateDTO);
        return new ResponseEntity<>(almacenGuardado, HttpStatus.CREATED);
    }
    
    
}
