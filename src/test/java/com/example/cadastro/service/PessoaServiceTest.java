package com.example.cadastro.service;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cadastro.api.EnderecoApi;
import com.example.cadastro.api.PessoaApi;
import com.example.cadastro.converter.PessoaConverter;
import com.example.cadastro.entity.Pessoa;
import com.example.cadastro.repository.PessoaRepository;

@SpringBootTest
class PessoaServiceTest {

    private static final Long ID = 1L;
    private static final @NotNull String UUID = "49536968-d2f3-4938-ad87-b92e14131801";
    private static final Date DATAINCLUSAO = new Date();
    private static final Date DATAALTERACAO = new Date();
    private static final String NOME = "João da Silva";
    private static final Date DATANASCIMENTO = new Date();
    private static final Set<Long> IDSENDERECO = new HashSet<>();
    private static final List<EnderecoApi> ENDERECOS = new ArrayList<>();
    private static final String LOGRADOURO = "Rua João Gaion";
    private static final String CEP = "86036-640";
    private static final Long NUMERO = 1234L;
    private static final String CIDADE = "Londrina";
    private static final Boolean PRINCIPAL = true;
    private static final Object OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    private static final int INDEX = 0;

    @Spy
    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Spy
    @InjectMocks
    private PessoaConverter pessoaConverter;

    private PessoaApi pessoaApi;
    private Pessoa pessoa;
    private Optional<Pessoa> optionalPessoa;
    private EnderecoApi enderecoApi;

    @BeforeEach
    void setUp() {
	MockitoAnnotations.openMocks(this);
	this.preparaPessoa();
    }

    @Test
    @DisplayName("listar pessoa por id")
    void listarPessoaPorId() throws Exception {
	when(pessoaRepository.findById(anyLong())).thenReturn(optionalPessoa);

	PessoaApi responseApi = pessoaService.listarPorId(ID);
	assertNotNull(responseApi);
	assertEquals(PessoaApi.class, responseApi.getClass());
	assertEquals(ID, responseApi.getId());
	assertEquals(DATAINCLUSAO, responseApi.getDataInclusao());
	assertEquals(DATAALTERACAO, responseApi.getDataAlteracao());
	assertEquals(NOME, responseApi.getNome());
	assertEquals(DATANASCIMENTO, responseApi.getDataNascimento());
	assertEquals(ENDERECOS, responseApi.getEnderecos());

    }

    @Test
    @DisplayName("listar pessoa por id retorna objeto não encontrado")
    void listarPorIdObjetoNaoEncontrado() {
	when(pessoaRepository.findById(anyLong())).thenReturn(optionalPessoa);
	try {
	    pessoaService.listarPorId(ID);
	} catch (Exception ex) {
	    assertEquals(ObjectNotFoundException.class, ex.getClass());
	    assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
	}

    }

    @Test
    @DisplayName("listar todas as Pessas")
    void listarTodasPessoas() {
	when(pessoaRepository.findAll()).thenReturn((List.of(pessoa)));

	List<PessoaApi> responseListApi = pessoaService.listarTodos();

	assertNotNull(responseListApi);
	assertEquals(1, responseListApi.size());
	assertEquals(PessoaApi.class, responseListApi.get(INDEX).getClass());
	assertEquals(pessoaApi, responseListApi.get(INDEX));

    }

    @Test
    @DisplayName("listar todos as pessoas retorna objeto não encontrado")
    void listarTodosObjetoNaoEncontrado() {
	when(pessoaRepository.findById(anyLong())).thenReturn(optionalPessoa);
	try {
	    pessoaService.listarTodos();
	} catch (Exception ex) {
	    assertEquals(ObjectNotFoundException.class, ex.getClass());
	    assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
	}

    }

    @Test
    @DisplayName("persistir e retornar o objeto Pessoa persistido")
    void persistirPessoaERetornarObjeto() {
	when(pessoaRepository.save(any())).thenReturn(pessoa);

	PessoaApi responseApi = pessoaService.persistir(pessoaApi);

	assertNotNull(responseApi);
	assertEquals(PessoaApi.class, responseApi.getClass());
	assertEquals(pessoaApi, responseApi);
    }

    @Test
    @DisplayName("atualizar e retornar o objeto Pessoa atualizado")
    void atualizarPessoaERetornarObjeto() throws Exception {
	when(pessoaRepository.save(any())).thenReturn(pessoa);

	PessoaApi responseApi = pessoaService.atualizar(pessoaApi);

	assertNotNull(responseApi);
	assertEquals(PessoaApi.class, responseApi.getClass());
	assertEquals(pessoaApi, responseApi);
    }

    // TODO: adicionar teste para endereço principal de Pessoa

    private void preparaPessoa() {
	pessoa = new Pessoa(ID, UUID, DATAINCLUSAO, DATAALTERACAO, NOME, DATANASCIMENTO, IDSENDERECO);
	pessoaApi = new PessoaApi(ID, DATAINCLUSAO, DATAALTERACAO, NOME, DATANASCIMENTO, ENDERECOS);
	optionalPessoa = Optional
		.of(new Pessoa(ID, UUID, DATAINCLUSAO, DATAALTERACAO, NOME, DATANASCIMENTO, IDSENDERECO));
	enderecoApi = new EnderecoApi();
    }

}
