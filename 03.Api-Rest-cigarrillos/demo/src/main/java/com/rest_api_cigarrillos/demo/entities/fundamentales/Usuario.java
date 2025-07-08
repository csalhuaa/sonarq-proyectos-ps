package com.rest_api_cigarrillos.demo.entities.fundamentales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.referenciales.Rol;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "GZM_USUARIO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {
    @Id
    private int UsuCod;
    private String UsuNom;
    private String UsuEstReg;
    private String UsuPas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UsuRolCod")
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UsuFabCod")
    private Fabricante fabricante;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Estanco> estancos;
}