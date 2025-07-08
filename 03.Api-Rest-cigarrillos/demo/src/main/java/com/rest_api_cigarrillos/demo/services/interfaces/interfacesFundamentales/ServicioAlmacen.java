package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import java.util.List;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Almacen;


public interface ServicioAlmacen {

    List<Almacen> getAllAlmacen();
    Almacen getAlmacenById(int id);
    Almacen crearAlmacen(Almacen almacen);
    Almacen actualizarAlmacen(int id, Almacen almacen);
    void eliminarAlmacen(int id);


}
