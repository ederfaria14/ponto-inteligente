package com.ederfaria.pontointeligente.api.repositories;

import com.ederfaria.pontointeligente.api.entities.Empresa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

    @Autowired
    private EmpresaRepository repositor;

    @Test
    public void saveEmpresa() {
        System.out.println("Save Empresa");
        Empresa empresa = new Empresa();
        empresa.setCnpj("1234567890001-1");
        empresa.setRazaoSocial("Dextra");

        Empresa entity = repositor.save(empresa);
        System.out.println("\n\n------------------- Salvou -------------------"+entity.toString()+"\n\n");
        Assertions.assertEquals(1, entity.getId());
    }

    @Test
    public void findByRazaoSocial() {
        System.out.println("Busca Empresa");
        Empresa empresa = new Empresa();
        empresa.setCnpj("1234567890001-1");
        empresa.setRazaoSocial("dextra");

        Empresa entity = repositor.findByCnpj("1234567890001-1");
        System.out.println("\n\n------------------- Salvou -------------------"+entity.toString()+"\n\n");
        Assertions.assertNotNull(entity);
    }

    @Test
    public void notFindByRazaoSocial() {
        System.out.println("Busca Empresa inexistente");
        Empresa entity = repositor.findByCnpj("113345434664");
        Assertions.assertNull(entity);
    }
}
