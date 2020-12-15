package br.com.sistemagtr.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Venda extends GenericDomain {
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date horario;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Produto produto;
	
	@Column(nullable = false)
	private Short quantidade;
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}
	
	
}