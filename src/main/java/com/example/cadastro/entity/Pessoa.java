package com.example.cadastro.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import com.example.cadastro.entity.baseEntity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "pessoa", schema = "cadastro")
public class Pessoa extends BaseEntity {

    private String nome;
    private Date dataNascimento;

    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    @JoinTable(name = "enderecoPessoa", schema = "cadastro", joinColumns = @JoinColumn(name = "idPessoa"))
    @Column(name = "idEndereco")
    private Set<Long> idsEnderecos;

}
