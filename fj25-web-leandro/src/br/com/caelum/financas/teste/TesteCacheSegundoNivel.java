package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TesteCacheSegundoNivel {

	public static void main(String[] args) {
		JPAUtil jpaUtil = new JPAUtil();
		EntityManager entityManagerPrimeira = jpaUtil.getEntityManager();
		entityManagerPrimeira.getTransaction().begin();
		Conta contaPrimeira = entityManagerPrimeira.find(Conta.class, 1);
		jpaUtil.tirarDoCache(Conta.class, 1);
		entityManagerPrimeira.getTransaction().commit();
		entityManagerPrimeira.close();
		
		EntityManager entityManagerSegunda = jpaUtil.getEntityManager();
		Conta contaSegunda = entityManagerSegunda.find(Conta.class, 1);
		entityManagerSegunda.close();

		System.out.println("Titular da pimera conta "+contaPrimeira.getTitular());
		System.out.println("Titular da segunda conta "+contaSegunda.getTitular());
		
	}

}
