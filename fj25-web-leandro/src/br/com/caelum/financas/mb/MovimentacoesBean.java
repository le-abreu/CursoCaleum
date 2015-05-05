package br.com.caelum.financas.mb;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.dao.TagDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.Tag;
import br.com.caelum.financas.modelo.TipoMovimentacao;

/**
 * Movimentação Bean controla o jsf da tela e movimentacoes.xhtml
 * @author leandro
 *
 */
@ManagedBean
public class MovimentacoesBean {

	/*** ATRIBUTOS ***/ 
	private List<Movimentacao> movimentacoes;
	private Movimentacao movimentacao = new Movimentacao();
	private Integer contaId;
	private String tags;
	
	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;

	/**
	 * Seta o entityManager
	 * @param em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * grava conta, controle com o funcionalidade de gravar da tela de movimentações
	 */
	public void grava() {
		System.out.println("Fazendo a gravacao da movimentacao");
		
		new MovimentacoesBean.ExecutorTransacao(em) {
			@Override
			protected void execute() {
				Conta conta = contaDao.busca(contaId);
				movimentacao.setConta(conta);
				gravaEAssociaAsTags(em);
				dao.adiciona(movimentacao);
				movimentacoes = dao.lista();
			}
			
		}.run(true);
		
		limpaFormularioDoJSF();
	}
	
	/**
	 * Remove a conta com a funcionalidade mapeada dentro do jsf
	 */
	public void remove() {
		System.out.println("Removendo a movimentacao");
		new MovimentacoesBean.ExecutorTransacao(em) {
			@Override
			protected void execute() {
				movimentacao = dao.busca(movimentacao.getId());
				dao.remove(movimentacao);
			}
		}.run(true);
		limpaFormularioDoJSF();
	}

	/**
	 * Movimentações listada na tela
	 * @return
	 */
	public List<Movimentacao> getMovimentacoes() {
		System.out.println("Listando as movimentacoes");
		
		new MovimentacoesBean.ExecutorTransacao(em) {
			@Override
			protected void execute() {
				movimentacoes = dao.lista();
			}
		}.run(false);
		return movimentacoes;
	}
	
	/**
	 * Exibe a tag
	 * @return
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * Seta tag
	 * @param tags
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	/**
	 * Exibe Movimentação, caso seja null a data seta uma nova data na movimenatação
	 * @return
	 */
	public Movimentacao getMovimentacao() {
		if(movimentacao.getData()==null) {
			movimentacao.setData(Calendar.getInstance());
		}
		return movimentacao;
	}
	
	/**
	 * Seta Movimentação
	 * @param movimentacao
	 */
	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	/**
	 * Exibe o Id da conta
	 * @return
	 */
	public Integer getContaId() {
		return contaId;
	}

	/**
	 * Seta o id da conta
	 * @param contaId
	 */
	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	/**
	 * Esse método apenas limpa o formulário da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulário vazio.
	 */
	private void limpaFormularioDoJSF() {
//		this.contaId = null;
		this.contaId = new Integer(0);
		this.movimentacao = new Movimentacao();
		this.tags = null;
	}

	/**
	 * Exibe os tipo de movimentação
	 * @return
	 */
	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}
	
	/**
	 * Grava e Associa as tags
	 * @param em
	 */
	private void gravaEAssociaAsTags(EntityManager em) {
		String[] nomesDasTags = this.tags.split(" ");
		TagDAO tagDAO = new TagDAO(em);
		
		for (String nome : nomesDasTags) {
			Tag tag = tagDAO.adicionaOuBuscaTagComNome(nome);
			movimentacao.getTags().add(tag);
		}
	}
	
	/**
	 * Executor Transação Sub Classe responsável por gerenciar toda transação
	 * @author leandro
	 *
	 */
	private abstract class ExecutorTransacao {
		
		/*** ATRIBUTOS ***/
		protected ContaDAO contaDao;
		protected MovimentacaoDAO dao;
		protected EntityManager em;
		
		public ExecutorTransacao(EntityManager em) {
			this.em = em;
		}
		
		protected abstract void execute();
		
		public void run(boolean executarCommit) {
			contaDao = new ContaDAO(em);
			dao = new MovimentacaoDAO(em);
			execute();
		}
	}

}
