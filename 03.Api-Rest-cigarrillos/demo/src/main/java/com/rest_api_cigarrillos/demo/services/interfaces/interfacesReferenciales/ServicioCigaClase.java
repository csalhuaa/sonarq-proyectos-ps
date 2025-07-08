package com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaClase;

import java.util.List;

public interface ServicioCigaClase {
    List<CigaClase> getAllCigaClase();
    CigaClase getCigaClaseById(int id);
    CigaClase crearCigaClase(CigaClase cigaClase);
    CigaClase actualizarCigaClase(int id, CigaClase cigaClase);
    void eliminarCigaClase(int id);
}
