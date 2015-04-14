package br.com.caelum.financias.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financias.dao.MovimentacaoDao;
import br.com.caelum.financias.infra.JPAUtil;
import br.com.caelum.financias.modelo.Movimentacao;

public class TestaBuscaMovimentacao {

	/**
	 * Testa a busca de movimentação por id
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(entityManager);
		
		Movimentacao movimentacao = movimentacaoDao.busca(1);
		System.out.println(movimentacao.getTipoMovimentacao());
		entityManager.close();
	}

}
