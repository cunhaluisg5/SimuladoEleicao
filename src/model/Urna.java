package model;

import java.util.ArrayList;
import java.util.List;

public class Urna {
	private List<Candidato> candidatos;
	public static int idCandidato;

	public Urna() {
		candidatos = new ArrayList<>();
		idCandidato = 0;
	}
	
	public List<Candidato> listarCandidatos(){
			return candidatos;		
	}
	
	public Candidato buscarCandidato(int id) {
		Candidato candidato = null;
		for(Candidato c : candidatos) {
			if(c.getId() == id) {
				candidato = c;
			}
		}
		return candidato;
	}
	
	public void cadastrarCandidato(Candidato candidato) {
		candidatos.add(candidato);
	}
	
	public void alterarCandidato(Candidato candidato) {
		Candidato c = buscarCandidato(candidato.getId());
		if(c != null) {
			int posicao = candidatos.indexOf(c);
			candidatos.set(posicao, c);
		}
	}
}
