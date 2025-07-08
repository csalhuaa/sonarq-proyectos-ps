package com.rest_api_cigarrillos.demo.entities.fundamentales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest_api_cigarrillos.demo.entities.referenciales.CigaFiltro;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "GZM_CIGA_TIPO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CigaTipo {
    @Id
    private int CigTipCod;
    private String CigTipNom;
    private String CigTipEstReg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CigTipFilCod")
    private CigaFiltro cigaFiltro;

    @OneToMany(mappedBy = "cigaTipo",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cigarrillos> cigarrillos;
}
