package com.example.cadastro.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cadastro.api.EnderecoApi;
import com.example.cadastro.api.PessoaApi;
import com.example.cadastro.entity.Pessoa;
import com.example.cadastro.service.EnderecoService;

@Component
public class PessoaConverter {

    @Autowired
    EnderecoService enderecoService;

    public Pessoa toEntity(PessoaApi api) {
	Pessoa entity = new Pessoa();

	entity.setId(api.getId());
	entity.setDataInclusao(api.getDataInclusao());
	entity.setDataAlteracao(api.getDataAlteracao());
	entity.setNome(api.getNome());
	entity.setDataNascimento(api.getDataNascimento());
	entity.setIdsEnderecos(api.getEnderecos().stream().map(EnderecoApi::getId).collect(Collectors.toSet()));

	return entity;
    }

    public PessoaApi toApi(Pessoa entity) {
	PessoaApi api = new PessoaApi();

	api.setId(entity.getId());
	api.setDataInclusao(entity.getDataInclusao());
	api.setDataAlteracao(entity.getDataAlteracao());
	api.setNome(entity.getNome());
	api.setDataNascimento(entity.getDataNascimento());
	api.setEnderecos(enderecoService.listarPorIds(entity.getIdsEnderecos()));

	return api;
    }

    public List<PessoaApi> toListApi(List<Pessoa> entityList) {

	List<PessoaApi> apiList = new ArrayList<PessoaApi>();

	entityList.stream().forEach(entity -> apiList.add(this.toApi(entity)));

	return apiList;
    }

}
