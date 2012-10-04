package br.com.caelum.ed;

import java.util.Arrays;

public class Vetor {

	private Object[] lista = new Object[1];
	private int totalDeObjetos = 0;

	public void adiciona(Object object) {
		this.garanteEspaco();
		this.lista[this.totalDeObjetos++] = object;
	}

	public void adiciona(int posicao, Object object) {
		int garanteTotalDeObjetosOriginal = this.totalDeObjetos;
		if(posicao > this.lista.length){
			this.totalDeObjetos = posicao;
		}
		this.garanteEspaco();
		this.totalDeObjetos = garanteTotalDeObjetosOriginal;
		
		if(!this.posicaoValida(posicao)){
			throw new IllegalArgumentException("Posição Invalida: [" + posicao + "]");
		}

		for (int i = this.totalDeObjetos - 1; i >= posicao; i--) {
			this.lista[i + 1] = this.lista[i];
		}

		this.lista[posicao] = object;
		this.totalDeObjetos++;
	}

	public Object pega(int posicao) {
		if(!this.posicaoValida(posicao)){
			throw new IllegalArgumentException("Posição Invalida: [" + posicao + "]");
		}
		return this.lista[posicao];
	}

	public void remove(int posicao) {
		if(!this.posicaoValida(posicao))
			throw new IllegalArgumentException("Posição invalida: [" + posicao + "]");
			
		this.lista[posicao] = null;
		this.totalDeObjetos--;
		this.organizarPosicaoEsquerda();
	}

	public void remove(Object objeto) {
		for (Object o : this.lista) {
			if (o != null && objeto != null && o.equals(objeto))
				o = null;
		}
		this.organizarPosicaoEsquerda();
	}
	
	public boolean contem(Object object) {
		for (Object o : this.lista) {
			if (o != null && object != null && o.equals(object))
				return true;
		}
		return false;
	}

	public int tamanho() {
		return this.totalDeObjetos;
	}

	public void clear() {
		this.lista = new Vetor[this.totalDeObjetos];
	}
	
	@Override
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("{");
		for (Object object : this.lista) {
			if(object!=null)
				msg.append("\n\t" + object);
		}
		msg.append(" \n}");

		return msg.toString();
	}

	private void garanteEspaco() {
		if (this.lista.length <= this.totalDeObjetos) {
			Object[] novaLista = new Object[this.totalDeObjetos * 2];
			for (int index = 0; index < this.lista.length; index++) {
				novaLista[index] = this.lista[index];
			}
			this.lista = novaLista;
		}
	}

	public void organizarPosicaoEsquerda(){
		Object[] novaLista = new Object[this.lista.length];
		int index = 0 ;
		for (Object object : this.lista) {
			if(object!= null)
				novaLista[index++] = object;
		}
		this.lista = novaLista;
	}

	
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.lista.length;
	}
}
