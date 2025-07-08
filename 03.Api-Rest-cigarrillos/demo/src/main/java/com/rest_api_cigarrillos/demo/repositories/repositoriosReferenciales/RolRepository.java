package com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest_api_cigarrillos.demo.entities.referenciales.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer>{

}