package com.cadastro.pessoa.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cadastro.pessoa.api.models.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long>{
	
	List<PessoaModel> findAll();
	Optional<PessoaModel> findByEmail(String email);
	Optional<PessoaModel> findByCpf(String cpf);

}
