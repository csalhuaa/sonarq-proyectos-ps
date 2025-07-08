package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaClase;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.CigaClaseRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioCigaClase;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCigaClaseImplementado implements ServicioCigaClase {
    @Autowired
    private CigaClaseRepository cigaClaseRepository;

    @Override
    public List<CigaClase> getAllCigaClase() {
        return cigaClaseRepository.findAll();
    }

    @Override
    public CigaClase getCigaClaseById(int id) {
        return cigaClaseRepository.findById(id).orElse(null);
    }

    @Override
    public CigaClase crearCigaClase(CigaClase cigaClase) {
        if (cigaClase.getCigClaCod() != null && cigaClaseRepository.existsById(cigaClase.getCigClaCod())) {
            throw new EntityExistsException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return cigaClaseRepository.save(cigaClase);
    }

    @Override
    public CigaClase actualizarCigaClase(int id, CigaClase cigaClase) {
        CigaClase cc = cigaClaseRepository.findById(id).orElse(null);
        if (cc != null) {
            cc.setCigClaNom(cigaClase.getCigClaNom());
            cc.setCigClaEstReg(cigaClase.getCigClaEstReg());
            return cigaClaseRepository.save(cc);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarCigaClase(int id) {
        cigaClaseRepository.deleteById(id);
    }
}
