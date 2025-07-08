package com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest_api_cigarrillos.demo.entities.referenciales.Region;

@Repository
public interface RegionRepository  extends JpaRepository<Region,Integer>{

}
