package com.rest_api_cigarrillos.demo.controllers.controllersReferenciales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api_cigarrillos.demo.entities.referenciales.UbicacionGeografica;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioUbicacionGeografica;

@RestController
@RequestMapping("api/ubicacion")
public class UbicacionGeograficaController {
    @Autowired
    private ServicioUbicacionGeografica servicioUbicacionGeografica;
    
    @GetMapping
    @CrossOrigin
    public List<UbicacionGeografica> listaUbicacionGeografica(){
        return servicioUbicacionGeografica.getAllUbicacionGeografica();
    }
    @GetMapping("/{id}")
    @CrossOrigin
    public UbicacionGeografica  ubicacionGeograficaPorId(@PathVariable int id){
        return servicioUbicacionGeografica.getUbicacionGeograficaPorId(id);
    }
    @PostMapping
    @CrossOrigin
    public UbicacionGeografica creaUbicacionGeografica(@RequestBody UbicacionGeografica ubicacionGeografica){
        return servicioUbicacionGeografica.crearUbicacionGeografica(ubicacionGeografica);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public UbicacionGeografica actualizaUbicacionGeografica(@PathVariable int id,@RequestBody UbicacionGeografica ubicacionGeografica){
        return servicioUbicacionGeografica.actualizarUbicacionGeografica(id, ubicacionGeografica);
    }
    @DeleteMapping("/{id}")
    @CrossOrigin
    public void eliminaUbicacionGeografica(@PathVariable int id){
        servicioUbicacionGeografica.borrarUbicacionGeografica(id);
    }
    




}
