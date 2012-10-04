package br.com.caelum.vetores.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Vetor;

public class TesteAdicionaNoFim {

	public static void main(String[] args) {
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		
		aluno1.setNome("Rafael");
		aluno2.setNome("Leandro");
		
		Vetor alunos = new Vetor();
		
		alunos.adiciona(aluno1);
		alunos.adiciona(aluno2);
		
		System.out.println(alunos);
	}
}
