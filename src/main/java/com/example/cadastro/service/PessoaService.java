package com.example.cadastro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    EnderecoService enderecoService;

    Logger logger = LoggerFactory.getLogger(PessoaService.class);

    @Transactional
    public PessoaApi persistir(PessoaApi api) {
	Pessoa entity = pessoaConverter.toEntity(api);
	if (api.getEnderecos() != null && api.getEnderecos().isEmpty()) {
	    Boolean possuiEnderecoPrincipal = api.getEnderecos().stream().anyMatch(i -> i.getPrincipal());
	    if (possuiEnderecoPrincipal.equals(Boolean.TRUE)) {
		enderecoService.alterarEnderecoPrincipal(api.getEnderecos());
	    }
	}

	return pessoaConverter.toApi(pessoaRepository.save(entity));
    }

    @Transactional
    public PessoaApi atualizar(PessoaApi api) throws Exception {

	if (api.getId() != null) {
	    Pessoa entity = pessoaConverter.toEntity(api);

	    List<Boolean> possuiEnderecoPrincipal = api.getEnderecos().stream().map(i -> i.getPrincipal())
		    .collect(Collectors.toList());

	    if (possuiEnderecoPrincipal != null && possuiEnderecoPrincipal.contains(Boolean.TRUE)) {
		enderecoService.alterarEnderecoPrincipal(api.getEnderecos());
	    }
	    return pessoaConverter.toApi(pessoaRepository.save(entity));
	} else {
	    logger.error("Registro incompleto, tente novamente!");
	    throw new Error();
	}

    }

    public List<PessoaApi> listarTodos() {
	List<Pessoa> entity = pessoaRepository.findAll();
	return pessoaConverter.toListApi(entity);
    }

    public PessoaApi listarPorId(Long id) throws Exception {

	try {
	    Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
	    return pessoaConverter.toApi(optionalPessoa.get());
	} catch (Exception exception) {
	    throw new Exception("Registro não encontrado", exception);
	}

    }

}
