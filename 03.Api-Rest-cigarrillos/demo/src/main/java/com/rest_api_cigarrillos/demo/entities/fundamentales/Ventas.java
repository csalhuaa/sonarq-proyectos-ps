package com.rest_api_cigarrillos.demo.entities.fundamentales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "V2T_VENTAS_CIGARRILLOS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ventas {
    @Id
    private int VenCigCod;
    private int VenCigCan;
    private String VenCigEstReg;
    
    @OneToMany(mappedBy = "ventas",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RegistroVentas> registroVentas;

}
