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

import com.rest_api_cigarrillos.demo.entities.referenciales.Region;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioRegion;

@RestController
@RequestMapping("/api/region")
public class RegionController {
    @Autowired
    private ServicioRegion servicioRegion;

    @GetMapping
    @CrossOrigin
    public List<Region> regionLista(){
        return servicioRegion.getAllRegion();
    }

    @PostMapping
    @CrossOrigin
    public Region creaRegion(@RequestBody Region region){
        return servicioRegion.crearRegion(region);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Region regionPorId(@PathVariable int id){
        return servicioRegion.getRegionById(id);

    }

    @PutMapping("/{id}")
    @CrossOrigin
    public Region actualizaRegion(@PathVariable int  id, @RequestBody Region region){
        return servicioRegion.actualizarRegion(id, region);
    }
    @DeleteMapping("/{id}")
    public void eliminaRegion(@PathVariable int id){
        servicioRegion.borrarRegion(id);
    }
}
