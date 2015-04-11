package br.com.caelum.financias.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_financias");
	
	public static EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
}
