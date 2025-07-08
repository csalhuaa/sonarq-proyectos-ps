package com.rest_api_cigarrillos.demo.controllers.controllersReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaMentolado;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioCigaMentolado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentolado")
public class CigaMentoladoController {
    @Autowired
    private ServicioCigaMentolado servicioCigaMentolado;

    @GetMapping
    @CrossOrigin
    public List<CigaMentolado> cigaMentoladoLista() {
        return servicioCigaMentolado.getAllCigaMentolado();
    }

    @PostMapping
    @CrossOrigin
    public CigaMentolado crearCigaMentolado(@RequestBody CigaMentolado cigaMentolado) {
        return servicioCigaMentolado.crearCigaMentolado(cigaMentolado);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public  CigaMentolado cigaMentoladoPorId(@PathVariable int id) {
        return servicioCigaMentolado.getCigaMentoladoById(id);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public CigaMentolado actualizarCigaMentolado(@PathVariable int id, @RequestBody CigaMentolado cigaMentolado) {
        return servicioCigaMentolado.actualizarCigaMentolado(id, cigaMentolado);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public void eliminarCigaMentolado(@PathVariable int id) {
        servicioCigaMentolado.eliminarCigaMentolado(id);
    }
}
