package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import java.util.List;


import com.rest_api_cigarrillos.demo.entities.fundamentales.Stock;

public interface ServicioStock {

    List<Stock> getAllStocks();
    Stock getStockById(int id);
    Stock crearStock(Stock stock);
    Stock actualizarStock(int id,Stock stock);
    void eliminarStock(int id);

 
}
