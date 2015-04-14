package br.com.caelum.financias.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financias.modelo.Movimentacao;

/**
 * MovimentacaoDao cuida das operações na base de dados para {@link Movimentacao} 
 * @author leandro
 *
 */
public class MovimentacaoDao {

	// atributo Dao Generico
	private DAO<Movimentacao> dao;

	/**
	 * Contrustor que recebe um EntityManager e instancia o Dao 
	 * @param entityManager
	 */
	public MovimentacaoDao(EntityManager entityManager) {
		this.dao = new DAO<Movimentacao>(entityManager, Movimentacao.class);
	}

	/**
	 * Busca movimentação na base de dados
	 * @param id
	 * @return
	 */
	public Movimentacao busca(Integer id) {
		return dao.busca(id);
	}

	/**
	 * Lista todas as movimentações na base de dados
	 * @return
	 */
	public List<Movimentacao> lista() {
		return dao.lista();
	}

	/**
	 * Adiciona uma nova movimentação na base de dados
	 * @param t
	 */
	public void adiciona(Movimentacao t) {
		dao.adiciona(t);
	}

	/**
	 * Remove a movimentação da base de dados
	 * @param t
	 */
	public void remove(Movimentacao t) {
		dao.remove(t);
	}
	
}