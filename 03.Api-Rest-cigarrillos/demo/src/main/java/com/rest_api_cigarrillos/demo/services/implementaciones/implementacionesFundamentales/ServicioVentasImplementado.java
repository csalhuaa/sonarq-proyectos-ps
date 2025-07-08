package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Ventas;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.VentasRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioVentas;

@Service
public class ServicioVentasImplementado  implements ServicioVentas{

    @Autowired
     private VentasRepository ventasRepository;

     @Override
     public List<Ventas> getAllVentas(){
        return ventasRepository.findAll();
     }
     @Override
     public Ventas getVentaById(int id){
        return ventasRepository.findById(id).orElse(null);
     }

     @Override
     public Ventas crearVentas(Ventas ventas){
        return ventasRepository.save(ventas);
     }
     @Override
     public Ventas actualizarVentas( int  id,Ventas ventas){
        Ventas venta = ventasRepository.findById(id).orElse(null);
        if(venta !=null){
            venta.setVenCigCan(ventas.getVenCigCan());
            venta.setVenCigEstReg(ventas.getVenCigEstReg());
           //venta.setRegistroVentas(ventas.getRegistroVentas());
             return ventasRepository.save(venta);

        }
        return null;
     }
     @Override
     public void eleminarVentas(int id){
        ventasRepository.deleteById(id);
     }

}
