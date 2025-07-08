package com.rest_api_cigarrillos.demo.entities.fundamentales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "L1M_FABRICANTE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fabricante {
    @Id
    private Integer FabCod;
    private String FabNom;
    private String FabDir;
    private String FabEstReg;

    @OneToMany(mappedBy = "fabricante",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CigaMarca> cigaMarcas;

    @OneToMany(mappedBy = "fabricante",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Sede> sedes;

    @OneToMany(mappedBy = "fabricante",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Estanco> estancos;

    @OneToMany(mappedBy = "fabricante",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Usuario> usuarios;
}
