package com.ederfaria.pontointeligente.api.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

//    private static final long serialVersionUID = 3960436649365666213L;

    @Id
//    @SequenceGenerator(name= "EMPRESA_SEQUENCE", sequenceName = "EMPRESA_SEQUENCE_ID", initialValue=1, allocationSize = 1)
//    @GeneratedValue(strategy=GenerationType.AUTO, generator="EMPRESA_SEQUENCE")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String razaoSocial;
    private String cnpj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
