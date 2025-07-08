package com.rest_api_cigarrillos.demo.entities.referenciales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "GZZ_CIGA_MENTOLADO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CigaMentolado {
    @Id
    private Integer CigMenCod;
    private String CigMenNom;
    private String CigMenEstReg;

    @OneToMany(mappedBy = "mentolado",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cigarrillos> cigarrillos;
}
