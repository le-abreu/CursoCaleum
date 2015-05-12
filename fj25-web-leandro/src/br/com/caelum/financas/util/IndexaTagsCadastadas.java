package br.com.caelum.financas.util;

import javax.persistence.EntityManager;

import org.hibernate.search.MassIndexer;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

import br.com.caelum.financas.infra.JPAUtil;

public class IndexaTagsCadastadas {

	public static void main(String[] args){
		EntityManager entityManager = new JPAUtil().getEntityManager();
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		try {
			MassIndexer createIndexer = fullTextEntityManager.createIndexer();
			createIndexer.startAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
