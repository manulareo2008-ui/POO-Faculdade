
public class Item {
	private String nome;
	private int qnt;

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

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		if (qnt > 0) {
			this.qnt = qnt;
		}
	}
}
