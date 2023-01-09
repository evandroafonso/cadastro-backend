package com.example.cadastro.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<EnderecoApi> listarPorPessoa(Long idPessoa) {
	List<Endereco> entities = enderecoRepository.listarPorPessoa(idPessoa);
	return enderecoConverter.toListApi(entities);
    }

    public void alterarEnderecoPrincipal(List<EnderecoApi> enderecosApi) {
	List<Long> ids = enderecosApi.stream().map(i -> i.getId()).collect(Collectors.toList());
	List<Endereco> entities = enderecoRepository.findAllById(ids);

	// remove endereços anteriormente marcados como principais e atualiza
	entities.stream().forEach(a -> {
	    a.setPrincipal(null);
	    enderecoRepository.save(a);
	    for (EnderecoApi api : enderecosApi) {
		if (a.getId() == api.getId()) {
		    a.setPrincipal(api.getPrincipal());
		}
	    }
	});

    }

}
