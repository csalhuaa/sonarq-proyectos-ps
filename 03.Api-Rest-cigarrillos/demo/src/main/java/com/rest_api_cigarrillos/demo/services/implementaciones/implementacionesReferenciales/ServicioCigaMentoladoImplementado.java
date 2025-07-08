package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesReferenciales;
import java.util.List;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaMentolado;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.CigaMentoladoRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioCigaMentolado;

@Service
public class ServicioCigaMentoladoImplementado implements ServicioCigaMentolado {
    @Autowired
    private CigaMentoladoRepository cigaMentoladoRepository;

    @Override
    public List<CigaMentolado> getAllCigaMentolado() {
        return cigaMentoladoRepository.findAll();
    }

    @Override
    public CigaMentolado getCigaMentoladoById(int id) {
        return cigaMentoladoRepository.findById(id).orElse(null);
    }

    @Override
    public CigaMentolado crearCigaMentolado(CigaMentolado cigaMentolado) {
        if (cigaMentolado.getCigMenCod() != null && cigaMentoladoRepository.existsById(cigaMentolado.getCigMenCod())) {
            throw new EntityExistsException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return cigaMentoladoRepository.save(cigaMentolado);
    }

    @Override
    public CigaMentolado actualizarCigaMentolado(int id, CigaMentolado cigaMentolado) {
        CigaMentolado cm = cigaMentoladoRepository.findById(id).orElse(null);
        if (cm != null) {
            cm.setCigMenNom(cigaMentolado.getCigMenNom());
            cm.setCigMenEstReg(cigaMentolado.getCigMenEstReg());
            return cigaMentoladoRepository.save(cm);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarCigaMentolado(int id) {
        cigaMentoladoRepository.deleteById(id);
    }
}
