package com.example.cadastro.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.cadastro.api.EnderecoApi;
import com.example.cadastro.entity.Endereco;

@Component
public class EnderecoConverter {

    public Endereco toEntity(EnderecoApi api) {
	Endereco entity = new Endereco();

	entity.setId(api.getId());
	entity.setDataInclusao(api.getDataInclusao());
	entity.setDataAlteracao(api.getDataAlteracao());
	entity.setLogradouro(api.getLogradouro());
	entity.setNumero(api.getNumero());
	entity.setCep(api.getCep());
	entity.setCidade(api.getCidade());
	entity.setPrincipal(api.getPrincipal());

	return entity;
    }

    public EnderecoApi toApi(Endereco entity) {
	EnderecoApi api = new EnderecoApi();

	api.setId(entity.getId());
	api.setDataInclusao(entity.getDataInclusao());
	api.setDataAlteracao(entity.getDataAlteracao());
	api.setLogradouro(entity.getLogradouro());
	api.setNumero(entity.getNumero());
	api.setCep(entity.getCep());
	api.setCidade(entity.getCidade());
	api.setPrincipal(entity.getPrincipal());

	return api;
    }

    public List<EnderecoApi> toListApi(List<Endereco> entityList) {

	List<EnderecoApi> apiList = new ArrayList<EnderecoApi>();

	entityList.stream().forEach(entity -> apiList.add(this.toApi(entity)));

	return apiList;
    }

}
