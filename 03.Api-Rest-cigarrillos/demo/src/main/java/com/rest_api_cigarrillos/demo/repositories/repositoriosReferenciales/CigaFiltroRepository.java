package com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaFiltro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CigaFiltroRepository extends JpaRepository<CigaFiltro, Integer> {
}
