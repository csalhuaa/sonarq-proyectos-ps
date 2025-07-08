package com.rest_api_cigarrillos.demo.repositories.vistas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest_api_cigarrillos.demo.entities.EntidadVistas.VistaVentas;

@Repository
public interface VistaVentaRepository extends JpaRepository<VistaVentas,Integer> {

}
