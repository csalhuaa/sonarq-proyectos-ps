package com.rest_api_cigarrillos.demo.services.implementaciones.implementacionesFundamentales;

import com.rest_api_cigarrillos.demo.entities.fundamentales.Cigarrillos;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Compras;
import com.rest_api_cigarrillos.demo.entities.fundamentales.Estanco;
import com.rest_api_cigarrillos.demo.entities.fundamentales.RegistroCompras;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.CigarrillosRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.ComprasRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.EstancoRepository;
import com.rest_api_cigarrillos.demo.repositories.repositorioFundamentales.RegistroComprasRepository;
import com.rest_api_cigarrillos.demo.services.interfaces.interfacesFundamentales.ServicioRegistroCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioRegistroComprasImplementado implements ServicioRegistroCompras {
    @Autowired
    private RegistroComprasRepository registroComprasRepository;

    @Autowired
    private CigarrillosRepository cigarrillosRepository;
    @Autowired
    private EstancoRepository estancoRepository;
    @Autowired
    private ComprasRepository comprasRepository;

    @Override
    public List<RegistroCompras> getAllRegistroCompras() {
        return registroComprasRepository.findAll();
    }

    @Override
    public RegistroCompras getRegistroComprasById(int id) {
        return registroComprasRepository.findById(id).orElse(null);
    }

    @Override
    public RegistroCompras crearRegistroCompras(RegistroCompras registroCompras) {
        Optional<Compras> compras = comprasRepository.findById(registroCompras.getCompras().getComCigCod());
        if (!compras.isPresent()) {
            throw new IllegalArgumentException("Compra no encontrada");
        }
        Optional<Estanco> estanco = estancoRepository.findById(registroCompras.getEstanco().getEstCod());
        if (!estanco.isPresent()) {
            throw new IllegalArgumentException("Estanco no encontrado");
        }
        Optional<Cigarrillos> cigarrillos = cigarrillosRepository.findById(registroCompras.getCigarrillos().getCigCod());
        if (!cigarrillos.isPresent()) {
            throw new IllegalArgumentException("Cigarrillo no encontrado");
        }

        registroCompras.setCompras(compras.get());
        registroCompras.setEstanco(estanco.get());
        registroCompras.setCigarrillos(cigarrillos.get());

        return registroComprasRepository.save(registroCompras);
    }

    @Override
    public RegistroCompras actualizarRegistroCompras(int id,RegistroCompras registroCompras) {
        RegistroCompras registroComprasExistente = registroComprasRepository.findById(id).orElse(null);
        if (registroComprasExistente != null) {
            registroComprasExistente.setRegComCigCan(registroCompras.getRegComCigCan());
            registroComprasExistente.setRegComCigFecAni(registroCompras.getRegComCigFecAni());
            registroComprasExistente.setRegComCigFecMes(registroCompras.getRegComCigFecMes());
            registroComprasExistente.setRegComCigFecDia(registroCompras.getRegComCigFecDia());
            registroComprasExistente.setRegComCigEstReg(registroCompras.getRegComCigEstReg());

            Optional<Compras> compras = comprasRepository.findById(registroCompras.getCompras().getComCigCod());
            if (!compras.isPresent()) {
                throw new IllegalArgumentException("Compra no encontrada");
            }
            Optional<Estanco> estanco = estancoRepository.findById(registroCompras.getEstanco().getEstCod());
            if (!estanco.isPresent()) {
                throw new IllegalArgumentException("Estanco no encontrado");
            }
            Optional<Cigarrillos> cigarrillos = cigarrillosRepository.findById(registroCompras.getCigarrillos().getCigCod());
            if (!cigarrillos.isPresent()) {
                throw new IllegalArgumentException("Cigarrillo no encontrado");
            }

            registroComprasExistente.setCompras(compras.get());
            registroComprasExistente.setEstanco(estanco.get());
            registroComprasExistente.setCigarrillos(cigarrillos.get());

            return registroComprasRepository.save(registroComprasExistente);
        }
        return null;
    }
}
