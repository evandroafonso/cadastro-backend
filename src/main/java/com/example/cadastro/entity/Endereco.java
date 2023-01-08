package com.example.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.cadastro.entity.baseEntity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "endereco", schema = "cadastro")
public class Endereco extends BaseEntity {

    private String logradouro;
    private String cep;
    private Long numero;
    private String cidade;

}