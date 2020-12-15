package br.com.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemagtr.dao.ClienteDao;
import br.com.sistemagtr.domain.Cliente;

public class ClienteDaoTest {
	@Ignore
	@Test
	public void Salvar() {

		Cliente cliente = new Cliente();
		cliente.setNome("Kaio");
		cliente.setCpf("1234567890");
		cliente.setRg("508003545");
		cliente.setEndereco("Rua Domingod");
		cliente.setTelefone("1499854217");
	
		
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.salvar(cliente);
		System.out.println("\nCadastro efetivado! ");

	}

	@Ignore
	@Test
	public void listar() {
		ClienteDao clienteDao = new ClienteDao();
		List<Cliente> resultado = clienteDao.listar();
		System.out.println("\nTotal de Registros:\n " + resultado.size());
		for (Cliente cliente : resultado) {
			System.out.println("Nome: "+cliente.getNome());
			System.out.println("Telefone: "+cliente.getTelefone());

		}
	}

	@Ignore
	@Test
	public void buscar() {

		Long codigo = 1L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscar(codigo);

		if (cliente == null) {
			System.out.println("\nNenhum registro encontrado!");

		} else {
			System.out.println("\nRegistro encontrado!\n");
			System.out.println("Cliente: "+cliente.getNome());
			System.out.println("CPF: "+cliente.getCpf());

		}
	}

	@Ignore
	@Test
	public void excluir() {

		Long codigo = 1L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado!");

		} else {
			clienteDao.excluir(cliente);
			System.out.println("\nO cadastro do cliente " + cliente.getNome() + " código = " + cliente.getCodigo() + " foi excluido! \n");
			
		}

	}

	@Ignore
	@Test
	public void editar() {

		Long codigo = 2L;
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.buscar(codigo);

		if (cliente == null) {
			System.out.println("/nNenhum registro encontrado!");

		} else {
			cliente.setNome("Naine A Mendonca");
			clienteDao.editar(cliente);
			System.out.println("\nRegistro atualizado com sucesso!");

		}
	}

}
