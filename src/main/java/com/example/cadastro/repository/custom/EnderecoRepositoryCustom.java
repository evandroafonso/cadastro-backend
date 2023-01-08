package com.example.cadastro.repository.custom;

import java.util.List;

import com.example.cadastro.entity.Endereco;

public interface EnderecoRepositoryCustom {

    List<Endereco> listarPorPessoa(Long idPessoa);

}
