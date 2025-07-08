package com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales;

import java.util.List;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaMentolado;

public interface ServicioCigaMentolado {
    List<CigaMentolado> getAllCigaMentolado();
    CigaMentolado getCigaMentoladoById(int id);
    CigaMentolado crearCigaMentolado(CigaMentolado cigaMentolado);
    CigaMentolado actualizarCigaMentolado(int id, CigaMentolado cigaMentolado);
    void eliminarCigaMentolado(int id);
}
