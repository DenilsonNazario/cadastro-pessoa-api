package com.cadastro.pessoa.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.pessoa.api.models.SourceModel;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController // anotação para dizer explicidamente que esta e uma classe de controle
@RequestMapping("/api") // uri para acessar os metodos da classe
@Api(value = "API Cadastro de Pessoa")
@CrossOrigin(origins = "*") // aceitar requisições de todos os dominios
public class SourceController {
	
//	@Autowired(required=true) // auto criar instancias
//	private SourceRepository sourceRepository;
	
	
	@GetMapping("v1/source")
	@ApiOperation(value = "Retorna uma lista de links local e remoto do projeto.")
	public ResponseEntity<List<SourceModel>> getSource() {// pegar lista de autores
		List<SourceModel> lista = new ArrayList<SourceModel>();

		SourceModel model = new SourceModel(1L, "Link swagger local","http://localhost:8080/swagger-ui.html");
		SourceModel model2 = new SourceModel(1L, "Link Repositório git hub","https://github.com/DenilsonNazario/cadastro-pessoa-api");
		lista.add(model);
		lista.add(model2);		

		return ResponseEntity.ok(lista);
	}

}
