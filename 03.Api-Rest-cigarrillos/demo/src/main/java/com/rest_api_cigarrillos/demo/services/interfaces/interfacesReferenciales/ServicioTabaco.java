package com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.Tabaco;

import java.util.List;

public interface ServicioTabaco {
    List<Tabaco> getAllTabaco();
    Tabaco getTabacoById(int id);
    Tabaco crearTabaco(Tabaco tabaco);
    Tabaco actualizarTabaco(int id, Tabaco tabaco);
    void eliminarTabaco(int id);
}
