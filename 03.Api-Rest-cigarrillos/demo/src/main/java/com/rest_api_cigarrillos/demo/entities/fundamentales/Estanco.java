package com.rest_api_cigarrillos.demo.entities.fundamentales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.referenciales.Region;
import com.rest_api_cigarrillos.demo.entities.referenciales.UbicacionGeografica;

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
@Table(name = "V2M_ESTANCOS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estanco {
    @Id
    private int EstCod;

    private String EstNom;
    private int EstNumExp;
    private int EstNumIdeFis;
    private String EstEstReg;
   
    //Ubicacion Geografica
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EstUbiGeoCod")
    private UbicacionGeografica ubicacionGeografica;

   //Region
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EstRegCod")
    private Region region;

   //Fabricante
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EstFabCod")
    private Fabricante fabricante;

   //Almacenes
    @OneToMany(mappedBy = "estanco",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Almacen> listaAlmacenes;

   //PedidoCabecera
    @OneToMany(mappedBy = "estanco",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PedidoCabecera> listaPedidoCabeceras;

    //Ventas
    @OneToMany(mappedBy = "estanco",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RegistroVentas> listaRegistroVentas;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "EstUsuCod")
    private Usuario usuario;

    @OneToMany(mappedBy = "estanco",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RegistroCompras> registroCompras;
}
