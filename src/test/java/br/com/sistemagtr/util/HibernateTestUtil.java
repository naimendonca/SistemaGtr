package br.com.sistemagtr.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateTestUtil {
	@Test
	public void conectar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
