package model;

public class Candidato {
	private int id;
	private int numero;
	private String nome;
	private int votos;

	public Candidato() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Número:" + numero + ", nome:" + nome + ", votos:" + votos;
	}
}
