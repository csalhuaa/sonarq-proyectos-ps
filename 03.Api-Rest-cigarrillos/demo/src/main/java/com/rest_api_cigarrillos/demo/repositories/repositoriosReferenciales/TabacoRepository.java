package com.rest_api_cigarrillos.demo.repositories.repositoriosReferenciales;

import com.rest_api_cigarrillos.demo.entities.referenciales.Tabaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabacoRepository extends JpaRepository<Tabaco, Integer> {
}
