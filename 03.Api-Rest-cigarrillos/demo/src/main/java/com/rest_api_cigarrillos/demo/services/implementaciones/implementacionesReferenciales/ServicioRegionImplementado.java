package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesReferenciales;

import java.util.List;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.referenciales.Region;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.RegionRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioRegion;

@Service
public class ServicioRegionImplementado  implements ServicioRegion{
    @Autowired
    private RegionRepository regionRepository;
 
    @Override
    public List<Region> getAllRegion(){
     return regionRepository.findAll();
    }

    @Override
    public Region getRegionById(int id){
        return regionRepository.findById(id).orElse(null);
    }
    @Override
    public  Region crearRegion(Region region){
        if (region.getRegCod() != null && regionRepository.existsById(region.getRegCod())) {
            throw new EntityExistsException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return regionRepository.save(region);
    }
    @Override
    public Region actualizarRegion(int id, Region region){
        Region r = regionRepository.findById(id).orElse(null);
        if(r!=null){
            r.setRegNom(region.getRegNom());
            r.setRegEstReg(region.getRegEstReg());
            return regionRepository.save(r);
        }else{
            return null;
        }
    }


    @Override
    public void borrarRegion(int id){
        regionRepository.deleteById(id);
    }
}
