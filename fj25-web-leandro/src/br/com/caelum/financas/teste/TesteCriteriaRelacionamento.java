package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;

public class TesteCriteriaRelacionamento {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(entityManager);
		BigDecimal soma = movimentacaoDAO.somaMovimentacoesDoTitular("Leandro");
		System.out.println(soma);
	}

}
