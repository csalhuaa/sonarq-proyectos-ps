package com.rest_api_cigarrillos.demo.entities.fundamentales;

import com.rest_api_cigarrillos.demo.entities.referenciales.Paises;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "L1M_SEDE")
public class Sede {
    @Id
    private int SedCod;
    private String SedLoc;
    private String SedEstReg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SedFabCod")
    private Fabricante fabricante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SedPaiCod")
    private Paises pais;
}