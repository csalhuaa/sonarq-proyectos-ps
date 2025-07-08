package com.rest_api_cigarrillos.demo.services.ServicioVistas;

import com.rest_api_cigarrillos.demo.entities.EntidadVistas.VistaCompras;
import com.rest_api_cigarrillos.demo.repositories.vistas.VistaCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCompraVista {
    @Autowired
    private VistaCompraRepository vistaCompraRepository;

    public List<VistaCompras> getAllCompras() {
        return vistaCompraRepository.findAll();
    }
}
