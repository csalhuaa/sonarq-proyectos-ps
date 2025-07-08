package com.rest_api_cigarrillos.demo.entities.referenciales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "GZZ_CIGA_CLASE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CigaClase {
    @Id
    private Integer CigClaCod;
    private String CigClaNom;
    private String CigClaEstReg;

    @OneToMany(mappedBy = "cigaClase",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cigarrillos> cigarrillos;
}
