package com.example.cadastro.api;

import java.util.Date;

import lombok.Data;

@Data
public class PessoaApi {

    private Long id;
    private Date dataInclusao;
    private Date dataAlteracao;
    private String nome;
    private Date dataNascimento;

}
