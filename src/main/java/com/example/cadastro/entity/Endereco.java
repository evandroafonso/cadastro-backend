package com.example.cadastro.entity;

import com.example.cadastro.entity.baseEntity.BaseEntity;

import lombok.Data;

@Data
public class Endereco extends BaseEntity {

    private String logradouro;
    private String CEP;
    private String numero;
    private String cidade;

}
