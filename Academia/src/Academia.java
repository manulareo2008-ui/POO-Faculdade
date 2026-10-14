import java.util.List;
import java.util.ArrayList;

public class Academia {
	private String nome;
	private List<Aluno> alunos;

	public Academia(String nome) {
		setNome(nome);
		alunos = new ArrayList<Aluno>();
	}

	public String getNome() {
		return nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome deve ser informado");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve conter pelo menos 3 caracteres");
		}

		this.nome = nome;
	}

	public void addAluno(Aluno aluno) {
		if (aluno == null) {
			throw new IllegalArgumentException("O aluno deve ser informado");
		}
		for (Aluno a : alunos) {
			if (a.getTelefone() == aluno.getTelefone()) {
				throw new IllegalArgumentException("O aluno já está na lista");
			}
		}

		alunos.add(aluno);
	}

	public String listarAlunos() {
		if (alunos.isEmpty()) {
			return "A lista de alunos está vazia";
		}
		String lista = "";
		for (Aluno a : alunos) {
			lista += a.getNome() + "\n";
		}

		return lista;
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

	public int qntAlunosSoAcademia(Atividade atividade) {
		if (alunos.isEmpty()) {
			return 0;
		}
		int qnt = 0;
		for (Aluno a : alunos) {
			if (a.getAtividades().size() == 1) {
				if (a.getAtividades().get(0).equals("academia")) {
					qnt++;
				}
			}
		}

		return qnt;
	}

	public String quaisAtividadesPorAluno(String telefone, List<Atividade> atividades) {
		if (alunos.isEmpty()) {
			return "Nenhum aluno cadastrado";
		}
		Aluno teste = procurarAluno(telefone);
		if (teste == null) {
			return "O aluno não está na lista";
		}
		String lista = "";
		for (int i = 0; i < atividades.size(); i++) {
			lista += teste.getAtividades().get(i) + "\n";
		}

		return lista;
	}
}