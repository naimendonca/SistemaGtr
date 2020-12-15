package br.com.sistemagtr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistemagtr.dao.FuncionarioDao;
import br.com.sistemagtr.domain.Funcionario;
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class funcionarioBean implements Serializable{
	
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private String acao;
	
	
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Funcionario getFuncionario() {
		if(funcionario == null) {
			funcionario = new Funcionario();
		}
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios(){
		return funcionarios;
	}
	
	public void  setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	
	@PostConstruct
	public void listar() {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarios = funcionarioDao.listar();
								
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
				FuncionarioDao funcionarioDao = new FuncionarioDao();
				funcionario = funcionarioDao.buscar(codigo);

			} else {
				
				funcionario = new Funcionario();

			}
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}
	
	

	public void novo() {
		funcionario = new Funcionario();	
	}
	
	public void editar() {

		try {
			FuncionarioDao clienteDao = new FuncionarioDao();
			clienteDao.editar(funcionario);
			novo();
			Messages.addGlobalInfo("Atualizado");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Atualizar");
			erro.printStackTrace();
		}

	}
	
	
	public void excluir(ActionEvent evento) {
		try {
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSel");
			
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarioDao.excluir(funcionario);
			novo();
			Messages.addGlobalInfo("Registro Excluido");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Excluir");
			erro.printStackTrace();
		}
	}
	
	
	public void salvar() {
		try {
			FuncionarioDao clienteDao = new FuncionarioDao();
			clienteDao.salvar(funcionario);
			novo();
			Messages.addGlobalInfo("Funcionario Cadastrado");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}
		
	}

}