package com.ederfaria.pontointeligente.api.services.impl;

import com.ederfaria.pontointeligente.api.entities.Empresa;
import com.ederfaria.pontointeligente.api.repositories.EmpresaRepository;
import com.ederfaria.pontointeligente.api.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Override
    public Empresa findByCnpj(String cnpj) {
        return repository.findByCnpj(cnpj);
    }

    @Override
    public List<Empresa> findAll() {
        return repository.findAll();
    }

    @Override
    public void persistir(Empresa entity) {
        repository.save(entity);
    }
}
