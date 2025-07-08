package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import java.util.List;


import com.rest_api_cigarrillos.demo.entities.fundamentales.PedidoDetalle;


public interface ServicioPedidoDetalle {

    List<PedidoDetalle> getAllPedidoDetalles();
    PedidoDetalle getPedidoDetalleById(int id);
    PedidoDetalle crearPedidoDetalle(PedidoDetalle pedidoDetalle);
    PedidoDetalle actualizarPedidoDetalle(int id,PedidoDetalle pedidoDetalle);
    void eliminarPedidoDetalle(int id);
}
