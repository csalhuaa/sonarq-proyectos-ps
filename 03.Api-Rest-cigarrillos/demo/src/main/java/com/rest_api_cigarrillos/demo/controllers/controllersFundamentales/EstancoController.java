package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Estanco;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioEstanco;

@RestController
@RequestMapping("api/estanco")
public class EstancoController {

    @Autowired
    private ServicioEstanco servicioEstanco;

    @GetMapping
    @CrossOrigin
    public List<Estanco> obtenerTodosLosEstancos() {
        return servicioEstanco.getAllEstanco();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Estanco> obtenerEstancoPorId(@PathVariable int id) {
        Estanco estanco = servicioEstanco.getEstancoById(id);
        if (estanco != null) {
            return ResponseEntity.ok(estanco);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Estanco> crearEstanco(@RequestBody Estanco estanco) {
        try {
            Estanco nuevoEstanco = servicioEstanco.crearEstanco(estanco);
            return ResponseEntity.ok(nuevoEstanco);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Estanco> actualizarEstanco(@PathVariable int id, @RequestBody Estanco estanco) {
        try {
            Estanco actualizadoEstanco = servicioEstanco.actualizarEstanco(id, estanco);
            if (actualizadoEstanco != null) {
                return ResponseEntity.ok(actualizadoEstanco);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> eliminarEstanco(@PathVariable int id) {
        servicioEstanco.eliminarEstanco(id);
        return ResponseEntity.noContent().build();
    }
}
