package empresa.modelo;
import empresa.excecao.CampoVazioException;

public abstract class Funcionario {
	private String nome;
	private String matricula;

	public Funcionario(String nome, String matricula) {
		setNome(nome);
		setMatricula(matricula);
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setNome(String nome) throws CampoVazioException {
		if (nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("Nome deve ter, pelo menos, 3 caracteres");
		}

		this.nome = nome;
	}

	public void setMatricula(String matricula) throws CampoVazioException {
		if (matricula == null || matricula.isBlank()) {
			throw new CampoVazioException("Matricula");
		}

		this.matricula = matricula;
	}

	public abstract double calcularSalario();

	public String imprimirDados() {
		return "Nome: " + getNome() + " - Matricula: " + getMatricula();
	}
}
