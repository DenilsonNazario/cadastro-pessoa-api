package com.cadastro.pessoa.api.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cadastro.pessoa.api.models.PessoaModel;
import com.cadastro.pessoa.api.services.PessoaService;


@RestController // anotação para dizer explicidamente que esta e uma classe de controle
@RequestMapping("/api") // uri para acessar os metodos da classe
//@Api(value = "API Cadastro de Pessoa")
@CrossOrigin(origins = "*") // aceitar requisições de todos os dominios
public class PessoaController {

	private PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@GetMapping("v1/pessoa/lista")
	@ResponseStatus(HttpStatus.OK) // status do retorno
	// @ApiOperation(value = "Retorna uma lista de pessoas cadastrados no sistema.")
	public ResponseEntity<List<PessoaModel>> getPessoas() {// pegar lista de pessoas
		List<PessoaModel> lista = pessoaService.buscarTodos();
		if (lista.isEmpty()) {// caso a lista estiver vazia, retorna não existe
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/v1/pessoa/buscar/{id}")
	// @ApiOperation(value="Retorna um registro espeficífico.")
	public ResponseEntity<PessoaModel> getPessoa(@PathVariable("id") long id) {// pegar altor por id
		Optional<PessoaModel> pessoas = pessoaService.buscarPorId(id);
		if (!pessoas.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro não encontrado.");// caso nao existe
																								// retorna que n existe
		}
		return ResponseEntity.ok(pessoas.get());
	}

	@PostMapping(value = "v1/pessoa/salvar") // metodo a ser chamado
	@ResponseStatus(HttpStatus.CREATED) // status do retorno
	// @ApiOperation(value = "insere uma pessoa na base de dados.")
	public @Validated ResponseEntity<PessoaModel> salvaPessoa(@Validated @RequestBody PessoaModel pessoa) {
		try {
			String nome = pessoa.getNome();
			if (nome.isBlank() || nome.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Nome deve ser informado.");
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Nome deve ser informado.");
		}
	

		if (!pessoa.getEmail().isEmpty()) {// se o email informado nao for vazio
			if (pessoaService.buscarPorEmail(pessoa.getEmail()).isPresent()) {// caso já exista email cadastrado,																			// retorna
				System.out.println("Email ja cadastrado");																// bad request
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado.");
			}
		}
		if (!pessoa.getCpf().isEmpty()) {// verifica se o cpf ja esta cadastrado
			if (pessoaService.buscarPorCpf(pessoa.getCpf()).isPresent()) {// caso já exista o cpf cadastrado, retorna
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já cadastrado.");
			}
			if (pessoa.getCpf().length() != 11) {// verifica se o cpf possue 11 caracteres bad request
				System.out.println("cpf invalido");
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF inválido.");
			}

		}else {throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O CPF deve ser informado.");}
		if (pessoa.getNascimento() == null) {// valida nascimento
			System.out.println("nascimento n foi informado");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A Data de nascimento Deve ser informada.");
		}
		return new ResponseEntity<PessoaModel>(pessoaService.gravarPessoa(pessoa), HttpStatus.CREATED);//ResponseEntity.created("",pessoaService.gravarPessoa(pessoa));
	}
	
	@PutMapping(value = "v1/pessoa/gravar")
	@ResponseStatus(HttpStatus.OK)
	//@ApiOperation(value = "Atualiza um registro no banco de dados")
	public PessoaModel updatePessoa(@Validated @RequestBody PessoaModel pessoa) {
		return pessoaService.gravarPessoa(pessoa);
	}

	@DeleteMapping("v1/pessoa/deletar/{id}")
	@ResponseStatus(HttpStatus.OK)
	//@ApiOperation(value = "Remove um cadastro da base de dados.")
	public void deletarPessoa(@PathVariable("id") long id) {
		pessoaService.deletarPessoa(id);
	}
	

}
