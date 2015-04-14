package br.com.caelum.financias.teste;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.caelum.financias.dao.ContaDao;
import br.com.caelum.financias.dao.MovimentacaoDao;
import br.com.caelum.financias.infra.JPAUtil;
import br.com.caelum.financias.modelo.Conta;
import br.com.caelum.financias.modelo.Movimentacao;
import br.com.caelum.financias.modelo.TipoMovimentacao;

public class TestaSalvaMovimentacaoComConta {

	/**
	 * Main teste para salvar movimentação relacionada com a conta
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setAgencia("123");
		conta.setBanco("Bradesco");
		conta.setNumero("123123");
		conta.setTitular("Teste de Conta B");
		
		ContaDao contaDao= new ContaDao(entityManager);
		contaDao.adiciona(conta);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(new Date());
		movimentacao.setDescricao("conta de luz - abril/2010");
		movimentacao.setValor(new BigDecimal("100"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(entityManager);
		movimentacaoDao.adiciona(movimentacao);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
