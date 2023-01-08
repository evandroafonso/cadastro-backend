package com.example.cadastro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "enderecoPessoa", schema = "cadastro")
public class EnderecoPessoa {

    @Id
    private Long id;
    private Long idPessoa;
    private Long idEndereco;

}
