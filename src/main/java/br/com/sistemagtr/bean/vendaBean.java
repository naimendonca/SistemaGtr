package br.com.sistemagtr.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.sistemagtr.dao.ClienteDao;
import br.com.sistemagtr.dao.FuncionarioDao;
import br.com.sistemagtr.dao.ProdutoDao;
import br.com.sistemagtr.dao.VendaDao;
import br.com.sistemagtr.domain.Cliente;
import br.com.sistemagtr.domain.Funcionario;
import br.com.sistemagtr.domain.Produto;
import br.com.sistemagtr.domain.Venda;
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class vendaBean implements Serializable{
	
	private Venda venda;
	private List<Venda> vendas;
	private String acao;
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Funcionario> funcionarios;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	@PostConstruct
	public void listar() {
		try {
			VendaDao vendaDao = new VendaDao();
			vendas = vendaDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao carregar as informações");
			erro.printStackTrace();
		}

	}

	public void enviar() {
		Messages.addGlobalInfo("Mensagem Enviada");
	}

	public void carregarCadastro() {

		try {

			acao = br.com.sistemagtr.util.jsfUtil.getParam("foracao");

			String valor = br.com.sistemagtr.util.jsfUtil.getParam("forCod");

			if (valor != null) {

				Long codigo = Long.parseLong(valor);
				VendaDao vendaDao = new VendaDao();
				venda = vendaDao.buscar(codigo);

			} else {

				venda = new Venda();

			}
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}

	public void novo() {
		try {

			venda = new Venda();
			ProdutoDao produtoDao = new ProdutoDao();
			produtos = produtoDao.listar();

			ClienteDao clienteDao = new ClienteDao();
			clientes = clienteDao.listar();
			
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			funcionarios = funcionarioDao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao carregar o cadastro");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		venda = (Venda) evento.getComponent().getAttributes().get("vendaSel");
		
		try {
			VendaDao vendaDao = new VendaDao();
			vendaDao.editar(venda);
			novo();
			Messages.addGlobalInfo("Venda Editada!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}

	}
	

	public void excluir(ActionEvent evento) {
		try {
		venda = (Venda) evento.getComponent().getAttributes().get("vendaSel");
		
		VendaDao vendaDao = new VendaDao();
		vendaDao.excluir(venda);
		
		vendas = vendaDao.listar();
		Messages.addGlobalInfo("Registro Excluido");
		
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Excluir");
			erro.printStackTrace();
		}
	}
		
	
	public void salvar() {
		try {
			VendaDao vendaDao = new VendaDao();
			vendaDao.salvar(venda);
			novo();
			Messages.addGlobalInfo("Venda realizada");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar");
			erro.printStackTrace();
		}

	}
	}
