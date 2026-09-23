import java.util.ArrayList;
import java.util.List;

public class Veterinaria {
	private List<Animal> animais;
	private String nome;

	public Veterinaria(String nome) {
		setNome(nome);
		animais = new ArrayList<Animal>();
	}

	public String getNome() {
		return nome;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome deve ser preenchido");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve possuir pelo menos 3 caracteres");
		}

		this.nome = nome;
	}

	public void addAnimal(Animal animal) throws IllegalArgumentException {
		if (animal == null) {
			throw new IllegalArgumentException("O animal deve ser informado");
		}

		animais.add(animal);
	}

	public Animal procurarAnimal(String nome) {
		for (Animal a : animais) {
			if (a.getNome().equals(nome)) {
				return a;
			}
		}

		return null;
	}

	public boolean removerAnimal(String nome) {
		Animal a = procurarAnimal(nome);
		if (a == null) {
			return false;
		}

		animais.remove(a);
		return true;
	}

	public String listarAnimais() {
		if (animais.isEmpty()) {
			return "Nenhum animal cadastrado";
		}
		String lista = "";
		for (Animal a : animais) {
			lista += a.getNome() + "\n";
		}

		return lista;
	}
}
