package com.rest_api_cigarrillos.demo.entities.fundamentales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "GZM_CIGA_MARCA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CigaMarca {
    @Id
    private int MarCigCod;
    private String MarCigNom;
    private String MarCigEstReg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MarCigFabCod")
    private Fabricante fabricante;

    @OneToMany(mappedBy = "cigaMarca",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cigarrillos> cigarrillos;
}
