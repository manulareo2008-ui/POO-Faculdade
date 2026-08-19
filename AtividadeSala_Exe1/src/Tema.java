
public class Tema {
	private String nome;
	private float valorAluguel;
	private Item[] item;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty() && nome.length() >= 3) {
			this.nome = nome;
		} else {
			System.out.println("O nome deve ser preenchido");
		}
	}

	public float getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(float valorAluguel) {
		if (valorAluguel > 0) {
			this.valorAluguel = valorAluguel;
		} else {
			System.out.println("O valor do aluguel deve ser preenchido");
		}
	}

	public Item[] getItem() {
		return item;
	}

	public void setItem(Item[] item) {
		this.nome = nome;
	}
}

