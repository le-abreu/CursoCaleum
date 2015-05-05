package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;


/**
 * ContasBean controller com a camada view para funcionalidades com o contas.xhtml
 * @author leandro
 *
 */
@ViewScoped
@ManagedBean
public class ContasBean {
	
	/*** ATRIBUTOS ***/
	private Conta conta = new Conta();
	private List<Conta> contas;
	
// não funciona com a vcoped view
//	@ManagedProperty(name="em",value="#{requestScope.em}")
//	private EntityManager em;

	
	/**
	 * Metodo controller de gravar
	 */
	public void grava() {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		ContaDAO contaDAO = new ContaDAO(entityManager);
		if(conta.getId() == null){
			contaDAO.adiciona(conta);
		}else{
			contaDAO.altera(conta);
		}
		contas = contaDAO.lista();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		limpaFormularioDoJSF();
	}

	/**
	 * Metodo remove contas controller 
	 */
	public void remove() {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		ContaDAO contaDAO = new ContaDAO(entityManager);
		contaDAO.remove(contaDAO.busca(conta.getId()));
		contas = contaDAO.lista();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		limpaFormularioDoJSF();
	}


	/**
	 * exibe uma lista de contas
	 * @return
	 */
	public List<Conta> getContas() {
		if(contas == null){
			EntityManager entityManager = new JPAUtil().getEntityManager();
			ContaDAO contaDAO = new ContaDAO(entityManager);
			contas = contaDAO.lista();
			entityManager.close();
		}
		return contas;
	}

	/**
	 * Esse método apenas limpa o formulário da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulário vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.conta = new Conta();
	}

	
	//GET's and SET's
	/**
	 * Metodo exibe a Conta
	 * @return
	 */
	public Conta getConta() {
		return conta;
	}
	
	/**
	 * Seta conta
	 * @param conta
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
