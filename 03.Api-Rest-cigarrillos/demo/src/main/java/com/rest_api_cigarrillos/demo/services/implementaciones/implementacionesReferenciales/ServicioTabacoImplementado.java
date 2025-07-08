package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.Tabaco;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.TabacoRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales.ServicioTabaco;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTabacoImplementado implements ServicioTabaco {
    @Autowired
    private TabacoRepository tabacoRepository;

    @Override
    public List<Tabaco> getAllTabaco() {
        return tabacoRepository.findAll();
    }

    @Override
    public Tabaco getTabacoById(int id) {
        return tabacoRepository.findById(id).orElse(null);
    }

    @Override
    public Tabaco crearTabaco(Tabaco tabaco) {
        if (tabaco.getTabCod() != null && tabacoRepository.existsById(tabaco.getTabCod())) {
            throw new EntityExistsException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return tabacoRepository.save(tabaco);
    }

    @Override
    public Tabaco actualizarTabaco(int id, Tabaco tabaco) {
        Tabaco t = tabacoRepository.findById(id).orElse(null);
        if (t != null) {
            t.setTabColHoj(tabaco.getTabColHoj());
            t.setTabEstReg(tabaco.getTabEstReg());
            return tabacoRepository.save(t);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarTabaco(int id) {
        tabacoRepository.deleteById(id);
    }
}
