package com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Usuario;

import java.util.List;

public interface ServicioUsuario {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(int id);
    Usuario crearUsuario(Usuario usuario);
    Usuario actualizarUsuario(int id, Usuario usuario);
}
