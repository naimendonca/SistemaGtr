package br.com.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemagtr.dao.FornecedorDao;
import br.com.sistemagtr.domain.Fornecedor;



public class FornecedorDaoTest {
	@Ignore
	@Test
	public void Salvar() {

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Faber Castel");
		fornecedor.setCnpj("1234567891234");
		fornecedor.setEndereco("Rua Jose Almeida");
		fornecedor.setTelefone("1430256548");
	
		
		FornecedorDao fornecedorDao = new FornecedorDao();
		fornecedorDao.salvar(fornecedor);
		System.out.println("\nCadastro efetivado! ");

	}

	@Ignore
	@Test
	public void listar() {
		FornecedorDao fornecedorDao = new FornecedorDao();
		List<Fornecedor> resultado = fornecedorDao.listar();
		System.out.println("\nTotal de Registros:\n " + resultado.size());
		for (Fornecedor fornecedor : resultado) {
			System.out.println("Nome: "+fornecedor.getNome());
			System.out.println("Telefone: "+fornecedor.getTelefone());

		}
	}

	@Ignore
	@Test
	public void buscar() {

		Long codigo = 1L;
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.buscar(codigo);

		if (fornecedor == null) {
			System.out.println("\nNenhum registro encontrado!");

		} else {
			System.out.println("\nRegistro encontrado!\n");
			System.out.println("Fornecedor: "+fornecedor.getNome());
			System.out.println("CNPJ: "+fornecedor.getCnpj());

		}
	}

	@Ignore
	@Test
	public void excluir() {

		Long codigo = 1L;
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.buscar(codigo);

		if (fornecedor == null) {
			System.out.println("Nenhum registro encontrado!");

		} else {
			fornecedorDao.excluir(fornecedor);
			System.out.println("\nO cadastro do fornecedor " + fornecedor.getNome() + " código = " + fornecedor.getCodigo() + " foi excluido! \n");
			
		}

	}

	@Ignore
	@Test
	public void editar() {

		Long codigo = 2L;
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.buscar(codigo);

		if (fornecedor == null) {
			System.out.println("/nNenhum registro encontrado!");

		} else {
			fornecedor.setNome("BIC");
			fornecedorDao.editar(fornecedor);
			System.out.println("\nRegistro atualizado com sucesso!");

		}
	}


}
