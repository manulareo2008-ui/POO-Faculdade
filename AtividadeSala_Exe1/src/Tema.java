
public class Tema {

	private Item[] itens;
	private float valorAluguel;
	private String corToalha;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty() && nome.length() >= 3) {
			this.nome = nome;
		} else {
			System.out.println("Nome deve ser preenchido");
		}
	}

	public Item[] getItens() {
		return itens;
	}

	public void setItens(Item[] itens) {
		if (itens != null) {
			this.itens = itens;
		} else {
			System.out.println("Itens devem ser informados");
		}

	}

	public float getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(float valorAluguel) {
		if (valorAluguel > 0) {
			this.valorAluguel = valorAluguel;
		} else {
			System.out.println("Aluguel deve ser maior que 0");
		}
	}

	public String getCorToalha() {
		return corToalha;
	}

	public void setCorToalha(String corToalha) {
		if (corToalha != null && !corToalha.isEmpty() && corToalha.length() >= 3) {
			this.corToalha = corToalha;
		} else {
			System.out.println("Cor deve ser preenchida");
		}
	}

}
