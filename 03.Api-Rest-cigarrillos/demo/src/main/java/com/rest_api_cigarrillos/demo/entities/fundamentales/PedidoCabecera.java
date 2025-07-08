package com.rest_api_cigarrillos.demo.entities.fundamentales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "L1T_PEDIDO_CABECERA")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PedidoCabecera {
    @Id
    private int PedCabCod;
    private int PedCabFecAni;
    private int PedCabFecMes;
    private int PedCabFecDia;
    private String PedCabEstReg;

    //Estanco
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PedCabEstCod")
    private Estanco estanco;

    //pedido detalle
    @OneToMany(mappedBy = "pedidoCabecera",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PedidoDetalle> pedidoDetalles;
}
