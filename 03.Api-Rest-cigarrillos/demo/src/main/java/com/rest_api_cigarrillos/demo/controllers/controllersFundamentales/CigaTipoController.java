package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaMarca;
import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaTipo;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioCigaTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tipo")
public class CigaTipoController {
    @Autowired
    private ServicioCigaTipo servicioCigaTipo;

    @GetMapping
    @CrossOrigin
    public List<CigaTipo> obtenerTodosCigaTipo() {
        return servicioCigaTipo.getAllCigaTipo();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<CigaTipo> obtenerCigaTipoPorId(@PathVariable int id) {
        CigaTipo cigaTipo = servicioCigaTipo.getCigaTipoById(id);
        if (cigaTipo != null) {
            return ResponseEntity.ok(cigaTipo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<CigaTipo> crearCigaTipo(@RequestBody CigaTipo CigaTipo) {
        try {
            CigaTipo nuevoCigaTipo = servicioCigaTipo.crearCigaTipo(CigaTipo);
            return ResponseEntity.ok(nuevoCigaTipo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<CigaTipo> actualizarCigaMarca(@PathVariable int id, @RequestBody CigaTipo cigaTipo) {
        try {
            CigaTipo cigaTipoActualizado = servicioCigaTipo.actualizarCigaTipo(id, cigaTipo);
            if (cigaTipoActualizado != null) {
                return ResponseEntity.ok(cigaTipoActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
