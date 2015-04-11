package br.com.caelum.financias.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financias.dao.ContaDao;
import br.com.caelum.financias.infra.JPAUtil;

public class TesteRemoveConta {
	
	/**
	 * Main teste para remover conta da base de dados
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		ContaDao contaDao = new ContaDao(entityManager);
		contaDao.remove(contaDao.busca(1));
		entityManager.close();
		
		System.out.println("Conta removida com sucesso");
	}

}
