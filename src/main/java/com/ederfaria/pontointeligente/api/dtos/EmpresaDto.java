package com.ederfaria.pontointeligente.api.dtos;

import com.ederfaria.pontointeligente.api.entities.Empresa;
import org.hibernate.validator.constraints.Length;

import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.NotEmpty;

public class EmpresaDto {

    private Long id;

    @NotEmpty(message = "CNPJ não pode ser vazio")
    @Length(min = 3,max = 30,message = "CNPJ deve conter de 3 a 30 caracteres")
    private String cnpj;
    @NotEmpty(message = "RAZAO SOCIAL não pode ser vazio")
    @Length(min = 3,max = 30,message = "RAZAO SOCIAL deve conter de 3 a 30 caracteres")
    private String razaoSocial;

    public EmpresaDto() {
    }

    public EmpresaDto(Long id, String cnpj, String razaoSocial) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        return "EmpresaDto{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                '}';
    }

    public Empresa toEntity(){
        Empresa entity = new Empresa();
        entity.setId(getId());
        entity.setCnpj(getCnpj());
        entity.setRazaoSocial(getRazaoSocial());
        return entity;
    }
}
