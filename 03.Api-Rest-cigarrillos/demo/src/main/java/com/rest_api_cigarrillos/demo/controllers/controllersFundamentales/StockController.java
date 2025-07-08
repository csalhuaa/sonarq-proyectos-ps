package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Stock;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioStock;

@RestController
@RequestMapping("api/stock")
public class StockController {
  
    @Autowired
    private ServicioStock servicioStock;
    
    @GetMapping
    public List<Stock> listStock(){
        return servicioStock.getAllStocks();
    }
    @GetMapping("/{id}")
    public Stock getStockPorId(@PathVariable int id){
        return servicioStock.getStockById(id);
    }
    @PostMapping
    public Stock creaStock(@RequestBody Stock stock){
        return servicioStock.crearStock(stock);
    }

    @PutMapping("/{id}")
    public Stock actualizaStock(@PathVariable int id,@RequestBody Stock stock ){
        return servicioStock.actualizarStock(id, stock);
    }

    @DeleteMapping
    public void eliminarStock( @PathVariable int id){
        servicioStock.eliminarStock(id);
    }
}
