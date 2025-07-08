package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.RegistroCompras;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioRegistroCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/registro_compra")
public class RegistroComprasController {
    @Autowired
    private ServicioRegistroCompras servicioRegistroCompras;

    @GetMapping
    @CrossOrigin
    public List<RegistroCompras> lsitaRegistroCompras(){
        return servicioRegistroCompras.getAllRegistroCompras();
    }
    @GetMapping("/{id}")
    @CrossOrigin
    public RegistroCompras obtenerRegistroComprasPorId(@PathVariable int id){
        return servicioRegistroCompras.getRegistroComprasById(id);
    }

    @PostMapping
    @CrossOrigin
    public RegistroCompras creaRegistroCompras(@RequestBody RegistroCompras registroCompras){
        return servicioRegistroCompras.crearRegistroCompras(registroCompras);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public RegistroCompras actulizaRegistroCompras(@PathVariable int id,@RequestBody RegistroCompras registroCompras){
        return servicioRegistroCompras.actualizarRegistroCompras(id, registroCompras);
    }
}
