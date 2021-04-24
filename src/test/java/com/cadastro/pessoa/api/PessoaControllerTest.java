package com.cadastro.pessoa.api;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.cadastro.pessoa.api.controller.PessoaController;
import com.cadastro.pessoa.api.models.PessoaModel;
import com.cadastro.pessoa.api.repository.PessoaRepository;
import com.cadastro.pessoa.api.services.PessoaService;

import io.restassured.http.ContentType;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class PessoaControllerTest {
	
	@Autowired
	private PessoaController pessoaController;
	
	@MockBean
	private PessoaService pessoaService;
	
	@MockBean
	private PessoaRepository pessoaRepository;
	
	
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.pessoaController);
	}
	@Test
	public void deveRetornarStatus404_QuandoNaoExistirPessoaCadastrada() {
		when(this.pessoaService.buscarTodos()).thenReturn(new ArrayList<>());
		
		given()
				.accept(ContentType.JSON)
			.when()
				.get("/api/v1/pessoa/lista")
			.then()
		.statusCode(HttpStatus.NOT_FOUND.value());
	}
	@Test
	public void deveRetornarStatus200_QuandoExistirPessoaCadastrada() {
		//cenario
		List<PessoaModel> lista =new ArrayList<>();
		lista.add(new PessoaModel());
		lista.add(new PessoaModel());

		when(this.pessoaService.buscarTodos()).thenReturn(lista);
		
		given()
				.accept(ContentType.JSON)
			.when()
				.get("/api/v1/pessoa/lista")
			.then()
		.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarStatus200_QuandoConsultarPessoaExistentePorId() {
		//cenario
		PessoaModel pessoa = new PessoaModel();
		pessoa.setNome("Pessoa Test");
		pessoa.setPessoa_id(1L);
		Optional<PessoaModel> pessoaOptional = Optional.of(pessoa);

		when(this.pessoaService.buscarPorId(1L)).thenReturn(pessoaOptional);
		given()
				.accept(ContentType.JSON)
			.when()
				.get("/api/v1/pessoa/buscar/{id}",1L)
			.then()
		.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarStatus404_QuandoConsultarPessoaInexistentePorId() {
		//cenario
		PessoaModel pessoa = new PessoaModel();
		pessoa.setNome("Pessoa Test");
		pessoa.setPessoa_id(1L);
		Optional<PessoaModel> pessoaOptional = Optional.of(pessoa);

		when(this.pessoaService.buscarPorId(1L)).thenReturn(pessoaOptional);
		given()
				.accept(ContentType.JSON)
			.when()
				.get("/api/v1/pessoa/buscar/{id}",2L)
			.then()
		.statusCode(HttpStatus.NOT_FOUND.value());
	}
}
