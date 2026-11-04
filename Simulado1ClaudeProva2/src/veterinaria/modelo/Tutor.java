package veterinaria.modelo;

import java.util.ArrayList;
import java.util.List;

import veterinaria.excecao.CampoVazioException;

public class Tutor {
	private String nome;
	private String telefone;
	private List<Animal> animais;

	public Tutor(String nome, String telefone) {
		setNome(nome);
		setTelefone(telefone);
		animais = new ArrayList<Animal>();
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setNome(String nome) throws CampoVazioException {
		if (nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}

		this.nome = nome;
	}

	public void setTelefone(String telefone) throws CampoVazioException {
		if (telefone == null || telefone.isBlank()) {
			throw new CampoVazioException("Telefone");
		}
		if (telefone.length() < 8) {
			throw new IllegalArgumentException("Telefone deve ter, pelo menos, 8 caracteres");
		}

		this.telefone = telefone;
	}

	public void addAnimal(Animal a) throws CampoVazioException {
		if (a == null) {
			throw new CampoVazioException("Animal");
		}
		if (animais.size() >= 4) {
			throw new IllegalArgumentException("Tutor já possui o máximo de 4 animais");
		}

		for (Animal animal : animais) {
			if (animal.getNrRegistro() == a.getNrRegistro()) {
				throw new IllegalArgumentException("Animal já cadastrado");
			}
		}

		animais.add(a);
	}

	public boolean removerAnimal(Animal a) {
		if (a == null) {
			return false;
		}

		for (Animal animal : animais) {
			if (animal.getNrRegistro() == a.getNrRegistro()) {
				animais.remove(animal);
				return true; // sai logo após remover: não há próxima volta do for-each
			}
		}

		return false;
	}

	public double valorTotalTutor() {
		double total = 0;
		for (Animal a : animais) {
			total += a.valorFinal();
		}

		return total;
	}

	public String imprimirDadosTutor() {
		String dados = "Nome: " + getNome() + " - Telefone: " + getTelefone() + " - Total animais: " + animais.size()
				+ "\nLista de animais do tutor e seus respectivos dados:\n";
		for (Animal a : animais) {
			dados += a.imprimirDados() + "\n";
		}

		return dados;
	}
}
