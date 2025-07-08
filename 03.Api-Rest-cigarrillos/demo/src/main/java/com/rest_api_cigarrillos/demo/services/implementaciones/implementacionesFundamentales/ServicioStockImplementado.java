package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Almacen;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Stock;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.AlmacenRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigarrillosRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.StockRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioStock;

@Service
public class ServicioStockImplementado implements ServicioStock {
    
    @Autowired
    private CigarrillosRepository cigarrillosRepository;
    @Autowired
    private AlmacenRepository almacenRepository;
    @Autowired
    private  StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    @Override
     public Stock getStockById(int id){
        return stockRepository.findById(id).orElse(null);
     }
    @Override
     public Stock crearStock(Stock stock){
        Optional<Almacen> almacenOpt =
        almacenRepository.findById(stock.getAlmacen().getAlmCod());
        if(!almacenOpt.isPresent()){
            throw  new IllegalArgumentException("almacen no encontrado");
        }
        //verifica cigarrillo
        Optional<Cigarrillos> cigarrilloOpt=
        cigarrillosRepository.findById(stock.getCigarrillos().getCigCod());
        if(!cigarrilloOpt.isPresent()){
            throw  new IllegalArgumentException("cigarrillo no encontrado");
        }
        stock.setAlmacen(almacenOpt.get());
        
        stock.setStoAlmEstCod(almacenOpt.get().getEstanco().getEstCod());
        stock.setCigarrillos(cigarrilloOpt.get());
        return stockRepository.save(stock);
     }

    @Override
    public Stock actualizarStock(int id,Stock stock){
       Stock stockk= stockRepository.findById(id).orElse(null);
       if(stockk!=null){
         stockk.setStoCan(stock.getStoCan());
         stockk.setStoMinCan(stock.getStoMinCan());
         stockk.setStoEstReg(stock.getStoEstReg());
         Optional<Almacen> almacenOpt =
         almacenRepository.findById(stock.getAlmacen().getAlmCod());
         if(!almacenOpt.isPresent()){
             throw  new IllegalArgumentException("almacen no encontrado");
         }
         //verifica cigarrillo
         Optional<Cigarrillos> cigarrilloOpt=
         cigarrillosRepository.findById(stock.getCigarrillos().getCigCod());
         if(!cigarrilloOpt.isPresent()){
             throw  new IllegalArgumentException("cigarrillo no encontrado");
         }
         stockk.setAlmacen(almacenOpt.get());
         
         stockk.setStoAlmEstCod(almacenOpt.get().getEstanco().getEstCod());
         stockk.setCigarrillos(cigarrilloOpt.get());
         return stockRepository.save(stockk);

       }
       return null;
    }

    @Override
    public void eliminarStock(int id){
        stockRepository.deleteById(id);
    }


}
