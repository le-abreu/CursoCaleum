package br.com.caelum.financias.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financias.modelo.Conta;

/**
 * ContaDao responsavel pelo acesso a base 
 * @author leandro
 *
 */
public class ContaDao {

	// Atributo
	private DAO<Conta> daoConta;

	/**
	 * Contrutor recebe dependencia de EntityManager
	 * @param entityManager
	 */
	public ContaDao(EntityManager entityManager){
		daoConta = new DAO<Conta>(entityManager, Conta.class);
	}
	
	/**
	 * Busca por Id a conta
	 * @param id
	 * @return
	 */
	public Conta busca(Integer id) {
		return daoConta.busca(id);
	}

	/**
	 * Lista todas as contas da base
	 * @return
	 */
	public List<Conta> lista() {
		return daoConta.lista();
	}

	/**
	 * Adiciona conta na base
	 * @param t
	 */
	public void adiciona(Conta t) {
		daoConta.adiciona(t);
	}

	/**
	 * Remove Conta da base
	 * @param t
	 */
	public void remove(Conta t) {
		daoConta.remove(t);
	}
}