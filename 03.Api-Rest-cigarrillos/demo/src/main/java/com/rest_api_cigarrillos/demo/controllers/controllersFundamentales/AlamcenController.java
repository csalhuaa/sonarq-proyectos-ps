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

import com.rest_api_cigarrillos.demo.entities.fundamentales.Almacen;

import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioAlmacen;

@RestController
@RequestMapping("api/almacen")
public class AlamcenController {

    @Autowired
    private ServicioAlmacen servicioAlmacen;

    @GetMapping
    @CrossOrigin
    public List<Almacen> listaAlmacenes(){
        return servicioAlmacen.getAllAlmacen();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Almacen  almacenPorId(@PathVariable  int id){
        return servicioAlmacen.getAlmacenById(id);
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Almacen> crearAlmacen(@RequestBody Almacen almacen) {
        try {
            Almacen nuevoAlmacen = servicioAlmacen.crearAlmacen(almacen);
            return ResponseEntity.ok(nuevoAlmacen);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Almacen> actualizarEstanco(@PathVariable int id, @RequestBody Almacen almacen) {
        try {
            Almacen actualizadoAlmacen = servicioAlmacen.actualizarAlmacen(id, almacen);
            if (actualizadoAlmacen != null) {
                return ResponseEntity.ok(actualizadoAlmacen);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Void> eliminarEstanco(@PathVariable int id) {
        servicioAlmacen.eliminarAlmacen(id);
        return ResponseEntity.noContent().build();
    }
}
