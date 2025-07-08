package com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest_api_cigarrillos.demo.entities.fundamentales.RegistroCompras;

@Repository
public interface RegistroComprasRepository extends JpaRepository<RegistroCompras,Integer>{

}
