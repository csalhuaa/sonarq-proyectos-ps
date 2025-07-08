package com.rest_api_cigarrillos.demo.controllers.controllersReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaClase;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioCigaClase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clase")
public class CigaClaseController {
    @Autowired
    private ServicioCigaClase servicioCigaClase;

    @GetMapping
    @CrossOrigin
    public List<CigaClase> cigaClaseLista() {
        return servicioCigaClase.getAllCigaClase();
    }

    @PostMapping
    @CrossOrigin
    public CigaClase crearCigaClase(@RequestBody CigaClase cigaClase) {
        return servicioCigaClase.crearCigaClase(cigaClase);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public CigaClase cigaClasePorId(@PathVariable int id) {
        return servicioCigaClase.getCigaClaseById(id);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public CigaClase actualizarCigaClase(@PathVariable int id, @RequestBody CigaClase cigaClase) {
        return servicioCigaClase.actualizarCigaClase(id, cigaClase);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void eliminarCigaClase(@PathVariable int id) {
        servicioCigaClase.eliminarCigaClase(id);
    }
}
