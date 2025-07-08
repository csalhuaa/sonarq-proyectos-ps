package com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales;



import java.util.List;

import com.rest_api_cigarrillos.demo.entities.referenciales.Rol;

public interface ServicioRol {
    
    Rol getRolById(int id);
    List<Rol> getAllRol();
    Rol crearRol(Rol r);
    Rol actualizarRol(int id,Rol r);
    void borrarRol(int id);

}
