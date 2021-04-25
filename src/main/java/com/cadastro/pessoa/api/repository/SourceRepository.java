package com.cadastro.pessoa.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cadastro.pessoa.api.models.SourceModel;



public interface SourceRepository extends JpaRepository<SourceModel, Long> {
		
		List<SourceModel> findAll();

	}

