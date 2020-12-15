package br.com.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemagtr.dao.ClienteDao;
import br.com.sistemagtr.dao.FuncionarioDao;
import br.com.sistemagtr.dao.ProdutoDao;
import br.com.sistemagtr.dao.VendaDao;
import br.com.sistemagtr.domain.Cliente;
import br.com.sistemagtr.domain.Funcionario;
import br.com.sistemagtr.domain.Produto;
import br.com.sistemagtr.domain.Venda;

public class VendaDaoTest {
	@Ignore
	@Test
	public void salvar() {		
		
		
		Long codigo = 1L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscar(codigo);
		
		Long codigom = 1L;
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.buscar(codigom);
		
		Long codigof = 1L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(codigof);
					
	
		Venda venda = new Venda();
		venda.setQuantidade(new Short("2"));


		venda.setCliente(cliente);
		venda.setProduto(produto);
		venda.setFuncionario(funcionario);

		
		
		VendaDao vendaDao = new VendaDao();
		vendaDao.salvar(venda);
		System.out.println("\nVenda registrada! ");
	}
	
	@Ignore
	@Test
	public void listar() {
		VendaDao vendaDao = new VendaDao();
		List<Venda> resultado = vendaDao.listar();
		System.out.println("\nTotal de Registro = " + resultado.size());
		
		for(Venda venda:resultado) {
			System.out.println("Quantidade: " + venda.getQuantidade());
			System.out.println("Produto: " + venda.getProduto());
			System.out.println("Cliente: " + venda.getCliente());
			
		}
	}
	
	@Ignore
	@Test
	public void buscar() {
		
		Long codigo = 1L;
		VendaDao vendaDao = new VendaDao();
		Venda venda = vendaDao.buscar(codigo);
		
		if (venda == null) {
			System.out.println("Nenhum registro encontrado! ");
		}else {
			System.out.println("\nTotal de registro(s) encontrado(s): " + venda.getCodigo());
			
		}
		
	}
	
	@Ignore
	@Test
	public void excluir() {
		
		Long codigo = 2L;
		VendaDao vendaDao = new VendaDao();
		Venda venda = vendaDao.buscar(codigo);
		
		if (venda == null) {
			System.out.println("Nenhum registro encontrado!");
		}else {
			vendaDao.excluir(venda);
			System.out.println("\nO registro " +  " código = " + venda.getCodigo() + " foi excluído! " );
			
		}
	}
	
	@Ignore
	@Test
	public void editar() {
		Long codigo = 3L;
		VendaDao vendaDao = new VendaDao();
		Venda venda = vendaDao.buscar(codigo);
		
		if(venda == null) {
			System.out.println("Nenhum registro encontrado!");
		}else {
			ClienteDao clienteDao = new ClienteDao();
			Cliente cliente = clienteDao.buscar(1);
	        
	        venda.setQuantidade(new Short("3"));
	        vendaDao.editar(venda);
			
			System.out.println("Registro atualizado!");
			System.out.println("Total: " + venda.getQuantidade());
						
		}
			
	}
	
}
