package com.example.cadastro.api;

import java.util.Date;

import lombok.Data;

@Data
public class EnderecoApi {

    private Long id;
    private Date dataInclusao;
    private Date dataAlteracao;
    private String logradouro;
    private String cep;
    private Long numero;
    private String cidade;

}
