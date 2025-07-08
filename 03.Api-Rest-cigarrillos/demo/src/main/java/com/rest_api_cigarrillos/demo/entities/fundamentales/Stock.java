package com.rest_api_cigarrillos.demo.entities.fundamentales;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "L3T_STOCK")
@Data
public class Stock {
    @Id
    private int StoCod;

    private int StoCan;
    private int StoMinCan;
    private String StoEstReg;
    private int StoAlmEstCod;

    //Almacen
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StoAlmCod")
    private Almacen almacen;

    //Cigarrillos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StoCigCod")
    private Cigarrillos cigarrillos;
}
