package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import com.rest_api_cigarrillos.demo.entities.fundamentales.PedidoCabecera;
import com.rest_api_cigarrillos.demo.entities.fundamentales.PedidoDetalle;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigarrillosRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.PedidoCabeceraRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.PedidoDetalleRepository;

import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioPedidoDetalle;

@Service
public class ServicioPedidoDetalleImplementado implements ServicioPedidoDetalle {
    @Autowired
    private CigarrillosRepository cigarrillosRepository;
    @Autowired
    private  PedidoCabeceraRepository pedidoCabeceraRepository;

    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    @Override
    public  List<PedidoDetalle> getAllPedidoDetalles(){
        return  pedidoDetalleRepository.findAll();
    }
    @Override
     public PedidoDetalle getPedidoDetalleById(int id){
        return pedidoDetalleRepository.findById(id).orElse(null);
     }

    @Override 
    public PedidoDetalle crearPedidoDetalle(PedidoDetalle pedidoDetalle){
        //verifica cigarrillo
        Optional<Cigarrillos> cigarrilloOpt=
        cigarrillosRepository.findById(pedidoDetalle.getCigarrillos().getCigCod());
        if(!cigarrilloOpt.isPresent()){
            throw  new IllegalArgumentException("cigarrillo no encontrado");
        }
        // verifica pedido cabecera
        Optional<PedidoCabecera> pedidoCabeceraOpt=
        pedidoCabeceraRepository.findById(pedidoDetalle.getPedidoCabecera().getPedCabCod());

        if(!pedidoCabeceraOpt.isPresent()){
            throw  new IllegalArgumentException("cigarrillo no encontrado");
        }
        pedidoDetalle.setPedidoCabecera(pedidoCabeceraOpt.get());
        pedidoDetalle.setPedDetPedCabEstCod(pedidoCabeceraOpt.get().getEstanco().getEstCod());
        pedidoDetalle.setCigarrillos(cigarrilloOpt.get());
        
        return pedidoDetalleRepository.save(pedidoDetalle);
    }
    @Override
    public  PedidoDetalle actualizarPedidoDetalle(int id,PedidoDetalle pedidoDetalle){
        PedidoDetalle pedidoDet= pedidoDetalleRepository.findById(id).orElse(null);
        if(pedidoDet!=null){
            pedidoDet.setPedDetCigCan(pedidoDetalle.getPedDetCigCan());
            pedidoDet.setPedDetEstReg(pedidoDetalle.getPedDetEstReg());
         
        //verifica cigarrillo    
        Optional<Cigarrillos> cigarrilloOpt=
        cigarrillosRepository.findById(pedidoDetalle.getCigarrillos().getCigCod());
        if(!cigarrilloOpt.isPresent()){
            throw  new IllegalArgumentException("cigarrillo no encontrado");
        }
        //verifica pedido cabcera
        Optional<PedidoCabecera> pedidoCabeceraOpt=
        pedidoCabeceraRepository.findById(pedidoDetalle.getPedidoCabecera().getPedCabCod());

        if(!pedidoCabeceraOpt.isPresent()){
            throw  new IllegalArgumentException("cigarrillo no encontrado");
        }
        pedidoDet.setPedidoCabecera(pedidoCabeceraOpt.get());
        pedidoDet.setPedDetPedCabEstCod(pedidoCabeceraOpt.get().getEstanco().getEstCod());
        pedidoDet.setCigarrillos(cigarrilloOpt.get());

         return pedidoDetalleRepository.save(pedidoDet);

        }

        return null;
    }

    @Override
    public void eliminarPedidoDetalle(int id){
        pedidoDetalleRepository.deleteById(id);
    }

}
