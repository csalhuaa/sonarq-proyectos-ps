package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import java.util.List;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Estanco;
//import com.rest_api_cigarrillos.demo.entities.referenciales.CigaClase;

public interface ServicioEstanco {
    List<Estanco> getAllEstanco();
    Estanco getEstancoById(int id);
    Estanco crearEstanco(Estanco estanco);
    Estanco actualizarEstanco(int id, Estanco estanco);
    void eliminarEstanco(int id);

}
