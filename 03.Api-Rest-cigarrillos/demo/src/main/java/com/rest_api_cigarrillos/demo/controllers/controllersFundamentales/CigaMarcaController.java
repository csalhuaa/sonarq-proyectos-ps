package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaMarca;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioCigaMarca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/marca")
public class CigaMarcaController {
    @Autowired
    private ServicioCigaMarca servicioCigaMarca;

    @GetMapping
    @CrossOrigin
    public List<CigaMarca> obtenerTodosCigaMarca() {
        return servicioCigaMarca.getAllCigaMarca();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<CigaMarca> obtenerCigaMarcaPorId(@PathVariable int id) {
        CigaMarca cigaMarca = servicioCigaMarca.getCigaMarcaById(id);
        if (cigaMarca != null) {
            return ResponseEntity.ok(cigaMarca);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<CigaMarca> crearCigaMarca(@RequestBody CigaMarca cigaMarca) {
        try {
            CigaMarca nuevoCigaMarca = servicioCigaMarca.crearCigaMarca(cigaMarca);
            return ResponseEntity.ok(nuevoCigaMarca);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<CigaMarca> actualizarCigaMarca(@PathVariable int id, @RequestBody CigaMarca cigaMarca) {
        try {
            CigaMarca cigaMarcaActualizado = servicioCigaMarca.actualizarCigaMarca(id, cigaMarca);
            if (cigaMarcaActualizado != null) {
                return ResponseEntity.ok(cigaMarcaActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
