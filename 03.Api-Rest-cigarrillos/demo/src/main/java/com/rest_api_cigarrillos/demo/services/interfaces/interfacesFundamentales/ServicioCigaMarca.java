package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaMarca;

import java.util.List;

public interface ServicioCigaMarca {
    List<CigaMarca> getAllCigaMarca();
    CigaMarca getCigaMarcaById(int id);
    CigaMarca crearCigaMarca(CigaMarca cigaMarca);
    CigaMarca actualizarCigaMarca(int id, CigaMarca cigaMarca);
}