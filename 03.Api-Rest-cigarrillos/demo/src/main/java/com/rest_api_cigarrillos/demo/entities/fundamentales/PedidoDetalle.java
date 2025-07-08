package com.rest_api_cigarrillos.demo.entities.fundamentales;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "L1T_PEDIDO_DETALLE")
@Data
public class PedidoDetalle {
    @Id
    private int PedDetCod;
    private int PedDetCigCan;
    private String PedDetEstReg;
    private int PedDetPedCabEstCod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PedDetPedCabCod")
    private PedidoCabecera pedidoCabecera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PedDetCigCod")
    private Cigarrillos cigarrillos;
}
