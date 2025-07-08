package com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.Paises;

import java.util.List;

public interface ServicioPaises {
    List<Paises> getAllPaises();
    Paises getPaisById(int id);
    Paises crearPais(Paises pais);
    Paises actualizarPais(int id, Paises pais);
    void eliminarPais(int id);
}
