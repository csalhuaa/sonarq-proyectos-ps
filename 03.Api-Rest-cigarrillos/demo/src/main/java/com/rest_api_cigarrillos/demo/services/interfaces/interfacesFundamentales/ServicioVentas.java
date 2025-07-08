package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import java.util.List;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Ventas;

public interface ServicioVentas {

    List<Ventas> getAllVentas();
    Ventas getVentaById(int id);
    Ventas crearVentas(Ventas ventas);
    Ventas actualizarVentas(int id, Ventas ventas);
    void eleminarVentas(int id);

}
