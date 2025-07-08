package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import java.util.List;
import java.util.Optional;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Fabricante;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Usuario;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.FabricanteRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Estanco;
import com.rest_api_cigarrillos.demo.entities.referenciales.Region;
import com.rest_api_cigarrillos.demo.entities.referenciales.UbicacionGeografica;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.EstancoRepository;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.RegionRepository;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.UbicacionGeograficaRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioEstanco;

@Service
public class ServicioEstancoImplementado implements ServicioEstanco {

    @Autowired
    private UbicacionGeograficaRepository ubicacionGeograficaRepository;

    @Autowired
    private EstancoRepository estancoRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Estanco> getAllEstanco() {
        return estancoRepository.findAll();
    }

    @Override
    public Estanco getEstancoById(int id) {
        return estancoRepository.findById(id).orElse(null);
    }

    @Override
    public Estanco crearEstanco(Estanco estanco) {
        // Verificar UbicacionGeografica
        Optional<UbicacionGeografica> ubicacionGeograficaOpt = ubicacionGeograficaRepository
                .findById(estanco.getUbicacionGeografica().getUbiGeoCod());
        if (!ubicacionGeograficaOpt.isPresent()) {
            throw new IllegalArgumentException("Ubicación Geográfica no encontrada");
        }

        // Verificar Region
        Optional<Region> regionOpt = regionRepository.findById(estanco.getRegion().getRegCod());
        if (!regionOpt.isPresent()) {
            throw new IllegalArgumentException("Región no encontrada");
        }
        // Verifica Fabrica
        Optional<Fabricante> fabricanteOpt = fabricanteRepository.findById(estanco.getFabricante().getFabCod());

        if (!fabricanteOpt.isPresent()) {
            throw new IllegalArgumentException("Fabricante no encontrada");
        }

        // Establecer las relaciones
        estanco.setUbicacionGeografica(ubicacionGeograficaOpt.get());
        estanco.setRegion(regionOpt.get());
        estanco.setFabricante(fabricanteOpt.get());

        return estancoRepository.save(estanco);
    }  

    @Override
    public Estanco actualizarEstanco(int id, Estanco estanco) {
        Estanco estancoExistente = estancoRepository.findById(id).orElse(null);
        if (estancoExistente != null) {
            estancoExistente.setEstNom(estanco.getEstNom());
            estancoExistente.setEstNumExp(estanco.getEstNumExp());
            estancoExistente.setEstNumIdeFis(estanco.getEstNumIdeFis());
            estancoExistente.setEstEstReg(estanco.getEstEstReg());

            // Verificar UbicacionGeografica
            Optional<UbicacionGeografica> ubicacionGeograficaOpt = ubicacionGeograficaRepository
                    .findById(estanco.getUbicacionGeografica().getUbiGeoCod());
            if (!ubicacionGeograficaOpt.isPresent()) {
                throw new IllegalArgumentException("Ubicación Geográfica no encontrada");
            }

            // Verificar Region
            Optional<Region> regionOpt =
                    regionRepository.findById(estanco.getRegion().getRegCod());
            if (!regionOpt.isPresent()) {
                throw new IllegalArgumentException("Región no encontrada");
            }

            // verificar fabricante
            Optional<Fabricante> fabricanteOpt = fabricanteRepository.findById(estanco.getFabricante().getFabCod());
            if (!fabricanteOpt.isPresent()) {
                throw new IllegalArgumentException("Fabricante no encontrado");
            }

            //verificar usuario
            Optional<Usuario> usuarioOpt = usuarioRepository.findById(estanco.getUsuario().getUsuCod());
            if (!usuarioOpt.isPresent()) {
                throw new IllegalArgumentException("Usuario no encontrado");
            }
          
            // Establecer las relaciones
            estancoExistente.setUbicacionGeografica(ubicacionGeograficaOpt.get());
            estancoExistente.setRegion(regionOpt.get());
            estancoExistente.setFabricante(fabricanteOpt.get());
            estancoExistente.setUsuario(usuarioOpt.get());

            return estancoRepository.save(estancoExistente);
        }
        return null;
    }

    @Override
    public void eliminarEstanco(int id) {
        estancoRepository.deleteById(id);
    }

}
