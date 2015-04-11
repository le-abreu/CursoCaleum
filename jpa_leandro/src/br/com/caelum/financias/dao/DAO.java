package br.com.caelum.financias.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * Classe DAO Generica, para ser compartilhado
 * @author leandro
 *
 * @param <T>
 */
public class DAO<T> {

	//Atributos
	private final EntityManager entityManager;
	private final Class<T> classe;
	
	/**
	 * Contrutor
	 * @param entityManager
	 * @param classe
	 */
	public DAO(EntityManager entityManager, Class<T> classe) {
		this.entityManager = entityManager;
		this.classe = classe;
	}
	
	/**
	 * busca elemento na base
	 * @param id
	 * @return
	 */
	public T busca(Integer id){
		return this.entityManager.getReference(classe, id);
	}

	/**
	 * busca uma lista tota na base
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> lista(){
		return this.entityManager.createQuery("select e from "+ this.classe.getName() + " e").getResultList();
	}
	
	/**
	 * Adiciona elemento na base
	 * @param t
	 */
	public void adiciona(T t){
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(t);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * Remove elemento na base
	 * @param t
	 */
	public void remove(T t){
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(t);
		this.entityManager.getTransaction().commit();
	}
}
