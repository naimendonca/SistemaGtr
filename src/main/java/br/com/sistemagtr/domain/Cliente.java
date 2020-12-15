package br.com.sistemagtr.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 14, nullable = false)
	private String cpf;

	@Column(length = 20, nullable = false)
	private String rg;

	@Column(length = 20, nullable = false)
	private String telefone;

	@Column(length = 50, nullable = false)
	private String endereco;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}
