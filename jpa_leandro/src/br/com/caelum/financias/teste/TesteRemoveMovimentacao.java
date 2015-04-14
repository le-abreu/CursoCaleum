package br.com.caelum.financias.teste;


import javax.persistence.EntityManager;

import br.com.caelum.financias.dao.MovimentacaoDao;
import br.com.caelum.financias.infra.JPAUtil;

public class TesteRemoveMovimentacao {

	/**
	 * Teste remove movimentação da base
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();

		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(entityManager);
		movimentacaoDao.remove(movimentacaoDao.busca(1));
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
