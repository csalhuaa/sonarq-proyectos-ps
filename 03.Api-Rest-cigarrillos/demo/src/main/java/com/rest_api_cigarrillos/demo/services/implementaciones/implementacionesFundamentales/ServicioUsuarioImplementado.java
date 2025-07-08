package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Usuario;
import com.rest_api_cigarrillos.demo.entities.referenciales.Rol;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.UsuarioRepository;
import com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales.RolRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuarioImplementado implements ServicioUsuario {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        Optional<Rol> rolOptional = rolRepository.findById(usuario.getRol().getRolCod());
        if (!rolOptional.isPresent()) {
            throw new IllegalArgumentException("Rol no encontrado");
        }

        usuario.setRol(rolOptional.get());
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setUsuNom(usuario.getUsuNom());
            usuarioExistente.setUsuPas(usuario.getUsuPas());
            usuarioExistente.setUsuEstReg(usuario.getUsuEstReg());

            Optional<Rol> rolOptional = rolRepository.findById(usuario.getRol().getRolCod());
            if (!rolOptional.isPresent()) {
                throw new IllegalArgumentException("Rol no encontrado");
            }
            usuarioExistente.setRol(rolOptional.get());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }
}
