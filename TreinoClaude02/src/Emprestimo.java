
public class Emprestimo {
	private String nomeAluno;
	private Livro livro;
	private int prazoDias;

	public String getNomeAluno() {
		return nomeAluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public int getPrazoDias() {
		return prazoDias;
	}

	public void setNomeAluno(String nomeAluno) {
		if (nomeAluno != null && nomeAluno.length() >= 3) {
			this.nomeAluno = nomeAluno;
		}
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public void setPrazoDias(int prazoDias) {
		if (prazoDias > 0) {
			this.prazoDias = prazoDias;
		} else {
			System.out.println("O prazo deve ser maior a 0");
		}
	}
}

