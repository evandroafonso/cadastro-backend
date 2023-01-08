package com.example.cadastro.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.cadastro.entity.Endereco;
import com.example.cadastro.repository.custom.EnderecoRepositoryCustom;

@Repository
public class EnderecoRepositoryImpl implements EnderecoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Endereco> listarPorPessoa(Long idPessoa) {

	final StringBuilder comandoHql = new StringBuilder();
	comandoHql.append("SELECT endereco FROM Endereco endereco, Pessoa pessoa ");
	comandoHql.append("JOIN pessoa.idsEnderecos idsEnderecosPessoa ");
	comandoHql.append("WHERE idsEnderecosPessoa.idPessoa = :idPessoa");

	TypedQuery<Endereco> query = entityManager.createQuery(comandoHql.toString(), Endereco.class);

	query.setParameter("idPessoa", idPessoa);

	return query.getResultList();
    }

}
