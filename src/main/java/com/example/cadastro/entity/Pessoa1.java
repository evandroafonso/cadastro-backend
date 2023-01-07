package com.example.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pessoa1", schema = "cadastro")
public class Pessoa1 {

    @Id
    private String nome;

}
