package com.rest_api_cigarrillos.demo.entities.referenciales;

import com.fasterxml.jackson.annotation.*;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Sede;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "GZZ_PAISES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paises {
    @Id
    private Integer PaiCod;
    private String PaiNom;
    private String PaiEstReg;

    @OneToMany(mappedBy = "pais",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Sede> sedes;
}