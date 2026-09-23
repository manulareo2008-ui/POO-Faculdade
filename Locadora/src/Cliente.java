import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String cpf;
	private String telefone;
	private List<Bicicleta> bicicletas;

	public Cliente(String nome, String cpf, String telefone) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		bicicletas = new ArrayList<Bicicleta>();
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
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

	public void setCpf(String cpf) throws IllegalArgumentException {
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("O CPF deve ser informado");
		}
		if (cpf.length() != 14) {
			throw new IllegalArgumentException("O CPF deve ter 14 caracteres");
		}

		this.cpf = cpf;
	}

	public void setTelefone(String telefone) throws IllegalArgumentException {
		if (telefone == null || telefone.isBlank()) {
			throw new IllegalArgumentException("O telefone deve ser informado");
		}
		if (telefone.length() != 14) {
			throw new IllegalArgumentException("O telefone deve ter 14 caracteres");
		}

		this.telefone = telefone;
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

	public void addBicicleta(Bicicleta bicicleta) throws IllegalArgumentException {
		if (bicicleta == null) {
			throw new IllegalArgumentException("A bicicleta deve ser preenchida");
		}
		bicicletas.add(bicicleta);
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

	public String imprimirDados() {
		String dados = getNome() + " - " + getCpf() + " - " + getTelefone();
		
		if (bicicletas.isEmpty()) {
			dados += " - Não a bicicletas cadastradas";
		}
		dados += "\nLista de bicicletas: ";
		for (Bicicleta b : bicicletas) {
			dados += b.imprimirDados() + "\n";
		}

		return dados;
	}
}
