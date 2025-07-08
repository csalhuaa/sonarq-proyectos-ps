package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

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

import com.rest_api_cigarrillos.demo.entities.fundamentales.Ventas;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioVentas;

@RestController
@RequestMapping("api/venta")
public class VentasController {

    @Autowired
    private ServicioVentas servicioVentas;
    
    @GetMapping
    @CrossOrigin
    public List<Ventas> listaVentas(){
        return servicioVentas.getAllVentas();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Ventas getVentaPorId(@PathVariable int id){
        return servicioVentas.getVentaById(id);
    }

    @PostMapping
    @CrossOrigin
    public Ventas creaVentas(@RequestBody Ventas ventas){
        return servicioVentas.crearVentas(ventas);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public Ventas actualizaVentas(@PathVariable int id, @RequestBody Ventas ventas){
        return servicioVentas.actualizarVentas(id, ventas);
    }

    @DeleteMapping
    @CrossOrigin
    public void eliminaVentas( @PathVariable  int id){
        servicioVentas.eleminarVentas(id);
    }

}
