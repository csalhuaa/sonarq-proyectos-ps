package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Estanco;
import com.rest_api_cigarrillos.demo.entities.fundamentales.RegistroVentas;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Ventas;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigarrillosRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.EstancoRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.RegistroVentasRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.VentasRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioRegistroVentas;

@Service
public class ServicioRegistroVentasImplementado  implements ServicioRegistroVentas{


  
    @Autowired
    private CigarrillosRepository cigarrillosRepository;

    @Autowired
    private EstancoRepository estancoRepository;

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private RegistroVentasRepository registroVentasRepository;

    @Override
    public List<RegistroVentas> getAllRegistroVentas(){
        return  registroVentasRepository.findAll();
    }

    @Override
    public RegistroVentas getRegistroVentasById(int id){
        return registroVentasRepository.findById(id).orElse(null);
    }

    @Override
    public RegistroVentas crearRegistroVentas( RegistroVentas registroVentas){
        // verifica  estanco
        Optional<Estanco> estancoOpt= 
        estancoRepository.findById(registroVentas.getEstanco().getEstCod()); 
        if(!estancoOpt.isPresent()){
            throw  new IllegalArgumentException("estanco no encontrado");
        }
        //verifica cigarrillo
        Optional<Cigarrillos> cigarrilloOpt=
        cigarrillosRepository.findById(registroVentas.getCigarrillos().getCigCod());
        if(!cigarrilloOpt.isPresent()){
            throw  new IllegalArgumentException("cigarrillo no encontrado");
        }

        //verifica Venta
        Optional<Ventas> ventaOpt=
        ventasRepository.findById(registroVentas.getVentas().getVenCigCod());
        if(!ventaOpt.isPresent()){
            throw  new IllegalArgumentException("vanta no encontrado");
        }

        //realciones
        registroVentas.setEstanco(estancoOpt.get());
        registroVentas.setCigarrillos(cigarrilloOpt.get());
        registroVentas.setVentas(ventaOpt.get());

        return registroVentasRepository.save(registroVentas);

    }

    @Override
    public RegistroVentas actualizarRegistroVentas(int id , RegistroVentas registroVentas){
       RegistroVentas registro =registroVentasRepository.findById(id).orElse(null);
       if(registro!=null){
        registro.setRegVenCigCan(registroVentas.getRegVenCigCan());
        registro.setRegVenFecAni(registroVentas.getRegVenFecAni());
        registro.setRegVenFecMes(registroVentas.getRegVenFecMes());
        registro.setRegVenFecDia(registroVentas.getRegVenFecDia());
        registro.setRegVenEstReg(registroVentas.getRegVenEstReg());


        Optional<Estanco> estancoOpt= 
        estancoRepository.findById(registroVentas.getEstanco().getEstCod()); 
        if(!estancoOpt.isPresent()){
            throw  new IllegalArgumentException("estanco no encontrado");
        }
        //verifica cigarrillo
        Optional<Cigarrillos> cigarrilloOpt=
        cigarrillosRepository.findById(registroVentas.getCigarrillos().getCigCod());
        if(!cigarrilloOpt.isPresent()){
            throw  new IllegalArgumentException("cigarrillo no encontrado");
        }

        //verifica Venta
        Optional<Ventas> ventaOpt=
        ventasRepository.findById(registroVentas.getVentas().getVenCigCod());
        if(!ventaOpt.isPresent()){
            throw  new IllegalArgumentException("vanta no encontrado");
        }

        //realciones
        registro.setEstanco(estancoOpt.get());
        registro.setCigarrillos(cigarrilloOpt.get());
        registro.setVentas(ventaOpt.get());

        return registroVentasRepository.save(registro);
       }
       return null;
    }
    @Override
    public void eleminarRegistroVentas(int id){
        registroVentasRepository.deleteById(id);
    }



}
