package com.rest_api_cigarrillos.demo.entities.fundamentales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.referenciales.CigaClase;
import com.rest_api_cigarrillos.demo.entities.referenciales.CigaMentolado;
import com.rest_api_cigarrillos.demo.entities.referenciales.Tabaco;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "L3M_CIGARRILLOS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cigarrillos {
    @Id
    private int CigCod;

    private double CigNicCan;
    private double CigAlqCan;
    private int CigCanEmb;
    private int CigCanCar;
    private String CigEstReg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CigMenCod")
    private CigaMentolado mentolado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CigTabCod")
    private Tabaco tabaco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CigCigClaCod")
    private CigaClase cigaClase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CigMarCigCod")
    private CigaMarca cigaMarca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CigTipCod")
    private CigaTipo cigaTipo;

    //Registro Ventas
    @OneToMany(mappedBy = "cigarrillos", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RegistroVentas> listaRegistroVentas;

    //pedido Detalle
    @OneToMany(mappedBy = "cigarrillos",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PedidoDetalle> listaPedidoDetalles;

    @OneToMany(mappedBy = "cigarrillos",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RegistroCompras> registroCompras;
}
