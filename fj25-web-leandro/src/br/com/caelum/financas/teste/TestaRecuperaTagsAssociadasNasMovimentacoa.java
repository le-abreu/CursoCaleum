package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.Tag;

public class TestaRecuperaTagsAssociadasNasMovimentacoa {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		Movimentacao movimentacao = entityManager.find(Movimentacao.class, 3);
		for (Tag tags : movimentacao.getTags()) {
			System.out.println(tags);
		}
		
		entityManager.close();
	}
}
