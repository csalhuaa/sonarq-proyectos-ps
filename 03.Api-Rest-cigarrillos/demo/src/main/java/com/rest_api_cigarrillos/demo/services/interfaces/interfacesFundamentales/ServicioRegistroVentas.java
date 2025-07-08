package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import java.util.List;

import com.rest_api_cigarrillos.demo.entities.fundamentales.RegistroVentas;

public interface ServicioRegistroVentas {

    List<RegistroVentas> getAllRegistroVentas();
    RegistroVentas getRegistroVentasById(int id);
    RegistroVentas crearRegistroVentas (RegistroVentas registroVentas);
    RegistroVentas actualizarRegistroVentas(int id,RegistroVentas registroVentas);
    void eleminarRegistroVentas(int id);

}
