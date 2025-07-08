package com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaFiltro;

import java.util.List;

public interface ServicioCigaFiltro {
    List<CigaFiltro> getAllCigaFiltro();
    CigaFiltro getCigaFiltroById(int id);
    CigaFiltro crearCigaFiltro(CigaFiltro cigaFiltro);
    CigaFiltro actualizarCigaFiltro(int id, CigaFiltro cigaFiltro);
    void eliminarCigaFiltro(int id);
}
