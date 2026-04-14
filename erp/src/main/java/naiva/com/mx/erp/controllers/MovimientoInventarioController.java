package naiva.com.mx.erp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroEntradaDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroEntradaResponseDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroSalidaDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroSalidaResponseDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroTraspasoDTO;
import naiva.com.mx.erp.DTO.movimientosInventario.RegistroTraspasoResponseDTO;
import naiva.com.mx.erp.service.MovimientoInventarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping("naivaERP/movimiento-inventario")
@RequiredArgsConstructor
public class MovimientoInventarioController {
    
    private final MovimientoInventarioService mInventarioService;

    @PostMapping("/entrada")
    public ResponseEntity<RegistroEntradaResponseDTO> registrarEntrada (@RequestBody RegistroEntradaDTO entrada) {
        RegistroEntradaResponseDTO registro = mInventarioService.registrarEntrada(entrada);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    @PostMapping("/traspaso")
    public ResponseEntity<RegistroTraspasoResponseDTO> registrarTraspaso (@Valid @RequestBody RegistroTraspasoDTO traspaso) {
        RegistroTraspasoResponseDTO registro = mInventarioService.registrarTraspasoInventario(traspaso);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }

    @PostMapping("/salida")
    public ResponseEntity<RegistroSalidaResponseDTO> registrarSalida (@Valid @RequestBody RegistroSalidaDTO salida) {
        RegistroSalidaResponseDTO registro = mInventarioService.registrarSalida(salida);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }
}