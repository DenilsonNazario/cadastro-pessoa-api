package com.cadastro.pessoa.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "enderecos")
public class EnderecoModel {

	
	@Id//auto increment no banco de dados
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long endereco_id;
	
	private String bairro;
	private String cep;
	private String cidade_nome;
	private String estado_nome;
	private String logradouro;
	private String numero;
	private String referencia;

	@JsonIgnore
	@OneToMany(mappedBy = "endereco")
	private List<PessoaModel> pessoas = new ArrayList<PessoaModel>();
	
	public EnderecoModel() {
		
	}
	


	public EnderecoModel(Long endereco_id, String bairro, String cep, String cidade_nome, String estado_nome,
			String logradouro, String numero, String referencia, List<PessoaModel> pessoas) {
		super();
		this.endereco_id = endereco_id;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade_nome = cidade_nome;
		this.estado_nome = estado_nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.referencia = referencia;
		this.pessoas = pessoas;
	}
	
	



	public Long getEndereco_id() {
		return endereco_id;
	}



	public void setEndereco_id(Long endereco_id) {
		this.endereco_id = endereco_id;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getCidade_nome() {
		return cidade_nome;
	}



	public void setCidade_nome(String cidade_nome) {
		this.cidade_nome = cidade_nome;
	}



	public String getEstado_nome() {
		return estado_nome;
	}



	public void setEstado_nome(String estado_nome) {
		this.estado_nome = estado_nome;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getReferencia() {
		return referencia;
	}



	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}



	public List<PessoaModel> getPessoas() {
		return pessoas;
	}



	public void setPessoas(List<PessoaModel> pessoas) {
		this.pessoas = pessoas;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endereco_id == null) ? 0 : endereco_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoModel other = (EnderecoModel) obj;
		if (endereco_id == null) {
			if (other.endereco_id != null)
				return false;
		} else if (!endereco_id.equals(other.endereco_id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
}
