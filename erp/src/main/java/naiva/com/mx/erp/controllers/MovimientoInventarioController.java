package naiva.com.mx.erp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import naiva.com.mx.erp.DTO.movimientosInventario.RegistroEntradaDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroEntradaResponseDTO;
import naiva.com.mx.erp.service.MovimientoInventarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping("naivaERP")
public class MovimientoInventarioController {
    @Autowired
    MovimientoInventarioService mInventarioService;

    @PostMapping("/registro-movimiento")
    public ResponseEntity<RegistroEntradaResponseDTO> registrarEntrada (@RequestBody RegistroEntradaDTO entrada) {
        RegistroEntradaResponseDTO registro = mInventarioService.registrarEntrada(entrada);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }
}