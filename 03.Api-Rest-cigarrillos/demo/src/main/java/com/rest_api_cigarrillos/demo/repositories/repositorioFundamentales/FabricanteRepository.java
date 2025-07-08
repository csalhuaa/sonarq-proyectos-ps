package com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
}
