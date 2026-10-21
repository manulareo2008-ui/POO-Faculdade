public class Atividade {
	private String nome;

	public Atividade(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome da atividade deve ser preenchido");
		}
		if (!nome.equals("academia") && !nome.equals("funcional") && !nome.equals("corrida") && !nome.equals("bike")) {
			throw new IllegalArgumentException(
					"O nome da atividade deve ser um dos seguintes: funcional, corrida ou bike");
		}

		this.nome = nome;
	}
}
