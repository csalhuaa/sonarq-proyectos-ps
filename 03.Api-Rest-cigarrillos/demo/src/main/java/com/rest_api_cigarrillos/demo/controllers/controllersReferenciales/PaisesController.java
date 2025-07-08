package com.rest_api_cigarrillos.demo.controllers.controllersReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.Paises;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioPaises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pais")
public class PaisesController {
    @Autowired
    private ServicioPaises servicioPaises;

    @GetMapping
    @CrossOrigin
    public List<Paises> paisesLista() {
        return servicioPaises.getAllPaises();
    }

    @PostMapping
    @CrossOrigin
    public Paises crearPais(@RequestBody Paises pais) {
        return servicioPaises.crearPais(pais);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Paises paisesPorId(@PathVariable int id) {
        return servicioPaises.getPaisById(id);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public Paises actualizarPais(@PathVariable int id, @RequestBody Paises pais) {
        return servicioPaises.actualizarPais(id, pais);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void eliminarPais(@PathVariable int id) {
        servicioPaises.eliminarPais(id);
    }
}
