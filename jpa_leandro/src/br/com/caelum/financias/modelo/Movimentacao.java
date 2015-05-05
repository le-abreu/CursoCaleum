package br.com.caelum.financias.modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Classe Movimentacao controla as movimentações das contas
 * @author leandro
 *
 */
@Entity
public class Movimentacao {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String descricao;
	
	private Date data;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Conta conta;
	
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
	
	private BigDecimal valor;

	//Get's and Set's
	/**
	 * Exibe id da movimentação
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Seta o id da movimentação
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Exibe descrição da movimentação
	 * @return
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Seta a descricao da movimentação
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Exibe a data da movimentação
	 * @return
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Seta a data da movimentação
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
	/**
	 * Exibe a conta relacionada a movimentação
	 * @return
	 */
	public Conta getConta() {
		return conta;
	}

	/**
	 * Seta a conta relacioanda a movimentação
	 * @param conta
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	/**
	 * Exibe o valor da movimentação
	 * @return
	 */
	public BigDecimal getValor() {
		return valor;
	}
	
	/**
	 * Seta o valor da movimentação
	 * @param valor
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * Exibe o tipo de movimentação
	 * @return
	 */
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	/**
	 * Seta o tipo e movimentação
	 * @param tipoMovimentacao
	 */
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

}