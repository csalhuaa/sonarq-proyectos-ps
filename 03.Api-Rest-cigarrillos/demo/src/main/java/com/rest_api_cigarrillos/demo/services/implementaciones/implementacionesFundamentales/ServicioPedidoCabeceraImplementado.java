package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rest_api_cigarrillos.demo.entities.fundamentales.Estanco;
import com.rest_api_cigarrillos.demo.entities.fundamentales.PedidoCabecera;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.EstancoRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.PedidoCabeceraRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioPedidoCabecera;

@Service
public class ServicioPedidoCabeceraImplementado  implements ServicioPedidoCabecera{
   
    @Autowired
    private EstancoRepository estancoRepository;

    @Autowired
    private PedidoCabeceraRepository pedidoCabeceraRepository;

    @Override
    public List<PedidoCabecera> getAllPedidoCabeceras(){
        return pedidoCabeceraRepository.findAll();
    }
    @Override
    public  PedidoCabecera getPedidoCabeceraById(int id){
     return pedidoCabeceraRepository.findById(id).orElse(null);
    }
    @Override
    public PedidoCabecera crearPedidoCabecera(PedidoCabecera pedidoCabecera){
        // verifica  estanco
        Optional<Estanco> estancoOpt= 
        estancoRepository.findById(pedidoCabecera.getEstanco().getEstCod()); 
        if(!estancoOpt.isPresent()){
            throw  new IllegalArgumentException("estanco no encontrado");
        }
       pedidoCabecera.setEstanco(estancoOpt.get());
       
        return pedidoCabeceraRepository.save(pedidoCabecera);

    }
    @Override
    public  PedidoCabecera actualizarPedidoCabecera(int id, PedidoCabecera pedidoCabecera){
      PedidoCabecera pedido = pedidoCabeceraRepository.findById(id).orElse(null);
      if(pedido!=null){

        pedido.setPedCabFecAni(pedidoCabecera.getPedCabFecAni());
        pedido.setPedCabFecMes(pedidoCabecera.getPedCabFecMes());
        pedido.setPedCabFecDia(pedidoCabecera.getPedCabFecDia());
        pedido.setPedCabEstReg(pedidoCabecera.getPedCabEstReg());
         // verifica  estanco
         Optional<Estanco> estancoOpt= 
         estancoRepository.findById(pedidoCabecera.getEstanco().getEstCod()); 
         if(!estancoOpt.isPresent()){
             throw  new IllegalArgumentException("estanco no encontrado");
         }
         pedido.setEstanco(estancoOpt.get());

         return pedidoCabeceraRepository.save(pedido);
      }
       return null;
    }
    @Override
    public void eliminarPedidoCabecera(int id){
       pedidoCabeceraRepository.deleteById(id);
    }

}
