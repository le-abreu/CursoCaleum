package br.com.caelum.financias.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financias.dao.ContaDao;
import br.com.caelum.financias.infra.JPAUtil;
import br.com.caelum.financias.modelo.Conta;

public class TestePesquisaIdConta {

	/**
	 * Main teste de pesquisa
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ContaDao contaDao = new ContaDao(entityManager);
		Conta conta = contaDao.busca(1);
		System.out.println(conta.getBanco());
		entityManager.close();
	}
}
