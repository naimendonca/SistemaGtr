package br.com.sistemagtr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistemagtr.dao.ClienteDao;
import br.com.sistemagtr.domain.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class clienteBean implements Serializable{
	
	private Cliente cliente;
	private List<Cliente> clientes;
	private String acao;
	
	
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Cliente getCliente() {
		if(cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes(){
		return clientes;
	}
	
	public void  setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	@PostConstruct
	public void listar() {
		try {
			ClienteDao clienteDao = new ClienteDao();
			clientes = clienteDao.listar();
								
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
				ClienteDao clienteDao = new ClienteDao();
				cliente = clienteDao.buscar(codigo);

			} else {
				
				cliente = new Cliente();

			}
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}
	
	

	public void novo() {
		cliente = new Cliente();	
	}
	
	public void editar() {

		try {
			
			ClienteDao clienteDao = new ClienteDao();
			clienteDao.editar(cliente);
			novo();
			Messages.addGlobalInfo("Atualizado");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Atualizar");
			erro.printStackTrace();
		}

	}
	
	

	public void excluir(ActionEvent evento) {
		try {
		cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSel");
		
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.excluir(cliente);
		
		clientes = clienteDao.listar();
		Messages.addGlobalInfo("Registro Excluido");
		
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Excluir");
			erro.printStackTrace();
		}
	}
		
	
	
	public void salvar() {
		try {
			ClienteDao clienteDao = new ClienteDao();
			clienteDao.salvar(cliente);
			novo();
			Messages.addGlobalInfo("Cliente Cadastrado");
			
						
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}
		
	}

}