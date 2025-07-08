package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Sede;

import java.util.List;

public interface ServicioSede {
    List<Sede> getAllSedes();
    Sede getSedeById(int id);
    Sede crearSede(Sede sede);
    Sede actualizarSede(int id, Sede sede);
}
