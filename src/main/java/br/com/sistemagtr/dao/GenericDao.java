package br.com.sistemagtr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import java.lang.reflect.ParameterizedType;

import br.com.sistemagtr.util.HibernateUtil;

public class GenericDao<Entidade> {
	
	private Class<Entidade> classe;
	{

	}

	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

	}

	public void salvar(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();// capturar uma sessao aberta com o banco

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);// qual o domain salvara a informa��o
			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	
	

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();// capturar uma sessao aberta com o banco

		try {

			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(long codigo) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();// capturar uma sessao aberta com o banco

		try {

			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();// capturar uma sessao aberta com o banco

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);// qual o domain excluir a informa��o
			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();// capturar uma sessao aberta com o banco

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);// qual o domain alterar a informa��o
			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void merge(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();// capturar uma sessao aberta com o banco

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);// qual o domain salvara a informa��o
			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	
}