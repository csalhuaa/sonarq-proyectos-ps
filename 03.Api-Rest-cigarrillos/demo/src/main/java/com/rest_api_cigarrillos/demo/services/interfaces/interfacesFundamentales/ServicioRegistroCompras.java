package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import java.util.List;

import com.rest_api_cigarrillos.demo.entities.fundamentales.RegistroCompras;

public interface ServicioRegistroCompras {
    List<RegistroCompras> getAllRegistroCompras();
    RegistroCompras getRegistroComprasById(int id);
    RegistroCompras crearRegistroCompras(RegistroCompras registroCompras);
    RegistroCompras actualizarRegistroCompras(int id,RegistroCompras registroCompras);
}
