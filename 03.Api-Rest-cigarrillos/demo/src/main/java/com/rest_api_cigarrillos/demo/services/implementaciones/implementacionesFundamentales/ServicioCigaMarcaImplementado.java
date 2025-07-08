package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaMarca;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Fabricante;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigaMarcaRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.FabricanteRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioCigaMarca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCigaMarcaImplementado implements ServicioCigaMarca {
    @Autowired
    private CigaMarcaRepository cigaMarcaRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public List<CigaMarca> getAllCigaMarca() {
        return cigaMarcaRepository.findAll();
    }

    @Override
    public CigaMarca getCigaMarcaById(int id) {
        return cigaMarcaRepository.findById(id).orElse(null);
    }

    @Override
    public CigaMarca crearCigaMarca(CigaMarca cigaMarca) {
        Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(cigaMarca.getFabricante().getFabCod());
        if (!fabricanteOptional.isPresent()) {
            throw new IllegalArgumentException("Fabricante no encontrado");
        }

        cigaMarca.setFabricante(fabricanteOptional.get());
        return cigaMarcaRepository.save(cigaMarca);

    }

    @Override
    public  CigaMarca actualizarCigaMarca(int id, CigaMarca cigaMarca) {
        CigaMarca cigaMarcaExistente = cigaMarcaRepository.findById(id).orElse(null);
        if (cigaMarcaExistente != null) {
            cigaMarcaExistente.setMarCigNom(cigaMarca.getMarCigNom());
            cigaMarcaExistente.setMarCigEstReg(cigaMarca.getMarCigEstReg());

            Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(cigaMarca.getFabricante().getFabCod());
            if (!fabricanteOptional.isPresent()) {
                throw new IllegalArgumentException("Fabricante no encontrado");
            }
            cigaMarcaExistente.setFabricante(fabricanteOptional.get());
            return cigaMarcaRepository.save(cigaMarcaExistente);
        }
        return null;
    }
}
