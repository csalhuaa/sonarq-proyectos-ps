package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaTipo;
import com.rest_api_cigarrillos.demo.entities.referenciales.CigaFiltro;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigaTipoRepository;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.CigaFiltroRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioCigaTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCigaTipoImplementado implements ServicioCigaTipo {
    @Autowired
    private CigaTipoRepository cigaTipoRepository;

    @Autowired
    private CigaFiltroRepository cigaFiltroRepository;

    @Override
    public List<CigaTipo> getAllCigaTipo() {
        return cigaTipoRepository.findAll();
    }

    @Override
    public CigaTipo getCigaTipoById(int id) {
        return cigaTipoRepository.findById(id).orElse(null);
    }

    @Override
    public CigaTipo crearCigaTipo(CigaTipo cigaTipo) {
        Optional<CigaFiltro> cigaFiltroOptional = cigaFiltroRepository.findById(cigaTipo.getCigaFiltro().getCigFilCod());
        if (!cigaFiltroOptional.isPresent()) {
            throw new IllegalArgumentException("Filtro no encontrado");
        }

        cigaTipo.setCigaFiltro(cigaFiltroOptional.get());
        return cigaTipoRepository.save(cigaTipo);
    }

    @Override
    public CigaTipo actualizarCigaTipo(int id, CigaTipo cigaTipo) {
        CigaTipo cigaTipoExistente = cigaTipoRepository.findById(id).orElse(null);
        if (cigaTipoExistente != null) {
            cigaTipoExistente.setCigTipNom(cigaTipo.getCigTipNom());
            cigaTipoExistente.setCigTipEstReg(cigaTipo.getCigTipEstReg());

            Optional<CigaFiltro> cigaFiltroOptional = cigaFiltroRepository.findById(cigaTipo.getCigaFiltro().getCigFilCod());
            if (!cigaFiltroOptional.isPresent()) {
                throw new IllegalArgumentException("Filtro no encontrado");
            }

            cigaTipoExistente.setCigaFiltro(cigaFiltroOptional.get());
            return cigaTipoRepository.save(cigaTipoExistente);
        }
        return null;
    }
}
