package com.rest_api_cigarrillos.demo.entities.EntidadVistas;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vistaventaspordia")
@Data
public class VistaVentas {
    @Id
    private Long id;

    private Integer CodigoVenta;
    private Integer CodigoCigarrillo;
    private String NombreEstanco;
    private BigDecimal CantidadCigarrillosVendidos;
    private String MarcaCigarrillo;
    private Integer Anio;
    private Integer Mes;
    private Integer Dia;

}
