import javax.swing.JOptionPane;
public class Principal {

	public Principal() {
		Produto p1 = new Produto();
		//p1.setNome("Paozinho");
		//p1.setValorUnitario(2);
		String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
		
		String  valor = JOptionPane.showInputDialog("Digite o preço do produto; ");
		float valorFloat = Float.parseFloat(valor);
		
		p1.setNome(nome);
		p1.setValorUnitario(valorFloat);
		
		Produto p2 = new Produto();
		p2.setNome("Leite");
		p2.setValorUnitario(4);
		
		ItemProduto item1 = new ItemProduto();
		item1.setProduto(p1);
		item1.setQuantidade(10);
		
		ItemProduto item2 = new ItemProduto();
		item2.setProduto(p2);
		item2.setQuantidade(10);
		
		Comanda c1 = new Comanda();
		c1.setNumero(1);
		c1.addItem(item1);
		c1.addItem(item2);
		
		ItemProduto item3 = new ItemProduto();
		item3.setProduto(p1);
		item3.setQuantidade(10);
		
		Comanda c2 = new Comanda();
		c2.setNumero(2);
		c2.addItem(item3);
		
		//System.out.println(c1.imprimirComanda());		
		JOptionPane.showMessageDialog(null, c1.imprimirComanda());
		
		//System.out.println(c2.imprimirComanda());
		JOptionPane.showMessageDialog(null, c2.imprimirComanda());


	}

	public static void main(String[] args) {
		new Principal();
	}

}
