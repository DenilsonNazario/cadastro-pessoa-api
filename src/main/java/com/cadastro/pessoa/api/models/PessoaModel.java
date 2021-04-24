package com.cadastro.pessoa.api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PESSOA")
public class PessoaModel {
	
	@Id//auto increment no banco de dados
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pessoa_id;
	
	@Column(nullable = false)//nao deve ser null
	private String nome;

    private String Sexo;
    private String email;    // email não obrigatório, deve ser validado caso preenchido

    @Column	
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date nascimento; //Data de Nascimento - obrigatório, deve ser validada
	
    private String naturalidade;//Naturalidade
    private String nacionalidade;//Nacionalidade
	
	@Column(nullable = false) //nao deve ser null
	private String cpf;//CPF - obrigatório, deve ser validado (formato e não pode haver dois cadastros com mesmo cpf)
	
	private Date dt_cadastro;
	private Date dt_atualizado;
	
    @PrePersist
    public void onPrePersist() { dt_cadastro = new Date(); }
      
    @PreUpdate
    public void onPreUpdate() { dt_atualizado = new Date(); }

    public PessoaModel() {}
	public PessoaModel(Long pessoa_id, String nome, String sexo, String email, Date nascimento, String naturalidade,
			String nacionalidade, String cpf, Date dt_cadastro, Date dt_atualizado) {
		super();
		this.pessoa_id = pessoa_id;
		this.nome = nome;
		Sexo = sexo;
		this.email = email;
		this.nascimento = nascimento;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
		this.dt_cadastro = dt_cadastro;
		this.dt_atualizado = dt_atualizado;
	}

	public Long getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(Long pessoa_id) {
		this.pessoa_id = pessoa_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public Date getDt_atualizado() {
		return dt_atualizado;
	}

	public void setDt_atualizado(Date dt_atualizado) {
		this.dt_atualizado = dt_atualizado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoa_id == null) ? 0 : pessoa_id.hashCode());
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
		PessoaModel other = (PessoaModel) obj;
		if (pessoa_id == null) {
			if (other.pessoa_id != null)
				return false;
		} else if (!pessoa_id.equals(other.pessoa_id))
			return false;
		return true;
	}
	
	
    
    

}
