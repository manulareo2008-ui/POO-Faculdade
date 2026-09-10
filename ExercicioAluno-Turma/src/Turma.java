import java.util.List;
import java.util.ArrayList;

public class Turma {
	private String nome;
	private List<Aluno> alunos;

	public Turma(String nome) {
		setNome(nome);
		alunos = new ArrayList<Aluno>();
	}

	public String getNome() {
		return nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome deve ser informado");
		} else if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve ter no mínimo 3 caracteres");
		}

		this.nome = nome;
	}

	public void setAlunos(List<Aluno> alunos) {
		if (alunos == null) {
			throw new IllegalArgumentException("A lista de alunos não pode ser vazia");
		}

		this.alunos = alunos;
	}

	public void addAluno(Aluno aluno) throws IllegalArgumentException {
		if (aluno != null) {
			this.alunos.add(aluno);
		} else {
			throw new IllegalArgumentException("ALuno deve ser informado");
		}
	}

	public Aluno buscarAluno(String nome) {
		for (Aluno a : alunos) {
			if (a.getNome().equals(nome)) {
				return a;
			}
		}
		return null;
	}

	public boolean alterarInformacoes(String nomeAtual, String novoNome, float[] notas) {
		Aluno a = buscarAluno(nomeAtual);
		if (a == null) {
			return false;
		}
		if (novoNome != null) {
			a.setNome(novoNome);
		}
		if (notas != null) {
			a.setNotas(notas);
		}
		return true;
	}

	public boolean excluirAluno(String nome) throws IllegalArgumentException {
		Aluno a = buscarAluno(nome);

		if (a == null) {
			return false;
		}

		alunos.remove(a);
		return true;
	}
	
	public String listarAlunos() {
		String dados = "";
		for(Aluno a: alunos) {
			dados += a.imprimirDados() + "\n";
		}
		return dados;
	}
	
	public float mediaGeral() {
		if(alunos.isEmpty()) {
			return 0;
		}
		float media = 0;
		for(Aluno a: alunos) {
			media += a.calcularMedia();
		}
		return media / alunos.size();
	}
	
	public Aluno maiorMedia() {
		if(alunos.isEmpty()) {
			return null;
		}
		Aluno maior = alunos.get(0);
		for(Aluno a: alunos) {
			if(a.calcularMedia() > maior.calcularMedia()) {
				maior = a;
			}
		}
		return maior;
	}
	
	public int qntAcimaMedia(){
		int qnt = 0;
		for(Aluno a: alunos) {
			if(a.calcularMedia() >= 7) {
				qnt++;
			}
		}
		return qnt;
	}
}