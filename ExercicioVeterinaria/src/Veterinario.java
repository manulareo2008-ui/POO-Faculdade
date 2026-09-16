import java.util.List;
import java.util.ArrayList;

public class Veterinario {
	private String nome;
	private List<Animal> animais;

	public Veterinario(String nome) {
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
			throw new IllegalArgumentException("O nome deve ser informado");
		}

		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve ter mais de 2 caracteres");
		}

		this.nome = nome;
	}

	public void setAnimais(List<Animal> animais) throws IllegalArgumentException {
		if (animais == null) {
			throw new IllegalArgumentException("O animal deve ser informado");
		}

		this.animais = animais;
	}

	public void addAnimal(Animal animal) throws IllegalArgumentException {
		if (animal == null) {
			throw new IllegalArgumentException("O animal deve ser informado");
		}

		animais.add(animal);
	}

	public Animal buscarAnimalPeloNome(String nome) {
		for (Animal a : animais) {
			if (a.getNome().equals(nome)) {
				return a;
			}
		}
		return null;
	}

	public boolean alterarInformacoesAnimal(String nomeAtual, String novoNome, String novaEspecie, Dono novoDono,
			float[] novosPesos) {

		Animal a = buscarAnimalPeloNome(nomeAtual);
		if (a == null) {
			return false;
		}
		if (novoNome != null) {
			a.setNome(novoNome);
		}
		if (novaEspecie != null) {
			a.setEspecie(novaEspecie);
		}
		if (novoDono != null) {
			a.setDono(novoDono);
		}
		if (novosPesos != null) {
			a.setPesos(novosPesos);
		}

		return true;
	}

	public boolean excluirAnimal(String nome) {
		Animal a = buscarAnimalPeloNome(nome);
		if (a == null) {
			return false;
		}

		animais.remove(a);
		return true;

	}

	public String listarAnimais() {
		String lista = "";
		for (Animal a : animais) {
			lista += a.getNome() + "\n";
		}

		return lista;
	}

	public float mediaGeralPeso() {
		if (animais.isEmpty()) {
			return -1;
		}
		float soma = 0;
		for (Animal a : animais) {
			soma += a.calcularMediaPeso();
		}

		return soma / animais.size();
	}

	public Animal maiorPesoMedio() {
		if (animais.isEmpty()) {
			return null;
		}
		Animal maior = animais.get(0);
		for (Animal a : animais) {
			if (a.calcularMediaPeso() > maior.calcularMediaPeso()) {
				maior = a;
			}
		}
		return maior;
	}

	public int qntAnimaisAcimaPesoInformado(float peso) {
		int qnt = 0;

		for (Animal a : animais) {
			if (a.calcularMediaPeso() > peso) {
				qnt++;

			}
		}

		return qnt;
	}

	public List<Animal> animaisDoDonoInformado(String nomeDono) {
		List<Animal> doDono = new ArrayList<Animal>();

		for (Animal a : animais) {
			if (a.getDono().getNome().equals(nomeDono)) {
				doDono.add(a);

			}
		}

		return doDono;
	}

	public int qntAnimaisDoDono(String nomeDono) {
		int qnt = 0;

		for (Animal a : animais) {
			if (a.getDono().getNome().equals(nomeDono)) {
				qnt++;
			}
		}

		return qnt;
	}

	public String dadosContatoDonoDoAnimal(String nomeAnimal) {
		Animal a = buscarAnimalPeloNome(nomeAnimal);
		if (a == null) {
			return null;
		}

		return a.getDono().imprimirDados();
	}
}
