package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Almacen;
//import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Estanco;


import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.AlmacenRepository;
//import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigarrillosRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.EstancoRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioAlmacen;


@Service
public class ServicioAlmacenImplementado  implements ServicioAlmacen{
      
    @Autowired
    private AlmacenRepository almacenRepository;

    @Autowired
    private EstancoRepository estancoRepository;
    
    //@Autowired
    //private CigarrillosRepository cigarrillosRepository;

    @Override
    public  List<Almacen>  getAllAlmacen(){
        return almacenRepository.findAll();
    }

    @Override
    public Almacen getAlmacenById( int id){
         return almacenRepository.findById(id).orElse(null);
    }
    
    @Override
    public Almacen crearAlmacen( Almacen almacen){
          // Verificar Estanco
        Optional<Estanco> estancoOpt = 
            estancoRepository.findById(almacen.getEstanco().getEstCod());
        if (!estancoOpt.isPresent()) {
            throw new IllegalArgumentException("Estanco no encontrada");
        }
        
        /*// Verificar Cigarrillo
        Optional<Cigarrillos> cigarrilloOpt = 
            cigarrillosRepository.findById(almacen.getCigarrillos().getCigCod());
        if (!cigarrilloOpt.isPresent()) {
            throw new IllegalArgumentException("Cigarrillo no encontrado");
        }*/

        // Establecer las relaciones
        almacen.setEstanco(estancoOpt.get());
        //almacen.setCigarrillos(cigarrilloOpt.get());

        return almacenRepository.save(almacen);
    }

    @Override
    public  Almacen actualizarAlmacen(int id ,Almacen almacen){
        Almacen almacenExistente = almacenRepository.findById(id).orElse(null);
        if (almacenExistente != null) {
            almacenExistente.setAlmCanCig(almacen.getAlmCanCig());
            almacenExistente.setAlmCanMaxCig(almacen.getAlmCanMaxCig());
            almacenExistente.setAlmCanMinCig(almacen.getAlmCanMinCig());
            almacenExistente.setAlmCanSegCig(almacen.getAlmCanSegCig());
            almacenExistente.setAlmEstReg(almacen.getAlmEstReg());
                      // Verificar Estanco
        Optional<Estanco> estancoOpt = 
        estancoRepository.findById(almacen.getEstanco().getEstCod());
    if (!estancoOpt.isPresent()) {
        throw new IllegalArgumentException("Estanco no encontrada");
    }
    
 
    // Establecer las relaciones
    almacenExistente.setEstanco(estancoOpt.get());
  
  

            return almacenRepository.save(almacenExistente);
        }
     return null;
    }

    @Override
    public void eliminarAlmacen( int id){
        almacenRepository.deleteById(id);
    }


}
