package br.com.caelum.financias.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 
 * @author leandro
 * Classe Conta 
 * Guarda os dados de uma conta
 */
@Entity
public class Conta {


	/*Atributos*/
	
	@Id
	@GeneratedValue
	private Integer id;

	private String titular;

	private String numero;

	private String agencia;

	private String banco;


	/*Get's and Set's*/
	
	/**
	 * Exibe o id da conta
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id da conta
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Exibe o titular da conta
	 * @return
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * Seta o titular da conta
	 * @param titular
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}

	/**
	 * Exibe o numero da conta
	 * @return
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Seta o numero da conta
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Exibe a agencia da conta
	 * @return
	 */
	public String getAgencia() {
		return agencia;
	}

	/**
	 * Seta a agencia da conta
	 * @param agencia
	 */
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	/**
	 * Exibe o banco da conta
	 * @return
	 */
	public String getBanco() {
		return banco;
	}

	/**
	 * Seta o banco da conta
	 * @param banco
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}

}