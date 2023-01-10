package com.example.cadastro.api;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoApi {

    private Long id;
    private Date dataInclusao;
    private Date dataAlteracao;
    private String logradouro;
    private String cep;
    private Long numero;
    private String cidade;
    private Boolean principal;

}
