package com.rest_api_cigarrillos.demo.entities.fundamentales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "L1T_COMPRAS_CIGARRILLOS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Compras {
    @Id
    private Integer ComCigCod;
    private int ComCigCan;
    private String ComCigEstReg;

    @OneToMany(mappedBy = "compras",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RegistroCompras> registroCompras;
}
