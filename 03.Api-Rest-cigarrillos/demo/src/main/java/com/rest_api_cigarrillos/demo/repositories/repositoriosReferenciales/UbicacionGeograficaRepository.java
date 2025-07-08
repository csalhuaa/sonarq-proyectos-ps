package com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest_api_cigarrillos.demo.entities.referenciales.UbicacionGeografica;

@Repository
public interface UbicacionGeograficaRepository  extends JpaRepository<UbicacionGeografica,Integer>{

}
