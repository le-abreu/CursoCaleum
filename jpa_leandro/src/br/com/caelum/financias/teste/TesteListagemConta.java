package br.com.caelum.financias.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financias.dao.ContaDao;
import br.com.caelum.financias.infra.JPAUtil;
import br.com.caelum.financias.modelo.Conta;

public class TesteListagemConta {
	
	/**
	 * Main teste de Lista da conta Dao
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		ContaDao contaDao = new ContaDao(entityManager);
		for (Conta conta : contaDao.lista()) {
			System.out.println(conta.getId() +" - "+  conta.getTitular()
					+" - "+  conta.getNumero());
		}
		
		entityManager.close();
	}
}
