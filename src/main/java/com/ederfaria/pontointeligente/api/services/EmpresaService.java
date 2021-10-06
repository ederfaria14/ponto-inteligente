package com.ederfaria.pontointeligente.api.services;

import com.ederfaria.pontointeligente.api.entities.Empresa;

import java.util.List;

public interface EmpresaService {

    public Empresa findByCnpj(String cnpj);

    public List<Empresa> findAll();

    public void persistir(Empresa entity);

}
