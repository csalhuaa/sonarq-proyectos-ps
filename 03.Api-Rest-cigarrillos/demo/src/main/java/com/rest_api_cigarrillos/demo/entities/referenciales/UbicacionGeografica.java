package com.rest_api_cigarrillos.demo.entities.referenciales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Estanco;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "GZZ_UBICACION_GEOGRAFICA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UbicacionGeografica {
    @Id
    private Integer UbiGeoCod;
    private String UbiGeoDepNom;
    private String UbiGeoProNom;
    private String UbiGeoDisNom;
    private String UbiGeoEstReg;

    @OneToMany(mappedBy = "ubicacionGeografica",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Estanco> estancos;
}
