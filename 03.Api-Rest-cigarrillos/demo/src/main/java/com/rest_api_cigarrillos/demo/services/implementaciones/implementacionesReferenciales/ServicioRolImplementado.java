package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesReferenciales;

import java.util.List;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.referenciales.Rol;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.RolRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioRol;

@Service 
public class ServicioRolImplementado implements ServicioRol{

    @Autowired
    private RolRepository rolRepository;
    
    @Override
    public List<Rol> getAllRol(){
        return  rolRepository.findAll();
    }
    @Override
    public Rol getRolById(int id){
        return rolRepository.findById(id).orElse(null);
    }
    @Override
    public Rol crearRol(Rol rol){
        if (rol.getRolCod() != null && rolRepository.existsById(rol.getRolCod())) {
            throw new EntityExistsException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return rolRepository.save(rol);
    }
    @Override
    public Rol actualizarRol(int id, Rol rol){
        Rol r=rolRepository.findById(id).orElse(null);
        if(r != null){
            r.setRolNom(rol.getRolNom());
            r.setRolEstReg(rol.getRolEstReg());
            return rolRepository.save(r);
        }
        return null;
    }
    @Override
    public void borrarRol(int id){
        rolRepository.deleteById(id);
    }
    
}
