package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.Paises;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.PaisesRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioPaises;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPaisesImplementado implements ServicioPaises {
    @Autowired
    private PaisesRepository paisesRepository;

    @Override
    public List<Paises> getAllPaises() {
        return paisesRepository.findAll();
    }

    @Override
    public Paises getPaisById(int id) {
        return paisesRepository.findById(id).orElse(null);
    }

    @Override
    public Paises crearPais(Paises pais) {
        if (pais.getPaiCod() != null && paisesRepository.existsById(pais.getPaiCod())) {
            throw new EntityExistsException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return paisesRepository.save(pais);
    }

    @Override
    public Paises actualizarPais(int id, Paises pais) {
        Paises p = paisesRepository.findById(id).orElse(null);
        if (p != null) {
            p.setPaiNom(pais.getPaiNom());
            p.setPaiEstReg(pais.getPaiEstReg());
            return paisesRepository.save(p);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarPais(int id) {
        paisesRepository.deleteById(id);
    }
}
