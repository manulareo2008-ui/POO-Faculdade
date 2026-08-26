
public class Produto {
	private String nome;
	private float valorUnitario;
	
	public String getNome() {
		return nome;
	}
	
	public float getValorUnitario() {
		return valorUnitario;
	}
	
	public void setNome(String nome) {
		if(nome != null && nome.isBlank()) {
			this.nome = nome;
		} else {
			System.out.println("O nome do produto deve ser atribuido");
		}
	}
	
	public void setValorUnitario(int valorUnitario) {
		if(valorUnitario > 0) {
			this.valorUnitario = valorUnitario;
		} else {
			System.out.println("O valor do produto deve ser maior do que 0");
		}
	}
}
