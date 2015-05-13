package br.com.caelum.financas.infra;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GerarSchemaBanco {

	//GERANDO o schema
	public static void main(String[] args) {
		String dtSource = "controlefinancas"; 
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(dtSource);
		Ejb3Configuration ejb3Configuration = new Ejb3Configuration();
		ejb3Configuration.configure(dtSource, entityManagerFactory.getProperties());
		new SchemaExport(ejb3Configuration.getHibernateConfiguration()).create(true, false);
	}
}
