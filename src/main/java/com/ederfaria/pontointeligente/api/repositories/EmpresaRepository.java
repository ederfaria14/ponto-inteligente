package com.ederfaria.pontointeligente.api.repositories;

import com.ederfaria.pontointeligente.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    @Transactional
    Empresa findByCnpj(String cnpj);

}
