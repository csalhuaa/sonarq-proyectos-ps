package com.rest_api_cigarrillos.demo.entities.referenciales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "GZZ_ROL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rol {
    @Id
    private Integer RolCod;
    private String RolNom;
    private String RolEstReg;

    @OneToMany(mappedBy = "rol",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Usuario> usuarios;
}