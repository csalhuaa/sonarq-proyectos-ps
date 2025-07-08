package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Compras;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.ComprasRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioComprasImplementado implements ServicioCompras {
    @Autowired
    private ComprasRepository comprasRepository;

    @Override
    public List<Compras> getAllCompras() {
        return comprasRepository.findAll();
    }

    @Override
    public Compras getCompraById(int id) {
        return comprasRepository.findById(id).orElse(null);
    }

    @Override
    public Compras crearCompras(Compras compras) {
        if (compras.getComCigCod() != null && comprasRepository.existsById(compras.getComCigCod())) {
            throw new IllegalArgumentException("El ID ya existe. Use el método de actualización para actualizar.");
        }
        return comprasRepository.save(compras);
    }

    @Override
    public Compras actualizarCompras(int id, Compras compras) {
        Compras comprasExistente = comprasRepository.findById(id).orElse(null);
        if (comprasExistente != null) {
            comprasExistente.setComCigCan(compras.getComCigCan());
            comprasExistente.setComCigEstReg(compras.getComCigEstReg());

            return comprasRepository.save(comprasExistente);
        } else {
            return null;
        }
    }
}
