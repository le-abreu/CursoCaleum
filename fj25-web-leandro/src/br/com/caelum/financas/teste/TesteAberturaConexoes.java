package br.com.caelum.financas.teste;
import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;


public class TesteAberturaConexoes {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 50; i++) {
			EntityManager entityManager = new JPAUtil().getEntityManager();
			entityManager.getTransaction().begin();
			System.out.println("Criada entity manager numero "+i);
			
		}
		
		Thread.sleep(30*10000);
		
		//no  mysql executar oshow processlist; e ver oresultado
	}

}
