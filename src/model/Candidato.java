package model;

public class Candidato {
	private int numero;
	private String nome;
	private int votos;
	
	public Candidato() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Candidato [numero=" + numero + ", nome=" + nome + ", votos=" + votos + "]";
	}
	
	
}
