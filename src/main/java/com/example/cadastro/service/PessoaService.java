package com.example.cadastro.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro.api.PessoaApi;
import com.example.cadastro.converter.PessoaConverter;
import com.example.cadastro.entity.Pessoa;
import com.example.cadastro.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaConverter pessoaConverter;

    @Autowired
    PessoaRepository pessoaRepository;

    @Transactional
    public PessoaApi persistir(PessoaApi api) {
	Pessoa entity = pessoaConverter.toEntity(api);
	return pessoaConverter.toApi(pessoaRepository.save(entity));
    }

    @Transactional
    public PessoaApi atualizar(PessoaApi api) {
	Pessoa entity = pessoaConverter.toEntity(api);
	return pessoaConverter.toApi(pessoaRepository.save(entity));
    }

    public List<PessoaApi> listarTodos() {
	List<Pessoa> entity = pessoaRepository.findAll();
	return pessoaConverter.toListApi(entity);
    }

}
