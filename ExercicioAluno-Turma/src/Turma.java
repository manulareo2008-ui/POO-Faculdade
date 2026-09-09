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

	public void setNome(String nome) {
		if (nome == null || nome.isBlank()) {
			System.out.println("O nome deve ser informado");
		} else if (nome.length() < 3) {
			System.out.println("O nome deve ter mais do que 2 caracteres");
		} else {
			this.nome = nome;
		}
	}

	public void setAlunos(List<Aluno> alunos) {
		if (alunos == null) {
			System.out.println("Os dados do aluno devem ser informados");
		} else {
			this.alunos = alunos;
		}
	}

	public void cadastrarAlunoNovo(Aluno aluno) {
		if (aluno == null) {
			System.out.println("Os dados do aluno devem ser informados");
		} else {
			alunos.add(aluno);
		}
	}

	public Aluno buscarAlunoPeloNome(String nome) {
		if (nome != null) {
			for (Aluno a : alunos) {
				if (a.getNome().equals(nome)) {
					return a;
				}
			}
		}
		return null;
	}

	public boolean alterarInformacoesAluno(String nomeAtual, 
			String novoNome, double n1, double n2, double n3) {
		
		Aluno alunoAtual = buscarAlunoPeloNome(nomeAtual);
		if(alunoAtual == null) {
			return false;
		} else {
			alunoAtual.setNome(novoNome);
			if(n1 >= 0 && n1 <= 10) {
				alunoAtual.setNota1(n1);
			}
			if(n2 >= 0 && n2 <= 10) {
				alunoAtual.setNota2(n2);
			}
			if(n3 >= 0 && n3 <= 10) {
				alunoAtual.setNota3(n3);
				
			}
			return true;
		} 
	}

	public boolean excluirAlunoDaTurma(String nome) {
		Aluno a = buscarAlunoPeloNome(nome);
		if (a == null) {
			return false;
		} else {
			alunos.remove(a);
			return true;
		}
	}

	public String listarAlunos() {
		String dados = "";
		for (Aluno a : alunos) {
			dados += a.getNome() + " - Média: " + a.calcularMedia() + "\n";
		}
		return dados;
	}

	public double calcularMediaTurma() {
		if (alunos.isEmpty()) {
			return 0;
		}
		double total = 0;
		for (Aluno a : alunos) {
			total += a.calcularMedia();
		}
		return total / alunos.size();
	}

	public Aluno identificarAlunoComMaiorNota() {
		if (alunos.isEmpty()) {
			return null;
		}
		Aluno maior = alunos.get(0);
		for (Aluno a : alunos) {
			if (a.calcularMedia() > maior.calcularMedia()) {
				maior = a;
			}
		}
		return maior;
	}
	
	public int informarQntAlunosAcimaOuIgualAMedia7() {
		
		int qnt = 0;
		for(Aluno a: alunos) {
			if(a.calcularMedia() >= 7) {
				qnt++;
			}
		}
		
		return qnt;
	}
}
