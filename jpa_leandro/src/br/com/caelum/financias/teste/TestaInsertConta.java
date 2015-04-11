package br.com.caelum.financias.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financias.dao.ContaDao;
import br.com.caelum.financias.infra.JPAUtil;
import br.com.caelum.financias.modelo.Conta;

public class TestaInsertConta {

	/**
	 * Main teste de inserir na base de dados uma conta
	 * @param args
	 */
	public static void main(String[] args) {

		long inicio = System.currentTimeMillis();
		
		Conta conta = new Conta();
		conta.setTitular("Leandro Abreu Ferreira");
		conta.setBanco("Itaú");
		conta.setAgencia("7071");
		conta.setNumero("12340-1");

		EntityManager entityManager = JPAUtil.getEntityManager();
		new ContaDao(entityManager).adiciona(conta);
		entityManager.close();
		
		System.out.println("Conta gerada com sucesso");

		long fim = System.currentTimeMillis();
		System.out.println("Executado em: "+(fim-inicio));
	}

}
