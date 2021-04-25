package com.cadastro.pessoa.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cadastro.pessoa.api.models.PessoaModel;
import com.cadastro.pessoa.api.repository.PessoaRepository;

@Component
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<PessoaModel> buscarTodos(){
		return pessoaRepository.findAll();
	}
	
	
	public Optional<PessoaModel> buscarPorId(Long id){
		return pessoaRepository.findById(id);
	}
	
	public Optional<PessoaModel> buscarPorEmail(String email){
		return pessoaRepository.findByEmail(email);
	}
	
	public Optional<PessoaModel> buscarPorCpf(String cpf){
		return pessoaRepository.findByCpf(cpf);
	}
	
	public PessoaModel gravarPessoa(PessoaModel pessoa){
		return pessoaRepository.save(pessoa);
	}
	
	public void deletarPessoa(Long id){
		 pessoaRepository.deleteById(id);
	}
	
	
}
