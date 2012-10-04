package br.com.caelum.ed;

public class Aluno {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + this.nome + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		if (!(obj instanceof Aluno))
			return false;
		
		Aluno other = (Aluno) obj;
		if((nome != null && other.nome == null)
				|| (nome == null && other.nome != null))
			return false;
		
		return (nome == null && other.nome == null)
				|| nome.equals(other.nome);
	}

}
