package br.com.caelum.financias.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaInsertConta {

	public static void main(String[] args) {

		long inicio = System.currentTimeMillis();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_financias");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitula("Leandro Abreu Ferreira");
		conta.setBanco("Itaú");
		conta.setAgencia("7071");
		conta.setNumero("12340-1");
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();

		long fim = System.currentTimeMillis();
		
		System.out.println("Conta gerada com sucesso");
		System.out.println("Executado em: "+(fim-inicio));
	}

}
