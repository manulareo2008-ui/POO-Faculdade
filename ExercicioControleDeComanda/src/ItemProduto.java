import javax.swing.JOptionPane;

public class ItemProduto {
	private Produto produto;
	private int quantidade;
	
	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setProduto(Produto produto) {
		if(produto != null) {
			this.produto = produto;
		} else {
			JOptionPane.showMessageDialog(null, "O produto deve ser informado.");
		}
	}
	
	public void setQuantidade(int quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		} else {
			JOptionPane.showMessageDialog(null, "A quantidade deve ser superior a 0");
		}
	}
	
	public double getSubtotal() {
		double total = quantidade * produto.getValorUnitario();
		return total;
	}
}
