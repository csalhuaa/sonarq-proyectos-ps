package com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Compras;

@Repository
public interface ComprasRepository extends JpaRepository<Compras,Integer> {

}
