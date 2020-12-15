package br.com.sistemagtr.bean;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistemagtr.dao.FornecedorDao;
import br.com.sistemagtr.dao.ProdutoDao;
import br.com.sistemagtr.domain.Fornecedor;

import br.com.sistemagtr.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class produtoBean implements Serializable{
	
	private Produto produto;
	private List<Produto> produtos;
	private List<Fornecedor> fornecedores;
	private String acao;
	
	
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Produto getProduto() {
		if(produto == null) {
			produto = new Produto();
		}
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos(){
		return produtos;
	}
	
	public void  setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}	
	
	
	@PostConstruct
	public void listar() {
		try {
			ProdutoDao produtoDao = new ProdutoDao();
			produtos = produtoDao.listar();
								
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao carregar as informações");
			erro.printStackTrace();
		}
		
	}
	
	
	public void carregarCadastro() {

		try {

			acao = br.com.sistemagtr.util.jsfUtil.getParam("foracao");		
					
			
			String valor = br.com.sistemagtr.util.jsfUtil.getParam("forCod");

			if (valor != null) {
				
				Long codigo = Long.parseLong(valor);
				ProdutoDao produtoDao = new ProdutoDao();
				produto = produtoDao.buscar(codigo);

			} else {
				
				produto = new Produto();

			}
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}
	
	

	public void novo() {
		try{produto = new Produto();	
		
		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedores = fornecedorDao.listar();
		
	}catch (RuntimeException erro) {
		Messages.addGlobalError("Erro ao carregar o cadastro");
		erro.printStackTrace();
	}
	}
	
	public void editar() {

		try {
			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.editar(produto);
			novo();
			Messages.addGlobalInfo("Atualizado");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Atualizar");
			erro.printStackTrace();
		}

	}
	
	
	public void excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSel");
			
			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.excluir(produto);
			novo();
			Messages.addGlobalInfo("Registro Excluido");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Excluir");
			erro.printStackTrace();
		}
	}
	
	
	public void salvar() {
		try {
			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.salvar(produto);
			novo();
			Messages.addGlobalInfo("Produto Cadastrado");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}
		
	}

}