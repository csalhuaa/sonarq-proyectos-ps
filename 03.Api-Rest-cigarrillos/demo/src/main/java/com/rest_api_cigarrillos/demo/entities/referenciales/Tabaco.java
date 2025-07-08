package com.rest_api_cigarrillos.demo.entities.referenciales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "GZZ_TABACO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tabaco {
    @Id
    private Integer TabCod;
    private String TabColHoj;
    private String TabEstReg;

    @OneToMany(mappedBy = "tabaco",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cigarrillos> cigarrillos;
}   