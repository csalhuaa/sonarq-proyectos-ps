package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaMarca;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Sede;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioSede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sede")
public class SedeController {
    @Autowired
    private ServicioSede servicioSede;

    @GetMapping
    @CrossOrigin
    public List<Sede> obtenerTodosSedes() {
        return servicioSede.getAllSedes();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Sede> obtenerSedePorId(@PathVariable int id) {
        Sede sede = servicioSede.getSedeById(id);
        if (sede != null) {
            return ResponseEntity.ok(sede);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Sede> crearSede(@RequestBody Sede sede) {
        try {
            Sede nuevaSede = servicioSede.crearSede(sede);
            return ResponseEntity.ok(nuevaSede);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Sede> actualizarSede(@PathVariable int id, @RequestBody Sede sede) {
        try {
            Sede sedeActualizado = servicioSede.actualizarSede(id, sede);
            if (sedeActualizado != null) {
                return ResponseEntity.ok(sedeActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
