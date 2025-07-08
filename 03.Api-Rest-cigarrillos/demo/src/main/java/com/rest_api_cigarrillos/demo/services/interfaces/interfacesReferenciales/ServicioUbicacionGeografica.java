package com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales;
import java.util.List;

import com.rest_api_cigarrillos.demo.entities.referenciales.UbicacionGeografica;
public interface ServicioUbicacionGeografica {

    List<UbicacionGeografica> getAllUbicacionGeografica();
    UbicacionGeografica getUbicacionGeograficaPorId(int id);
    UbicacionGeografica crearUbicacionGeografica(UbicacionGeografica ubicacionGeografica);
    UbicacionGeografica actualizarUbicacionGeografica(int id,UbicacionGeografica ubicacionGeografica);
    void  borrarUbicacionGeografica(int id);

}
