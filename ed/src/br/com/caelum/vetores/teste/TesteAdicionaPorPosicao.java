package br.com.caelum.vetores.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Vetor;

public class TesteAdicionaPorPosicao {

	public static void main(String[] args) {
		Aluno aluno1 =  new Aluno();
		Aluno aluno2 =  new Aluno();
		Aluno aluno3 =  new Aluno();
		
		aluno1.setNome("Rafael");
		aluno2.setNome("Leandro");
		aluno3.setNome("Ana");
		
		Vetor vetor = new Vetor();
		vetor.adiciona(aluno1);
		vetor.adiciona(4, aluno2);
		vetor.adiciona(9, aluno3);
		
		System.out.println(vetor);
		vetor.organizarPosicaoEsquerda();
		System.out.println(vetor);
	}
}
