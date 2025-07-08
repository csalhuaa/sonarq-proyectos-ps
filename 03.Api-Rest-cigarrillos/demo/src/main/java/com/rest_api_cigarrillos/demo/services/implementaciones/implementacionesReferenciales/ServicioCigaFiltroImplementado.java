package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaFiltro;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.CigaFiltroRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioCigaFiltro;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCigaFiltroImplementado implements ServicioCigaFiltro {
    @Autowired
    private CigaFiltroRepository cigaFiltroRepository;

    @Override
    public List<CigaFiltro> getAllCigaFiltro() {
        return cigaFiltroRepository.findAll();
    }

    @Override
    public CigaFiltro getCigaFiltroById(int id) {
        return cigaFiltroRepository.findById(id).orElse(null);
    }

    @Override
    public CigaFiltro crearCigaFiltro(CigaFiltro cigaFiltro) {
        if (cigaFiltro.getCigFilCod() != null && cigaFiltroRepository.existsById(cigaFiltro.getCigFilCod())) {
            throw new EntityExistsException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return cigaFiltroRepository.save(cigaFiltro);
    }

    @Override
    public CigaFiltro actualizarCigaFiltro(int id, CigaFiltro cigaFiltro) {
        CigaFiltro cf = cigaFiltroRepository.findById(id).orElse(null);
        if (cf != null) {
            cf.setCigFilNom(cigaFiltro.getCigFilNom());
            cf.setCigFilEstReg(cigaFiltro.getCigFilEstReg());
            return cigaFiltroRepository.save(cf);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarCigaFiltro(int id) {
        cigaFiltroRepository.deleteById(id);
    }
}
