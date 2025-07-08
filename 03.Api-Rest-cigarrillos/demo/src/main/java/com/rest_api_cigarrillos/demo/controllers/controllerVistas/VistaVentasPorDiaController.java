package com.rest_api_cigarrillos.demo.controllers.controllerVistas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api_cigarrillos.demo.entities.EntidadVistas.VistaVentas;
import com.rest_api_cigarrillos.demo.services.ServicioVistas.ServicioVentaVista;

@RestController
@RequestMapping("/api/vista/ventas")
public class VistaVentasPorDiaController {

   @Autowired
   private ServicioVentaVista servicioVentaVista;

    @GetMapping
    @CrossOrigin
    public List<VistaVentas> getAllVentas() {
        return servicioVentaVista.getAllVentas();
    }
}