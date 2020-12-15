package br.com.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemagtr.dao.ClienteDao;
import br.com.sistemagtr.dao.FuncionarioDao;
import br.com.sistemagtr.domain.Cliente;
import br.com.sistemagtr.domain.Funcionario;

public class FuncionarioDaoTest {
	@Ignore
	@Test
	public void Salvar() {

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Milena Giovana");
		funcionario.setCpf("1234567890");
		funcionario.setRg("506524558");
		funcionario.setEndereco("Rua João Aparecodo");
		funcionario.setTelefone("14997520431");
	
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.salvar(funcionario);
		System.out.println("\nCadastro efetivado! ");

	}

	@Ignore
	@Test
	public void listar() {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		List<Funcionario> resultado = funcionarioDao.listar();
		System.out.println("\nTotal de Registros:\n " + resultado.size());
		for (Funcionario funcionario : resultado) {
			System.out.println("Nome: "+funcionario.getNome());
			System.out.println("Telefone: "+funcionario.getTelefone());

		}
	}

	@Ignore
	@Test
	public void buscar() {

		Long codigo = 1L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(codigo);

		if (funcionario == null) {
			System.out.println("\nNenhum registro encontrado!");

		} else {
			System.out.println("\nRegistro encontrado!\n");
			System.out.println("Funcionario: "+funcionario.getNome());
			System.out.println("CPF: "+funcionario.getCpf());

		}
	}

	@Ignore
	@Test
	public void excluir() {

		Long codigo = 1L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado!");

		} else {
			funcionarioDao.excluir(funcionario);
			System.out.println("\nO cadastro do funcionario " + funcionario.getNome() + " código = " + funcionario.getCodigo() + " foi excluido! \n");
			
		}

	}

	@Ignore
	@Test
	public void editar() {

		Long codigo = 2L;
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = funcionarioDao.buscar(codigo);

		if (funcionario == null) {
			System.out.println("/nNenhum registro encontrado!");

		} else {
			funcionario.setNome("Guilherme Nascimento");
			funcionarioDao.editar(funcionario);
			System.out.println("\nRegistro atualizado com sucesso!");

		}
	}

}
