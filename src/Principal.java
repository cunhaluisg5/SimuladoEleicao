import java.util.List;
import java.util.Scanner;

import model.Candidato;
import model.Urna;

public class Principal {

	static List<Candidato> candidatos;
	static Urna urna = new Urna();
	static Scanner leitor = new Scanner(System.in);
	static int opcao = 0;

	public static void main(String[] args) {
		menu();
		opcao = leitor.nextInt();

		while (opcao != 4) {
			switch (opcao) {
			case 1:
				cadastrarCandidato();
				break;
			case 2:
				votar();
				break;
			case 3:
				verApuracao();
				break;
			case 4:
				System.out.println("Programa finalizado!");
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida!\n");
				break;
			}
			menu();
			opcao = leitor.nextInt();
		}

	}

	public static void menu() {
		System.out.println("Escolha uma opção abaixo:\n");
		System.out.println("1) Cadastrar candidato\n");
		System.out.println("2) Votar\n");
		System.out.println("3) Ver apuração\n");
		System.out.println("4) Sair\n");
	}

	public static void cadastrarCandidato() {
		Candidato candidato = new Candidato();
		
		System.out.println("Informe o número do candidato:\n");
		int numero = leitor.nextInt();

		if (numeroValido(numero)) {
			candidato.setNumero(numero);
			
			candidato.setId(urna.idCandidato++);

			System.out.println("Informe o nome do candidato:\n");
			candidato.setNome(leitor.next());

			urna.cadastrarCandidato(candidato);

			System.out.println("Candidato cadastrado!\n");

			candidatos = urna.listarCandidatos();
		} else
			System.out.println("Já existe candidato cadastrado com esse número!\n");
	}

	public static void menuCandidatos() {
		candidatos = urna.listarCandidatos();

		System.out.println("Escolha um candidato abaixo:\n");

		for (int i = 0; i < candidatos.size(); i++) {
			System.out.println(i + 1 + ") " + candidatos.get(i).getNome() + "\n");
		}
	}

	public static void votar() {
		candidatos = urna.listarCandidatos();

		if (candidatos.size() > 0) {
			menuCandidatos();

			try {
				Candidato candidato = urna.buscarCandidato(leitor.nextInt() - 1);
				candidato.setVotos(candidato.getVotos() + 1);

				urna.alterarCandidato(candidato);

				System.out.println("Voto efetuado com sucesso!\n");
			} catch (NullPointerException e) {
				System.out.println("Opção inválida!\n");
			}
		} else {
			System.out.println("Não existem candidatos cadastrados!\n");
		}
	}

	public static void verApuracao() {
		candidatos = urna.listarCandidatos();

		if (candidatos.size() > 0) {
			System.out.println("Resultado da apuração:\n");

			for (Candidato c : candidatos) {
				System.out.println(c.getId() + 1 + ") " + c.getNome() + ": " + c.getVotos() + " voto"
						+ (c.getVotos() > 1 ? "s" : "") + "\n");
			}
		} else {
			System.out.println("Não existem candidatos cadastrados!\n");
		}
	}

	public static boolean numeroValido(int numero) {
		candidatos = urna.listarCandidatos();

		boolean valido = true;

		for (Candidato c : candidatos) {
			if (c.getNumero() == numero) {
				valido = false;
				break;
			}
		}
		return valido;
	}
}
