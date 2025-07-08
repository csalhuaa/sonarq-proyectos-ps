package com.rest_api_cigarrillos.demo.entities.fundamentales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "L3T_ALMACEN")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Almacen {
  @Id
  private int AlmCod;

  private int AlmCanCig;
  private int AlmCanMinCig;
  private int AlmCanMaxCig;
  private int AlmCanSegCig;
  private String AlmEstReg;

  @ManyToOne(fetch =FetchType.LAZY)
  @JoinColumn(name = "AlmEstCod")
  private Estanco estanco;

  @OneToMany(mappedBy = "almacen",cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Stock> stocks;
}
