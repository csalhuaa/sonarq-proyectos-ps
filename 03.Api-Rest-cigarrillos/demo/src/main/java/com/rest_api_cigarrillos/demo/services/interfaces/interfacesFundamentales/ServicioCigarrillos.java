package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;

import java.util.List;

public interface ServicioCigarrillos {
    List<Cigarrillos> getAllCigarrillos();
    Cigarrillos getCigarrillosById(int id);
    Cigarrillos crearCigarrillos(Cigarrillos cigarrillos);
    Cigarrillos actualizarCigarrillos(int id, Cigarrillos cigarrillos);
}
