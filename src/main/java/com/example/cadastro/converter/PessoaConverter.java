package com.example.cadastro.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cadastro.api.PessoaApi;
import com.example.cadastro.entity.Pessoa;

@Component
public class PessoaConverter {

    public Pessoa toEntity(PessoaApi api) {
	Pessoa entity = new Pessoa();

	entity.setId(api.getId());
	entity.setDataInclusao(api.getDataInclusao());
	entity.setDataAlteracao(api.getDataAlteracao());
	entity.setNome(api.getNome());
	entity.setDataNascimento(api.getDataNascimento());

	return entity;
    }

    public PessoaApi toApi(Pessoa entity) {
	PessoaApi api = new PessoaApi();

	api.setId(entity.getId());
	api.setDataInclusao(entity.getDataInclusao());
	api.setDataAlteracao(entity.getDataAlteracao());
	api.setNome(entity.getNome());
	api.setDataNascimento(entity.getDataNascimento());

	return api;
    }

    public List<PessoaApi> toListApi(List<Pessoa> entityList) {

	List<PessoaApi> apiList = new ArrayList<PessoaApi>();

	entityList.stream().forEach(entity -> apiList.add(this.toApi(entity)));

	return apiList;
    }

}
