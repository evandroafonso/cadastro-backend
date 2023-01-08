package com.example.cadastro.api;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PessoaApi {

    private Long id;
    private Date dataInclusao;
    private Date dataAlteracao;
    private String nome;
    private Date dataNascimento;
    private List<EnderecoApi> enderecos;

}
