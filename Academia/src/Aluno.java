import java.util.List;
import java.util.ArrayList;

public class Aluno {
	private String nome;
	private String dataNascimento;
	private String telefone;
	private Professor professor;
	private List<Atividade> atividades;

	public Aluno(String nome, String dataNascimento, String telefone, Professor professor) {
		setNome(nome);
		setDataNascimento(dataNascimento);
		setTelefone(telefone);
		setProfessor(professor);
		atividades = new ArrayList<Atividade>();
	}

	public String getNome() {
		return nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public Professor getProfessor() {
		return professor;
	}

	public List<Atividade> getAtividades() {
		return atividades;
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

	public void setDataNascimento(String dataNascimento) throws IllegalArgumentException {
		if (dataNascimento == null || dataNascimento.isBlank()) {
			throw new IllegalArgumentException("A data de nascimento deve ser preenchida");
		}
		if (dataNascimento.length() < 6) {
			throw new IllegalArgumentException("A data de nascimento deve conter, pelo menos, 6 caracteres");
		}

		this.dataNascimento = dataNascimento;
	}

	public void setTelefone(String telefone) throws IllegalArgumentException {
		if (telefone == null || telefone.isBlank()) {
			throw new IllegalArgumentException("O telefone deve ser preenchido");
		}
		if (telefone.length() != 11 && telefone.length() != 13) {
			throw new IllegalArgumentException(
					"O telefone deve ter 11 caracteres caso o 55 não seja incluso ou 13 caracteres caso seja incluso");
		}

		this.telefone = telefone;
	}

	public void setProfessor(Professor professor) throws IllegalArgumentException {
		if (professor == null) {
			throw new IllegalArgumentException("O professor deve ser informado");
		}

		this.professor = professor;
	}

	public void addAtividade(Atividade atividade) {
		if (atividades.size() >= 3) {
			throw new IllegalArgumentException("O aluno " + getNome() + " já tem todas as atividades preenchidas");
		}
		if (atividade == null) {
			throw new IllegalArgumentException("A atividade deve ser informada");
		}
		for (Atividade a : atividades) {
			if (a.getNome().equalsIgnoreCase(atividade.getNome())) {
				throw new IllegalArgumentException("Essa atividade já está registrada para esse aluno");
			}
		}
		if (atividades.size() == 2 && !atividade.getNome().equalsIgnoreCase("academia")) {
			for (Atividade a : atividades) {
				if (!a.getNome().equalsIgnoreCase("academia")) {
					throw new IllegalArgumentException(
							"O aluno não está cadastrado na academia, portanto ele não pode estar cadastrado em mais de duas atividades");
				}
			}
		}

		atividades.add(atividade);
	}

	public boolean removerAtividade(String nome) {
		if (atividades.isEmpty()) {
			return false;
		}
		for (Atividade a : atividades) {
			if (a.getNome().equalsIgnoreCase(nome)) {
				atividades.remove(a);
				return true;
			}
		}
		return false;
	}

	public String listarAtividades() {
		if (atividades.isEmpty()) {
			return "A lista de atividades se encontra vazia";
		}
		String lista = "";
		for (Atividade a : atividades) {
			lista += a.getNome() + "\n";
		}

		return lista;
	}

	public String imprimirDados() {
		String dados = getNome() + " - " + getDataNascimento() + " - " + getTelefone() + " - Professor: "
				+ getProfessor().getNome();
		if (atividades.isEmpty()) {
			dados += " - Lista de atividades vazia";
		} else {
			dados += "\nLista de atividades:\n";
			for (Atividade a : atividades) {
				dados += a.getNome() + "\n";
			}
		}

		return dados;
	}
}