package br.com.caelum.vetores.teste;

import br.com.caelum.ed.Aluno;
import br.com.caelum.ed.Vetor;

public class TesteContemAluno {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();

		Vetor vetor = new Vetor();

		for (int i = 0; i < 30000000; i++) {
			Aluno aluno1 = new Aluno();
			aluno1.setNome("aluno"+1);
			vetor.adiciona(aluno1);
		}

		Aluno aluno3 = new Aluno();
		aluno3.setNome("aluno1");
		System.out.println(vetor.contem(aluno3));

		System.out.println(vetor.tamanho());
		System.out.println(vetor);

		aluno3.setNome("Ana");
		System.out.println(vetor.contem(aluno3));
		
		vetor.adiciona(aluno3);
		System.out.println(vetor.tamanho());
		
		long fim = System.currentTimeMillis();
		double tempo = (fim - inicio) / 1000.0;
		
		System.out.println("TEMPO: "+ tempo);
	}
}
