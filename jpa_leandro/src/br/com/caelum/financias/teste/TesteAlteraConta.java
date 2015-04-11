package br.com.caelum.financias.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financias.dao.ContaDao;
import br.com.caelum.financias.infra.JPAUtil;
import br.com.caelum.financias.modelo.Conta;

public class TesteAlteraConta {

	/**
	 * Main teste de alterar conta em base
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		ContaDao contaDao = new ContaDao(entityManager);
		
		entityManager.getTransaction().begin();
		Conta conta = contaDao.busca(4);
		conta.setTitular("Teste de alterar");
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
