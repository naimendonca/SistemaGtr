package br.com.sistemagtr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain{
	
	@Column(length = 50, nullable = false)
	private String nome;

	@JoinColumn(nullable = false)
	@ManyToOne
	private Fornecedor fornecedor;
	
	@Column(length = 50, nullable = false)
	private Float valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
}