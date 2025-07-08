package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioCigarrillos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cigarrillo")
public class CigarrillosController {
    @Autowired
    private ServicioCigarrillos servicioCigarrillos;

    @GetMapping
    @CrossOrigin
    public List<Cigarrillos> obtenerTodosCigarrillos() {
        return servicioCigarrillos.getAllCigarrillos();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Cigarrillos> obtenerCigarrilloPorId(@PathVariable int id) {
        Cigarrillos cigarrillos = servicioCigarrillos.getCigarrillosById(id);
        if (cigarrillos != null) {
            return ResponseEntity.ok(cigarrillos);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Cigarrillos> crearCigarrillo(@RequestBody Cigarrillos cigarrillos) {
        try {
            Cigarrillos nuevoCigarrillo = servicioCigarrillos.crearCigarrillos(cigarrillos);
            return ResponseEntity.ok(nuevoCigarrillo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Cigarrillos> actualizarCigarrillo(@PathVariable int id, @RequestBody Cigarrillos cigarrillos) {
        try {
            Cigarrillos cigarrilloActualizado = servicioCigarrillos.actualizarCigarrillos(id, cigarrillos);
            if (cigarrilloActualizado != null) {
                return ResponseEntity.ok(cigarrilloActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
