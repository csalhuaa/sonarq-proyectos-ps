package com.rest_api_cigarrillos.demo.entities.fundamentales;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "V2T_REGISTRO_VENTAS")
@Data
public class RegistroVentas {
    @Id
    private int RegVenCod;
    private int RegVenCigCan;
    private int RegVenFecAni;
    private int RegVenFecMes;
    private int RegVenFecDia;
    private String RegVenEstReg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RegVenEstCod")
    private Estanco estanco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RegVenVenCigCod")
    private Ventas ventas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RegVenCigCod")
    private Cigarrillos cigarrillos;
}
