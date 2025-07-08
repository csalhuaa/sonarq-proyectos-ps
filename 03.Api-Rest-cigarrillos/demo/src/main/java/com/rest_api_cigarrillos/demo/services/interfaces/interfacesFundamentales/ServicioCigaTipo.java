package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaTipo;

import java.util.List;

public interface ServicioCigaTipo {
    List<CigaTipo> getAllCigaTipo();
    CigaTipo getCigaTipoById(int id);
    CigaTipo crearCigaTipo(CigaTipo cigaTipo);
    CigaTipo actualizarCigaTipo(int id, CigaTipo cigaTipo);
}
