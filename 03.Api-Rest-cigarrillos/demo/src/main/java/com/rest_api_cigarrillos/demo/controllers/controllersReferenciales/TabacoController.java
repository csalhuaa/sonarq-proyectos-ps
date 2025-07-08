package com.rest_api_cigarrillos.demo.controllers.controllersReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.Tabaco;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioTabaco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tabaco")
public class TabacoController {
    @Autowired
    private ServicioTabaco servicioTabaco;

    @GetMapping
    @CrossOrigin
    public List<Tabaco> tabacoLista() {
        return servicioTabaco.getAllTabaco();
    }

    @PostMapping
    @CrossOrigin
    public Tabaco crearTabaco(@RequestBody Tabaco tabaco) {
        return servicioTabaco.crearTabaco(tabaco);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Tabaco tabacoPorId(@PathVariable int id) {
        return servicioTabaco.getTabacoById(id);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public Tabaco actualizarTabaco(@PathVariable int id, @RequestBody Tabaco tabaco) {
        return servicioTabaco.actualizarTabaco(id, tabaco);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void eliminarTabaco(@PathVariable int id) {
        servicioTabaco.eliminarTabaco(id);
    }
}
