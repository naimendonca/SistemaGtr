package br.com.sistemagtr.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.apache.shiro.crypto.hash.SimpleHash;

import br.com.sistemagtr.domain.Funcionario;
import br.com.sistemagtr.util.HibernateUtil;

public class FuncionarioDao extends GenericDao<Funcionario>{
	public Funcionario autenticar(String cpf, String senha){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
				
				
		try{
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.createAlias("pessoa", "p");
			consulta.add(Restrictions.eq("p.cpf", cpf));
			
			SimpleHash hash = new SimpleHash("md5", senha);
			consulta.add(Restrictions.eq("senha", hash.toHex()));
			Funcionario resultado = (Funcionario) consulta.uniqueResult(); 
			
			return resultado;
			
		}catch(RuntimeException erro){
			throw erro;
		}finally{
			sessao.close();
		}
		
	}
}
