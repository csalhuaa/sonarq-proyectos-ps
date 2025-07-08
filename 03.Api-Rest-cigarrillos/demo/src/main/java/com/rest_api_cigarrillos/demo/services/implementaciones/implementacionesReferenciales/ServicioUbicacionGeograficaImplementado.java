package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesReferenciales;

import java.util.List;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.referenciales.UbicacionGeografica;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.UbicacionGeograficaRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioUbicacionGeografica;

@Service
public class ServicioUbicacionGeograficaImplementado  implements ServicioUbicacionGeografica {
   
    @Autowired
    private UbicacionGeograficaRepository ubicacionGeograficaRepository;

    @Override
    public List<UbicacionGeografica> getAllUbicacionGeografica(){
        return ubicacionGeograficaRepository.findAll();
    }
    @Override
    public UbicacionGeografica getUbicacionGeograficaPorId(int id){
        return ubicacionGeograficaRepository.findById(id).orElse(null);
    }
    @Override
    public UbicacionGeografica crearUbicacionGeografica(UbicacionGeografica ubicacionGeografica){
        if (ubicacionGeografica.getUbiGeoCod() != null && ubicacionGeograficaRepository.existsById(ubicacionGeografica.getUbiGeoCod())) {
            throw new EntityExistsException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return ubicacionGeograficaRepository.save(ubicacionGeografica);
    }
    @Override
    public UbicacionGeografica actualizarUbicacionGeografica(int id ,UbicacionGeografica ubicacionGeografica){
        UbicacionGeografica ubi=ubicacionGeograficaRepository.findById(id).orElse(null);
        if(ubi!=null){
            ubi.setUbiGeoDepNom(ubicacionGeografica.getUbiGeoDepNom());
            ubi.setUbiGeoProNom(ubicacionGeografica.getUbiGeoProNom());
            ubi.setUbiGeoDisNom(ubicacionGeografica.getUbiGeoDisNom());
            ubi.setUbiGeoEstReg(ubicacionGeografica.getUbiGeoEstReg());
            return ubicacionGeograficaRepository.save(ubi);
        
        
        }else{
            return null;
        }
    }
    
    @Override
    public void borrarUbicacionGeografica(int id){
        ubicacionGeograficaRepository.deleteById(id);
    }
    
}
