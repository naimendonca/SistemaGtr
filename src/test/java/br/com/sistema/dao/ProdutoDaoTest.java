package br.com.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemagtr.dao.FornecedorDao;
import br.com.sistemagtr.dao.ProdutoDao;
import br.com.sistemagtr.domain.Fornecedor;
import br.com.sistemagtr.domain.Produto;

public class ProdutoDaoTest {
	@Ignore
	@Test
	public void Salvar() {

	
		Long codigov = 1L;
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.buscar(codigov);
		
		Produto produto = new Produto();
		produto.setNome("Lápis de Cor");
		produto.setFornecedor(fornecedor);
		produto.setValor(12.5f);
	
		
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.salvar(produto);
		System.out.println("\nCadastro efetivado! ");

	}

	@Ignore
	@Test
	public void listar() {
		ProdutoDao produtoDao = new ProdutoDao();
		List<Produto> resultado = produtoDao.listar();
		System.out.println("\nTotal de Registros:\n " + resultado.size());
		for (Produto produto : resultado) {
			System.out.println("Nome: "+produto.getNome());
			System.out.println("Valor: "+produto.getValor());

		}
	}

	@Ignore
	@Test
	public void buscar() {

		Long codigo = 1L;
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.buscar(codigo);

		if (produto == null) {
			System.out.println("\nNenhum registro encontrado!");

		} else {
			System.out.println("\nRegistro encontrado!\n");
			System.out.println("Produto: "+produto.getNome());
			System.out.println("Valor: "+produto.getValor());

		}
	}

	@Ignore
	@Test
	public void excluir() {

		Long codigo = 1L;
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado!");

		} else {
			produtoDao.excluir(produto);
			System.out.println("\nO cadastro do produto " + produto.getNome() + " código = " + produto.getCodigo() + " foi excluido! \n");
			
		}

	}

	@Ignore
	@Test
	public void editar() {

		Long codigo = 2L;
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.buscar(codigo);

		if (produto == null) {
			System.out.println("/nNenhum registro encontrado!");

		} else {
			produto.setNome("Guilherme Nascimento");
			produtoDao.editar(produto);
			System.out.println("\nRegistro atualizado com sucesso!");

		}
	}
}
