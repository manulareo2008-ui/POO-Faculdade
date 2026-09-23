import java.util.List;
import java.util.ArrayList;

public class Locadora {
	private String nome;
	private List<Bicicleta> bicicletas;

	public Locadora(String nome) {
		setNome(nome);
		bicicletas = new ArrayList<Bicicleta>();
	}

	public String getNome() {
		return nome;
	}

	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome deve ser informado");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve ter pelo menos 3 caracteres");
		}

		this.nome = nome;
	}

	public void addBicicleta(Bicicleta bicicleta) throws IllegalArgumentException {
		if (bicicleta == null) {
			throw new IllegalArgumentException("A bicicleta deve ser preenchida");
		}

		bicicletas.add(bicicleta);
	}

	public String listarBicicletas() {
		if (bicicletas.isEmpty()) {
			return "Nenhuma bicicleta cadastrada";
		}
		String lista = "";
		for (Bicicleta b : bicicletas) {
			lista += b.imprimirDados() + "\n";
		}
		return lista;
	}

	public Bicicleta procurarBicicleta(int codigo) {
		if (bicicletas.isEmpty()) {
			return null;
		}
		for (Bicicleta b : bicicletas) {
			if (b.getCodigo() == codigo) {
				return b;
			}
		}

		return null;
	}

	public boolean removerBicicleta(int codigo) {
		Bicicleta a = procurarBicicleta(codigo);
		if (a == null) {
			return false;
		}

		bicicletas.remove(a);
		return true;
	}
}
