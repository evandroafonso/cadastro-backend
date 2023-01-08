package com.example.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cadastro.entity.Endereco;
import com.example.cadastro.repository.custom.EnderecoRepositoryCustom;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>, EnderecoRepositoryCustom {

}
