package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaMarca;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Fabricante;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioFabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fabricante")
public class FabricanteController {
    @Autowired
    private ServicioFabricante servicioFabricante;

    @GetMapping
    @CrossOrigin
    public List<Fabricante> obtenerTodosFabricantes() {
        return servicioFabricante.getAllFabricantes();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Fabricante> obtenerFabricantePorId(@PathVariable int id) {
        Fabricante fabricante = servicioFabricante.getFabricanteById(id);
        if (fabricante != null) {
            return ResponseEntity.ok(fabricante);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Fabricante> crearFabricante(@RequestBody Fabricante fabricante) {
        try {
            Fabricante nuevoFabricante = servicioFabricante.crearFabricante(fabricante);
            return ResponseEntity.ok(nuevoFabricante);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Fabricante> actualizarFabricante(@PathVariable int id, @RequestBody Fabricante fabricante) {
        try {
            Fabricante fabricanteActualizado = servicioFabricante.actualizarFabricante(id, fabricante);
            if (fabricanteActualizado != null) {
                return ResponseEntity.ok(fabricanteActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
