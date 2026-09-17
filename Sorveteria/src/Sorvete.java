
public class Sorvete {
	private String nome;
	private String sabor;
	private float preco;
	
	public Sorvete(String nome, String sabor, float preco) {
		setNome(nome);
		setSabor(sabor);
		setPreco(preco);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSabor() {
		return sabor;
	}
	
	public float getPreco() {
		return preco;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if(nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome do sorvete deve ser informado");
		}
		if(nome.length() < 3) {
			throw new IllegalArgumentException("O nome do sorvete deve possuir pelo menos 3 caracteres");
		}
		
		this.nome = nome;
	}
	
	public void setSabor(String sabor) throws IllegalArgumentException {
		if(sabor == null || sabor.isBlank()) {
			throw new IllegalArgumentException("O sabor do sorvete deve ser informado");
		}
		if(sabor.length() < 3) {
			throw new IllegalArgumentException("O sabor do sorvete deve possuir pelo menos 3 caracteres");
		}
		
		this.sabor = sabor;
	}
	
	public void setPreco(float preco) throws IllegalArgumentException {
		if(preco <= 0) {
			throw new IllegalArgumentException("O preco do sorvete deve possuir pelo menos 3 caracteres");
		}
		
		this.preco = preco;
	}
	
	public String imprimirDados() {
		return getNome() + " - " + getSabor() + " - " + getPreco();
	}
}
