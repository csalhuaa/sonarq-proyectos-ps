package com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.CigaClase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CigaClaseRepository extends JpaRepository<CigaClase, Integer> {
}
