package com.rest_api_cigarrillos.demo.controllers.controllersReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaFiltro;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioCigaFiltro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filtro")
public class CigaFiltroController {
    @Autowired
    private ServicioCigaFiltro servicioCigaFiltro;

    @GetMapping
    @CrossOrigin
    public List<CigaFiltro> cigaFiltroLista() {
        return servicioCigaFiltro.getAllCigaFiltro();
    }

    @PostMapping
    @CrossOrigin
    public CigaFiltro crearCigaFiltro(@RequestBody CigaFiltro cigaFiltro) {
        return servicioCigaFiltro.crearCigaFiltro(cigaFiltro);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public CigaFiltro cigaFiltroPorId(@PathVariable int id) {
        return servicioCigaFiltro.getCigaFiltroById(id);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public CigaFiltro actualizarCigaFiltro(@PathVariable int id, @RequestBody CigaFiltro cigaFiltro) {
        return servicioCigaFiltro.actualizarCigaFiltro(id, cigaFiltro);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void eliminarCigaFiltro(@PathVariable int id) {
        servicioCigaFiltro.eliminarCigaFiltro(id);
    }
}
