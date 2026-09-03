import javax.swing.JOptionPane;

public class Principal {

	public Principal() {
		//Produto p1 = new Produto();

		String nomeProduto1 = JOptionPane.showInputDialog("Qual o produto 1: ");
		String valorProduto1 = JOptionPane.showInputDialog("Qual o valor do produto 1: ");
		double valor1 = Double.parseDouble(valorProduto1);
		
		Produto p1 = new Produto(nomeProduto1, valor1);
		//p1.setNome(nomeProduto1);
		//p1.setValorUnitario(valor1);

		Produto p2 = new Produto("Leite", 4);

		//String nomeProduto2 = JOptionPane.showInputDialog("Qual o nome do produto 2: ");
		//String valorProduto2 = JOptionPane.showInputDialog("Qual o valor do produto 2: ");
		//double valor2 = Double.parseDouble(valorProduto2);
		//p2.setNome(nomeProduto2);
		//p2.setValorUnitario(valor2);

		ItemProduto item1 = new ItemProduto();
		item1.setProduto(p1);

		String qntProduto1 = JOptionPane.showInputDialog("Qual a quantidade de " + nomeProduto1 + ": ");
		int qntFinalProduto1 = Integer.parseInt(qntProduto1);

		item1.setQuantidade(qntFinalProduto1);

		ItemProduto item2 = new ItemProduto();
		item2.setProduto(p2);

		String qntProduto2 = JOptionPane.showInputDialog("Qual a quantidade de " + nomeProduto2 + ": ");
		int qntFinalProduto2 = Integer.parseInt(qntProduto2);

		item2.setQuantidade(qntFinalProduto2);

		Comanda c1 = new Comanda();
		c1.setNumero(1);
		c1.addItem(item1);
		c1.addItem(item2);

		JOptionPane.showMessageDialog(null, c1.imprimirComanda());
	}

	public static void main(String[] args) {
		new Principal();
	}
}
