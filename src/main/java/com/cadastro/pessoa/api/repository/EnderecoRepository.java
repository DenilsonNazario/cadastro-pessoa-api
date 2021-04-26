package com.cadastro.pessoa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.pessoa.api.models.EnderecoModel;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long>{

}
