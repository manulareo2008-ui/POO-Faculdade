
public class ItemProduto {
	private Produto produto;
	private int quantidade;
	
	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setProduto (Produto produto) {
		this.produto = produto;
	}
	
	public void setQuantidade(int quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		} else {
			System.out.println("A quantidade do produto deve ser mais do que 0");
		}
	}
}
