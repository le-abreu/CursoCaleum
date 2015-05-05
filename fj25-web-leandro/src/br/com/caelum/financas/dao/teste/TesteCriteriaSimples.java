package br.com.caelum.financas.dao.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TesteCriteriaSimples {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(entityManager);
		List<Movimentacao> lista = movimentacaoDAO.todasComCriteria();
		System.out.println(lista);
	}

}
