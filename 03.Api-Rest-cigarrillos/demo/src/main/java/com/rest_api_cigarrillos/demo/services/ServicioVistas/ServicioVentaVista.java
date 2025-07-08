package com.rest_api_cigarrillos.demo.services.ServicioVistas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.EntidadVistas.VistaVentas;
import com.rest_api_cigarrillos.demo.repositories.vistas.VistaVentaRepository;

@Service
public class ServicioVentaVista {

    @Autowired
    private VistaVentaRepository vistaVentaRepository;

    public List<VistaVentas> getAllVentas() {
        return vistaVentaRepository.findAll();
    }
    
}
