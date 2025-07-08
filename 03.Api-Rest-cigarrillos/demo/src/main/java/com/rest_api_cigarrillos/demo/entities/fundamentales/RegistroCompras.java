package com.rest_api_cigarrillos.demo.entities.fundamentales;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "L1T_REGISTRO_COMPRAS")
@Data
public class RegistroCompras {
    @Id
    private Integer RegComCod;
    private int RegComCigCan;
    private int RegComCigFecAni;
    private int RegComCigFecMes;
    private int RegComCigFecDia;
    private String RegComCigEstReg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RegComEstCod")
    private Estanco estanco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RegComCigCod")
    private Cigarrillos cigarrillos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RegComComCigCod")
    private Compras compras;
}
