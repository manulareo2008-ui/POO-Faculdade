import java.util.ArrayList;
import java.util.List;

public class Dono {
	private String nome;
	private String endereco;
	private String telefone;
	private List<Animal> animais;

	public Dono(String nome, String endereco, String telefone) {
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
		animais = new ArrayList<Animal>();
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
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

	public void setEndereco(String endereco) throws IllegalArgumentException {
		if (endereco == null || endereco.isBlank()) {
			throw new IllegalArgumentException("O endereco deve ser preenchido");
		}
		if (endereco.length() < 3) {
			throw new IllegalArgumentException("O endereco deve possuir pelo menos 3 caracteres");
		}

		this.endereco = endereco;
	}

	public void setTelefone(String telefone) throws IllegalArgumentException {
		if (telefone == null || telefone.isBlank()) {
			throw new IllegalArgumentException("O telefone deve ser preenchido");
		}
		if (telefone.length() != 11) {
			throw new IllegalArgumentException("O telefone deve possuir 11 caracteres");
		}

		this.telefone = telefone;
	}

	public void addAnimal(Animal animal) throws IllegalArgumentException {
		if (animal == null) {
			throw new IllegalArgumentException("O animal deve ser informado");
		}

		animais.add(animal);
	}
	

	public String imprimirDados() {
		String dados = getNome() + " - " + getEndereco() + " - " + getTelefone() + "\n";
		if (animais.isEmpty()) {
			dados += "Lista de animais vazia";
		} else {
			dados += "Lista de animais: \n";
			for (Animal a : animais) {
				dados += a.imprimirDados() + "\n";
			}
		}

		return dados;
	}

	public Animal procurarAnimal(String nome) {
		for (Animal a : animais) {
			if (a.getNome().equals(nome)) {
				return a;
			}
		}

		return null;
	}

	public String listarAnimais() {
		if (animais.isEmpty()) {
			return null;
		}
		String lista = "Lista de animais: \n";
		for (Animal a : animais) {
			lista += a.getNome() + "\n";
		}

		return lista;
	}
}
