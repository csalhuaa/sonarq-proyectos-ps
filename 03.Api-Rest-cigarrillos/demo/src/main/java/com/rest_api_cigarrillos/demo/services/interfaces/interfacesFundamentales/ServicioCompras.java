package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import java.util.List;


import com.rest_api_cigarrillos.demo.entities.fundamentales.Compras;

public interface ServicioCompras {
    List<Compras> getAllCompras();
    Compras getCompraById(int id);
    Compras crearCompras(Compras compras);
    Compras actualizarCompras(int id, Compras compras);
}
