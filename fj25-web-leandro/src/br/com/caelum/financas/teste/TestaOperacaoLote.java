package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaOperacaoLote {

	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		Conta conta = entityManager.find(Conta.class, 1);
		String nomeDoBancoASerAlterado = conta.getBanco();
	
		String jpql = "UPDATE Conta c SET c.banco = :novoBanco WHERE c.banco = :antigoBanco  ";
	
		Query query = entityManager.createQuery(jpql);
		query.setParameter("antigoBanco", nomeDoBancoASerAlterado);
		query.setParameter("novoBanco", "NOVO SSSSS");
		
		int qtdAlterada = query.executeUpdate();
	
		System.out.println("Quantdde econtas alterads "+ qtdAlterada);
		System.out.println("Nm antigo é "+nomeDoBancoASerAlterado);
		entityManager.detach(conta);
		Conta contaOther = entityManager.find(Conta.class, 1);
		System.out.println("Nm antigo é "+ contaOther.getBanco());

		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
