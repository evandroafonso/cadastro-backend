package com.example.cadastro.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro.api.EnderecoApi;
import com.example.cadastro.converter.EnderecoConverter;
import com.example.cadastro.entity.Endereco;
import com.example.cadastro.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoConverter enderecoConverter;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Transactional
    public EnderecoApi persistir(EnderecoApi api) {
	Endereco entity = enderecoConverter.toEntity(api);
	return enderecoConverter.toApi(enderecoRepository.save(entity));
    }

    public List<EnderecoApi> listarPorIds(Set<Long> ids) {
	List<Endereco> entities = enderecoRepository.findAllById(ids);
	return enderecoConverter.toListApi(entities);
    }

}
