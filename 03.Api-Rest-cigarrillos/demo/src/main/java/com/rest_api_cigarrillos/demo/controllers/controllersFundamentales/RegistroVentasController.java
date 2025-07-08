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

import com.rest_api_cigarrillos.demo.entities.fundamentales.RegistroVentas;

import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioRegistroVentas;



@RestController
@RequestMapping("api/registro_venta")
public class RegistroVentasController {

    @Autowired
    private ServicioRegistroVentas servicioRegistroVentas;

    @GetMapping
    @CrossOrigin
    public List<RegistroVentas> listaRegistroVentas(){
        return servicioRegistroVentas.getAllRegistroVentas();
    }
    @GetMapping("/{id}")
    @CrossOrigin
    public RegistroVentas obtenerRegistroVentasPorId(@PathVariable int id){
        return servicioRegistroVentas.getRegistroVentasById(id);
    }

    @PostMapping
    @CrossOrigin
    public RegistroVentas creaRegistroVentas(@RequestBody RegistroVentas registroVentas){
        return servicioRegistroVentas.crearRegistroVentas(registroVentas);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public RegistroVentas actulizaRegistroVentas(@PathVariable int id,@RequestBody RegistroVentas registroVentas){
        return servicioRegistroVentas.actualizarRegistroVentas(id, registroVentas);
    }
    
    @DeleteMapping
    @CrossOrigin
    public void eliminaRegistroVentas( @PathVariable int id){
        servicioRegistroVentas.eleminarRegistroVentas(id);
    }

}
