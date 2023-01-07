package com.example.cadastro.entity;

import java.util.Date;

import com.example.cadastro.entity.baseEntity.BaseEntity;

import lombok.Data;

@Data
public class Pessoa extends BaseEntity {

    private String nome;
    private Date dataNascimento;

}
