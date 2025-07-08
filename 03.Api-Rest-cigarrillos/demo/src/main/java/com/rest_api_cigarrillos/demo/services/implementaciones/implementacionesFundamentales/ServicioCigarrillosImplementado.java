package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaMarca;
import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaTipo;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import com.rest_api_cigarrillos.demo.entities.referenciales.CigaClase;
import com.rest_api_cigarrillos.demo.entities.referenciales.CigaMentolado;
import com.rest_api_cigarrillos.demo.entities.referenciales.Tabaco;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigaMarcaRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigaTipoRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigarrillosRepository;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.CigaClaseRepository;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.CigaMentoladoRepository;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.TabacoRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioCigarrillos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCigarrillosImplementado implements ServicioCigarrillos {
    @Autowired
    private CigarrillosRepository cigarrillosRepository;

    @Autowired
    private CigaMentoladoRepository cigaMentoladoRepository;
    @Autowired
    private TabacoRepository tabacoRepository;
    @Autowired
    private CigaClaseRepository cigaClaseRepository;
    @Autowired
    private CigaMarcaRepository cigaMarcaRepository;
    @Autowired
    private CigaTipoRepository cigaTipoRepository;

    @Override
    public List<Cigarrillos> getAllCigarrillos() {
        return cigarrillosRepository.findAll();
    }

    @Override
    public Cigarrillos getCigarrillosById(int id) {
        return cigarrillosRepository.findById(id).orElse(null);
    }

    @Override
    public Cigarrillos crearCigarrillos(Cigarrillos cigarrillos) {
        Optional<CigaMentolado> cigaMentolado = cigaMentoladoRepository.findById(cigarrillos.getMentolado().getCigMenCod());
        if (!cigaMentolado.isPresent()) {
            throw new IllegalArgumentException("Mentolado no encontrado");
        }
        Optional<Tabaco> tabaco = tabacoRepository.findById(cigarrillos.getTabaco().getTabCod());
        if (!tabaco.isPresent()) {
            throw new IllegalArgumentException("Tabaco no encontrado");
        }
        Optional<CigaClase> cigaClase = cigaClaseRepository.findById(cigarrillos.getCigaClase().getCigClaCod());
        if (!cigaClase.isPresent()) {
            throw new IllegalArgumentException("Clase de cigarrillo no encontrado");
        }
        Optional<CigaMarca> cigaMarca = cigaMarcaRepository.findById(cigarrillos.getCigaMarca().getMarCigCod());
        if (!cigaMarca.isPresent()) {
            throw new IllegalArgumentException("Marca de cigarrillo no encontrado");
        }
        Optional<CigaTipo> cigaTipo = cigaTipoRepository.findById(cigarrillos.getCigaTipo().getCigTipCod());
        if (!cigaTipo.isPresent()) {
            throw new IllegalArgumentException("Tipo de cigarrillo no encontrado");
        }

        cigarrillos.setMentolado(cigaMentolado.get());
        cigarrillos.setTabaco(tabaco.get());
        cigarrillos.setCigaClase(cigaClase.get());
        cigarrillos.setCigaMarca(cigaMarca.get());
        cigarrillos.setCigaTipo(cigaTipo.get());

        return cigarrillosRepository.save(cigarrillos);

    }

    @Override
    public Cigarrillos actualizarCigarrillos(int id, Cigarrillos cigarrillos) {
        Cigarrillos cigarrillosExistente = cigarrillosRepository.findById(id).orElse(null);
        if (cigarrillosExistente != null) {
            cigarrillosExistente.setCigNicCan(cigarrillos.getCigNicCan());
            cigarrillosExistente.setCigAlqCan(cigarrillos.getCigAlqCan());
            cigarrillosExistente.setCigCanEmb(cigarrillos.getCigCanEmb());
            cigarrillosExistente.setCigCanCar(cigarrillos.getCigCanCar());
            cigarrillosExistente.setCigEstReg(cigarrillos.getCigEstReg());

            Optional<CigaMentolado> cigaMentolado = cigaMentoladoRepository.findById(cigarrillos.getMentolado().getCigMenCod());
            if (!cigaMentolado.isPresent()) {
                throw new IllegalArgumentException("Mentolado no encontrado");
            }
            Optional<Tabaco> tabaco = tabacoRepository.findById(cigarrillos.getTabaco().getTabCod());
            if (!tabaco.isPresent()) {
                throw new IllegalArgumentException("Tabaco no encontrado");
            }
            Optional<CigaClase> cigaClase = cigaClaseRepository.findById(cigarrillos.getCigaClase().getCigClaCod());
            if (!cigaClase.isPresent()) {
                throw new IllegalArgumentException("Clase de cigarrillo no encontrado");
            }
            Optional<CigaMarca> cigaMarca = cigaMarcaRepository.findById(cigarrillos.getCigaMarca().getMarCigCod());
            if (!cigaMarca.isPresent()) {
                throw new IllegalArgumentException("Marca de cigarrillo no encontrado");
            }
            Optional<CigaTipo> cigaTipo = cigaTipoRepository.findById(cigarrillos.getCigaTipo().getCigTipCod());
            if (!cigaTipo.isPresent()) {
                throw new IllegalArgumentException("Tipo de cigarrillo no encontrado");
            }

            cigarrillosExistente.setMentolado(cigaMentolado.get());
            cigarrillosExistente.setTabaco(tabaco.get());
            cigarrillosExistente.setCigaClase(cigaClase.get());
            cigarrillosExistente.setCigaMarca(cigaMarca.get());
            cigarrillosExistente.setCigaTipo(cigaTipo.get());

            return cigarrillosRepository.save(cigarrillosExistente);
        }
        return null;
    }
}
