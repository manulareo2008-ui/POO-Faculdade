import java.util.List;
import java.util.ArrayList;

public class Professor {
	private String nome;
	private String endereco;
	private String telefone;
	private List<Aluno> alunos;

	public Professor(String nome, String endereco, String telefone) {
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
		alunos = new ArrayList<Aluno>();
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome deve ser preenchido");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve ter pelo menos 3 caracteres");
		}

		this.nome = nome;
	}

	public void setEndereco(String endereco) throws IllegalArgumentException {
		if (endereco == null || endereco.isBlank()) {
			throw new IllegalArgumentException("O endereço deve ser preenchido");
		}
		if (endereco.length() < 3) {
			throw new IllegalArgumentException("O endereço deve ter pelo menos 3 caracteres");
		}

		this.endereco = endereco;
	}

	public void setTelefone(String telefone) throws IllegalArgumentException {
		if (telefone == null || telefone.isBlank()) {
			throw new IllegalArgumentException("O telefone deve ser preenchido");
		}
		if (telefone.length() != 11 && telefone.length() != 13) {
			throw new IllegalArgumentException(
					"O telefone deve ter 11 caracteres caso o 55 não esteja incluso ou 13 caracteres caso esteja incluso");
		}

		this.telefone = telefone;
	}

	public void addAluno(Aluno aluno) throws IllegalArgumentException {
		if (aluno == null) {
			throw new IllegalArgumentException("O aluno deve ser prenchido");
		}
		for (Aluno a : alunos) {
			if (a.getTelefone() == aluno.getTelefone()) {
				throw new IllegalArgumentException("O aluno já está cadastrado");
			}
		}

		alunos.add(aluno);
	}

	public Aluno procurarAluno(String telefone) {
		if (alunos.isEmpty()) {
			return null;
		}
		for (Aluno a : alunos) {
			if (a.getTelefone().equals(telefone)) {
				return a;
			}
		}

		return null;
	}

	public boolean removerAluno(String telefone) {
		if (alunos.isEmpty()) {
			return false;
		}
		Aluno a = procurarAluno(telefone);
		if (a == null) {
			return false;
		}

		alunos.remove(a);
		return true;
	}

	public String listarAlunos() {
		if (alunos.isEmpty()) {
			return "Nenhum aluno na lista de alunos";
		}
		String lista = "";
		for (Aluno a : alunos) {
			lista += a.getNome() + "\n";
		}

		return lista;
	}

	public String imprimirDados() {
		String dados = getNome() + " - " + getEndereco() + " - " + getTelefone();
		if (alunos.isEmpty()) {
			dados += " - Nenhum aluno na lista";
		} else {
			dados += "\nLista de alunos: \n";
			for (Aluno a : alunos) {
				dados += a.imprimirDados() + "\n";
			}
		}

		return dados;
	}
}
