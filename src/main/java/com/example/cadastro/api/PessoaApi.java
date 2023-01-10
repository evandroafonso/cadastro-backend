package com.example.cadastro.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaApi {

    private Long id;
    private Date dataInclusao;
    private Date dataAlteracao;
    private String nome;
    private Date dataNascimento;
    private List<EnderecoApi> enderecos = new ArrayList<>();

}
