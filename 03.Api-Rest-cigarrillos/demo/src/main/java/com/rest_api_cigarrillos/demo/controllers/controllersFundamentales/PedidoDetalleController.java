package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api_cigarrillos.demo.entities.fundamentales.PedidoDetalle;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioPedidoDetalle;

@RestController
@RequestMapping("api/pedido_detalle")
public class PedidoDetalleController {

    @Autowired
    private ServicioPedidoDetalle servicioPedidoDetalle;

    @GetMapping
    @CrossOrigin
    public List<PedidoDetalle> listaPedidoCabecera(){
        return servicioPedidoDetalle.getAllPedidoDetalles();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public PedidoDetalle getPedidoDetallePorId(@PathVariable int id){
        return servicioPedidoDetalle.getPedidoDetalleById(id);
    }

    @PostMapping
    @CrossOrigin
    public PedidoDetalle creaPedidoDetalle(@RequestBody PedidoDetalle pedidoDetalle){
        return servicioPedidoDetalle.crearPedidoDetalle(pedidoDetalle);
    }
    @PutMapping("/{id}")
    @CrossOrigin
    public PedidoDetalle actualizaPedidoDetalle(@PathVariable int id,@RequestBody PedidoDetalle pedidoDetalle){
        return servicioPedidoDetalle.actualizarPedidoDetalle(id, pedidoDetalle);
    }
    @DeleteMapping
    @CrossOrigin
    public void eliminaPedidoDetalle(@PathVariable int id){
        servicioPedidoDetalle.eliminarPedidoDetalle(id);

    }

}
