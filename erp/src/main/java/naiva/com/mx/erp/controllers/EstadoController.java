package naiva.com.mx.erp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import naiva.com.mx.erp.model.Estado;
import naiva.com.mx.erp.service.EstadoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("naivaERP")
@CrossOrigin("*")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping("estados")
    public List<Estado> getMethodName() {
        return estadoService.getEstados();
    }
}
