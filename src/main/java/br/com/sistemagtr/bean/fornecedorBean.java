package br.com.sistemagtr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistemagtr.dao.FornecedorDao;
import br.com.sistemagtr.domain.Fornecedor;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class fornecedorBean implements Serializable{

	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;
	private String acao;
	
	
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Fornecedor getFornecedor() {
		if(fornecedor == null) {
			fornecedor = new Fornecedor();
		}
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores(){
		return fornecedores;
	}
	
	public void  setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	
	@PostConstruct
	public void listar() {
		try {
			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedores = fornecedorDao.listar();
								
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
				FornecedorDao fornecedorDao = new FornecedorDao();
				fornecedor = fornecedorDao.buscar(codigo);

			} else {
				
				fornecedor = new Fornecedor();

			}
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}
	
	

	public void novo() {
		fornecedor = new Fornecedor();	
	}
	
	public void editar() {

		try {
			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedorDao.editar(fornecedor);
			novo();
			Messages.addGlobalInfo("Atualizado");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Atualizar");
			erro.printStackTrace();
		}

	}
	
	
	public void excluir(ActionEvent evento) {
		try {
			fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("fornecedorSel");
			
			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedorDao.excluir(fornecedor);
			novo();
			Messages.addGlobalInfo("Registro Excluido");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Excluir");
			erro.printStackTrace();
		}
	}
	
	
	public void salvar() {
		try {
			FornecedorDao fornecedorDao = new FornecedorDao();
			fornecedorDao.salvar(fornecedor);
			novo();
			Messages.addGlobalInfo("Fornecedor Cadastrado");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}
		
	}

}