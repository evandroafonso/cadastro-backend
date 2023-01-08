package com.example.cadastro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.api.PessoaApi;
import com.example.cadastro.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping()
    @RequestMapping(method = RequestMethod.POST)
    public PessoaApi persistir(@Valid @RequestBody PessoaApi api) {
	return pessoaService.persistir(api);
    }

    @PutMapping()
    @RequestMapping(method = RequestMethod.PUT)
    public PessoaApi atualizar(@Valid @RequestBody PessoaApi api) throws Exception {
	return pessoaService.atualizar(api);
    }

    @GetMapping()
    @RequestMapping(method = RequestMethod.GET)
    public List<PessoaApi> listarTodos() {
	return pessoaService.listarTodos();
    }

    @GetMapping()
    @RequestMapping("/listar-por-id")
    public PessoaApi listarPorId(@RequestParam Long id) throws Exception {
	return pessoaService.listarPorId(id);
    }
}
