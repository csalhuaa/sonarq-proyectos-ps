package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import java.util.List;


import com.rest_api_cigarrillos.demo.entities.fundamentales.PedidoCabecera;


public interface ServicioPedidoCabecera {

    List<PedidoCabecera> getAllPedidoCabeceras();
    PedidoCabecera getPedidoCabeceraById(int id);
    PedidoCabecera crearPedidoCabecera(PedidoCabecera pedidoCabecera);
    PedidoCabecera actualizarPedidoCabecera(int id, PedidoCabecera pedidoCabecera);
    void eliminarPedidoCabecera(int id);


}
