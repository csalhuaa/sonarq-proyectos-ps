package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Fabricante;

import java.util.List;

public interface ServicioFabricante {
    List<Fabricante> getAllFabricantes();
    Fabricante getFabricanteById(int id);
    Fabricante crearFabricante(Fabricante fabricante);
    Fabricante actualizarFabricante(int id, Fabricante fabricante);
}
