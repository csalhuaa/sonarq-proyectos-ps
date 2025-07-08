package com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CigarrillosRepository extends JpaRepository<Cigarrillos, Integer> {
}
