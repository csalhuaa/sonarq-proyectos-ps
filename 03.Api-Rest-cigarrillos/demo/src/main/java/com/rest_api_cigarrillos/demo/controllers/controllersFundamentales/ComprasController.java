package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Compras;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/compra")
public class ComprasController {
    @Autowired
    private ServicioCompras servicioCompras;

    @GetMapping
    @CrossOrigin
    public List<Compras> listaCompras(){
        return servicioCompras.getAllCompras();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Compras obtenerComprasPorId(int id){
        return servicioCompras.getCompraById(id);
    }

    @PostMapping
    @CrossOrigin
    public Compras creaCompras(@RequestBody Compras compras){
        return servicioCompras.crearCompras(compras);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public Compras actulizaCompras(@PathVariable int id,@RequestBody Compras compras){
        return servicioCompras.actualizarCompras(id, compras);
    }
}
