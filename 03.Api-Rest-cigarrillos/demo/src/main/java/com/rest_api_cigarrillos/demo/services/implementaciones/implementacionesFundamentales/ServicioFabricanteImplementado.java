package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Fabricante;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.FabricanteRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioFabricante;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioFabricanteImplementado implements ServicioFabricante {
    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public List<Fabricante> getAllFabricantes() {
        return fabricanteRepository.findAll();
    }

    @Override
    public Fabricante getFabricanteById(int id) {
        return fabricanteRepository.findById(id).orElse(null);
    }

    @Override
    public Fabricante crearFabricante(Fabricante fabricante) {
        if (fabricante.getFabCod() != null && fabricanteRepository.existsById(fabricante.getFabCod())) {
            throw new EntityExistsException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return fabricanteRepository.save(fabricante);
    }

    @Override
    public Fabricante actualizarFabricante(int id, Fabricante fabricante) {
        Fabricante fabricanteExistente = fabricanteRepository.findById(id).orElse(null);
        if (fabricanteExistente != null) {
            fabricanteExistente.setFabNom(fabricante.getFabNom());
            fabricanteExistente.setFabDir(fabricante.getFabDir());
            fabricanteExistente.setFabEstReg(fabricante.getFabEstReg());

            return fabricanteRepository.save(fabricanteExistente);
        } else {
            return null;
        }
    }
}
