package com.rest_api_cigarrillos.demo.controllers.controllersFundamentales;


import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaMarca;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Usuario;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    @Autowired
    private ServicioUsuario servicioUsuario;

    @GetMapping
    @CrossOrigin
    public List<Usuario> obtenerTodosUsuarios() {
        return servicioUsuario.getAllUsuarios();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable int id) {
        Usuario usuario = servicioUsuario.getUsuarioById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = servicioUsuario.crearUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioActualizado = servicioUsuario.actualizarUsuario(id, usuario);
            if (usuarioActualizado != null) {
                return ResponseEntity.ok(usuarioActualizado);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
