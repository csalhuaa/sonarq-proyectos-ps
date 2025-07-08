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

import com.rest_api_cigarrillos.demo.entities.fundamentales.PedidoCabecera;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioPedidoCabecera;

@RestController
@RequestMapping("api/pedido_cabecera")
public class PedidoCabeceraController {

    @Autowired
    private ServicioPedidoCabecera servicioPedidoCabecera;

    @GetMapping
    @CrossOrigin
    public List<PedidoCabecera> listaPedidoCabecera(){
        return servicioPedidoCabecera.getAllPedidoCabeceras();
    }
    @GetMapping("/{id}")
    @CrossOrigin
    public PedidoCabecera getPedidoCabecera(@PathVariable int id){
        return servicioPedidoCabecera.getPedidoCabeceraById(id);
    }

    @PostMapping
    @CrossOrigin
    public PedidoCabecera creaPedidoCabecera(@RequestBody PedidoCabecera pedidoCabecera){
        return servicioPedidoCabecera.crearPedidoCabecera(pedidoCabecera);
    }
    @PutMapping("/{id}")
    @CrossOrigin
    public PedidoCabecera actualizaPedidoCabecera(@PathVariable  int id,@RequestBody PedidoCabecera pedidoCabecera){
        return servicioPedidoCabecera.actualizarPedidoCabecera(id, pedidoCabecera);
    }

    @DeleteMapping
    public void eliminaPedidoCabecera(@PathVariable int id){
      servicioPedidoCabecera.eliminarPedidoCabecera(id);
    }

}
