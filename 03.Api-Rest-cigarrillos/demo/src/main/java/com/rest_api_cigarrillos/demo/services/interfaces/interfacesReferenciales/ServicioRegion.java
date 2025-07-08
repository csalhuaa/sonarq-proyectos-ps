package com.rest_api_cigarrillos.demo.services.interfaces.interfacesReferenciales;

import java.util.List;

import com.rest_api_cigarrillos.demo.entities.referenciales.Region;

public interface ServicioRegion {

  List<Region> getAllRegion();
  Region getRegionById(int id);
  Region crearRegion(Region region);
  Region actualizarRegion(int id, Region region);
  void  borrarRegion(int id);

}
