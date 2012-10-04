package br.com.caelum.vetores.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Vetor;

public class TestePegaPorPosicao {

	public static void main(String[] args) {
		
		Aluno aluno1 =  new Aluno();
		Aluno aluno2 =  new Aluno();
		
		aluno1.setNome("Leandro");
		aluno2.setNome("Rafael");
		
		Vetor vetor = new Vetor();
		vetor.adiciona(aluno1);
		vetor.adiciona(aluno2);
		
		System.out.println(vetor);
		
		Aluno alunoRecuperado1 = (Aluno) vetor.pega(1);
		Aluno alunoRecuperado2 = (Aluno) vetor.pega(0);
		
		System.out.println(alunoRecuperado1);
		System.out.println(alunoRecuperado2);
	}
}
