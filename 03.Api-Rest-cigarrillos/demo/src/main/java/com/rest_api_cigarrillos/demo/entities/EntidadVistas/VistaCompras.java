package com.rest_api_cigarrillos.demo.entities.EntidadVistas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "vistacompraspordia")
public class VistaCompras {
    @Id
    private Long id;

    private Integer CodigoCompra;
    private String NombreEstanco;
    private Integer CodigoCigarrillo;
    private BigDecimal CantidadCigarrillosComprados;
    private Integer Anio;
    private Integer Mes;
    private Integer Dia;
}
