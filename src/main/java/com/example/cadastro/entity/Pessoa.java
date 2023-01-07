package com.example.cadastro.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.cadastro.entity.baseEntity.BaseEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "pessoa", schema = "cadastro")
public class Pessoa extends BaseEntity {

    private String nome;
    private Date dataNascimento;

}
