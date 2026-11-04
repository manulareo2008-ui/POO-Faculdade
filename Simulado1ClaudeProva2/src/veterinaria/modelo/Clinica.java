package veterinaria.modelo;

import java.util.ArrayList;
import java.util.List;

import veterinaria.excecao.CampoVazioException;

public class Clinica {
	private List<Tutor> tutores;

	public Clinica() {
		tutores = new ArrayList<Tutor>();
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void addTutor(Tutor t) throws CampoVazioException {
		if (t == null) {
			throw new CampoVazioException("Tutor");
		}

		for (Tutor tutor : tutores) {
			if (tutor == t) { // mesmo objeto: o tutor já está na clínica
				throw new IllegalArgumentException("Tutor já cadastrado");
			}
		}

		tutores.add(t);
	}

	public boolean removerTutor(Tutor t) {
		for (Tutor tutor : tutores) {
			if (tutor == t) {
				tutores.remove(tutor);
				return true;
			}
		}

		return false;
	}

	// Clínica sem tutores fatura R$ 0,00: não é um erro.
	public double faturamentoPrevisto() {
		double total = 0;
		for (Tutor t : tutores) {
			total += t.valorTotalTutor();
		}

		return total;
	}

	// Sem tutores não existe "tutor que mais paga": lança exceção (decisão de projeto).
	public Tutor tutorDeMaiorValor() {
		if (tutores.isEmpty()) {
			throw new IllegalArgumentException("Não há tutores cadastrados");
		}

		Tutor maior = tutores.get(0);
		for (Tutor t : tutores) {
			if (t.valorTotalTutor() > maior.valorTotalTutor()) {
				maior = t;
			}
		}

		return maior;
	}

	public int totalAnimaisCadastrados() {
		int total = 0;
		for (Tutor t : tutores) {
			total += t.getAnimais().size();
		}

		return total;
	}

	public String listarAnimais10Anos() {
		String lista = "";
		for (Tutor t : tutores) {
			for (Animal a : t.getAnimais()) { // os animais DESTE tutor
				if (a.getIdade() > 10) {
					lista += a.imprimirDados() + "\n";
				}
			}
		}

		return lista;
	}

	public String imprimirDadosClinica() {
		String dados = "Informações da clínica:\n";
		for (Tutor t : tutores) {
			dados += t.imprimirDadosTutor();
		}

		return dados;
	}
}
