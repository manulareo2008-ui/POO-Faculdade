package heranca; // pacote 'heranca': mesmo nome da pasta em src/ (tem que casar, senao da erro)

public class Cliente {
	private String nome;
	private String endereco;

	public Cliente(String nome, String endereco) {
		setNome(nome);     // construtor chama os setters => validacao vale pra todo caminho
		setEndereco(endereco);
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) { // null testado PRIMEIRO (curto-circuito do ||)
			throw new IllegalArgumentException("O nome deve ser preenchido");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve possuir pelo menos 3 caracteres");
		}

		this.nome = nome;
	}

	public void setEndereco(String endereco) throws IllegalArgumentException {
		if (endereco == null || endereco.isBlank()) {
			throw new IllegalArgumentException("O endereco deve ser preenchido");
		}
		if (endereco.length() < 3) {
			throw new IllegalArgumentException("O endereco deve possuir pelo menos 3 caracteres");
		}

		this.endereco = endereco;
	}
}