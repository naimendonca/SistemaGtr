package br.com.sistemagtr.domain;


import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Fornecedor extends GenericDomain {

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 18, nullable = false)
	private String cnpj;

	@Column(length = 20, nullable = false)
	private String telefone;

	@Column(length = 30, nullable = false)
	private String endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

}