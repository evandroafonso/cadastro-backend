package com.example.cadastro.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.cadastro.entity.baseEntity.BaseEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "endereco", schema = "cadastro")
public class Endereco extends BaseEntity {

    private String logradouro;
    private String cep;
    private Long numero;
    private String cidade;
    private Boolean principal;

    public Endereco(Long id, @NotNull String uuid, Date dataInclusao, Date dataAlteracao, String logradouro, String cep,
	    Long numero, String cidade, Boolean principal) {
	super(id, uuid, dataInclusao, dataAlteracao);
	this.logradouro = logradouro;
	this.cep = cep;
	this.numero = numero;
	this.cidade = cidade;
	this.principal = principal;
    }

}