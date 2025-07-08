package com.rest_api_cigarrillos.demo.entities.referenciales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.fundamentales.CigaTipo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "GZZ_CIGA_FILTRO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CigaFiltro {
    @Id
    private Integer CigFilCod;
    private String CigFilNom;
    private String CigFilEstReg;

    @OneToMany(mappedBy = "cigaFiltro",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CigaTipo> cigaTipos;
}
