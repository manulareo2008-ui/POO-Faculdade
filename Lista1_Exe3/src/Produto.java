
public class Produto {
	private String nome;
	private String descricao;
	private double preco;
	private int qntDisponivel;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getQntDisponivel() {
		return qntDisponivel;
	}
	public void setQntDisponivel(int qntDisponivel) {
		this.qntDisponivel = qntDisponivel;
	}
}
