package com.rest_api_cigarrillos.demo.controllers.controllerVistas;

import com.rest_api_cigarrillos.demo.entities.EntidadVistas.VistaCompras;
import com.rest_api_cigarrillos.demo.services.ServicioVistas.ServicioCompraVista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vista/compras")
public class VistaComprasPorDiaController {
    @Autowired
    private ServicioCompraVista servicioCompraVista;

    @GetMapping
    @CrossOrigin
    public List<VistaCompras> getAllCompras() {
        return servicioCompraVista.getAllCompras();
    }
}
