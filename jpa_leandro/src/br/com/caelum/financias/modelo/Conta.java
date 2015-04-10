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

	private String titula;

	private String numero;

	private String agencia;

	private String banco;


	/*Get's and Set's*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}