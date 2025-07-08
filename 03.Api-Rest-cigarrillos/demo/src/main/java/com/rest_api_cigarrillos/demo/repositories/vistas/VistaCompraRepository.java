package com.rest_api_cigarrillos.demo.repositories.vistas;

import com.rest_api_cigarrillos.demo.entities.EntidadVistas.VistaCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VistaCompraRepository extends JpaRepository<VistaCompras, Integer> {
}
