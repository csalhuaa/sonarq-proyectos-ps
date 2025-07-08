package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Fabricante;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Sede;
import com.rest_api_cigarrillos.demo.entities.referenciales.Paises;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.FabricanteRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.SedeRepository;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.PaisesRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioSede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioSedeImplementado implements ServicioSede {
    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private PaisesRepository paisesRepository;

    @Override
    public List<Sede> getAllSedes() {
        return sedeRepository.findAll();
    }

    @Override
    public Sede getSedeById(int id) {
        return sedeRepository.findById(id).orElse(null);
    }

    @Override
    public Sede crearSede(Sede sede) {
        Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(sede.getFabricante().getFabCod());
        if (!fabricanteOptional.isPresent()) {
            throw new IllegalArgumentException("Fabricante no encontrado");
        }

        Optional<Paises> paisesOptional = paisesRepository.findById(sede.getPais().getPaiCod());
        if (!paisesOptional.isPresent()) {
            throw new IllegalArgumentException("Pais no encontrado");
        }

        sede.setFabricante(fabricanteOptional.get());
        sede.setPais(paisesOptional.get());
        return sedeRepository.save(sede);
    }

    @Override
    public Sede actualizarSede(int id, Sede sede) {
        Sede sedeExistente = sedeRepository.findById(id).orElse(null);
        if (sedeExistente != null) {
            sedeExistente.setSedLoc(sede.getSedLoc());
            sedeExistente.setSedEstReg(sede.getSedEstReg());

            Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(sede.getFabricante().getFabCod());
            if (!fabricanteOptional.isPresent()) {
                throw new IllegalArgumentException("Fabricante no encontrado");
            }

            Optional<Paises> paisesOptional = paisesRepository.findById(sede.getPais().getPaiCod());
            if (!paisesOptional.isPresent()) {
                throw new IllegalArgumentException("Pais no encontrado");
            }

            sedeExistente.setFabricante(fabricanteOptional.get());
            sedeExistente.setPais(paisesOptional.get());
            return sedeRepository.save(sedeExistente);
        }
        return null;
    }
}