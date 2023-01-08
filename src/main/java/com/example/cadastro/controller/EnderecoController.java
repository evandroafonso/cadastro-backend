package com.example.cadastro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.api.EnderecoApi;
import com.example.cadastro.service.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping()
    @RequestMapping(method = RequestMethod.POST)
    public EnderecoApi persistir(@Valid @RequestBody EnderecoApi api) {
	return enderecoService.persistir(api);
    }

    @GetMapping()
    @RequestMapping("/listar-por-pessoa")
    public List<EnderecoApi> listarPorId(@RequestParam Long idPessoa) {
	return enderecoService.listarPorPessoa(idPessoa);
    }

}
