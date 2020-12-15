package br.com.sistemagtr.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	private static SessionFactory criarFabricaDeSessoes() {
		try {
			Configuration configuracao = new Configuration().configure();
			
			//ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			SessionFactory fabrica = configuracao.buildSessionFactory();
			//SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			
			return fabrica;
		} catch (Throwable ex) {
			System.err.println("A fÃ¡brica de sessÃµes nÃ£o pode ser criada." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
