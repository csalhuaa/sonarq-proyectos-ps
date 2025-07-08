package com.rest_api_cigarrillos.demo.controllers.controllersReferenciales;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api_cigarrillos.demo.entities.referenciales.Rol;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioRol;

//@Controller
@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private ServicioRol servicioRol;

    @GetMapping
    @CrossOrigin
    public List<Rol> rolLista(){
        return servicioRol.getAllRol();
    }

    @PostMapping
    @CrossOrigin
    public Rol creaRol(@RequestBody Rol r){
        return servicioRol.crearRol(r);
    }
    
    @GetMapping("/{id}")
    @CrossOrigin
    public Rol  rolPorId(@PathVariable int id){
        return servicioRol.getRolById(id);
    }
    
    @PutMapping("/{id}")
    @CrossOrigin
    public Rol actualizarRol(@PathVariable int id ,@RequestBody Rol r){
        return servicioRol.actualizarRol(id, r);
    }
    @DeleteMapping("/{id}")
    @CrossOrigin
    public void eliminarRol(@PathVariable int id){
        servicioRol.borrarRol(id);
    }

}
