package com.cadastro.pessoa.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cadastro.pessoa.api.models.EnderecoModel;
import com.cadastro.pessoa.api.repository.EnderecoRepository;

@Component
public class EnderecoService {
	
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public EnderecoModel gravar(EnderecoModel endereco) {
		return enderecoRepository.save(endereco);
	}

}
