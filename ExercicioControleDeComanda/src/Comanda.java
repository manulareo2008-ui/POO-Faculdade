import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Comanda {
	private List<ItemProduto> listaProdutos;
	private int numero;

	public Comanda() {
		listaProdutos = new ArrayList<ItemProduto>();
	}

	public int getNumero() {
		return numero;
	}

	public List<ItemProduto> getListaProdutos() {
		return listaProdutos;
	}

	public void setNumero(int numero) {
		if (numero > 0) {
			this.numero = numero;
		} else {
			JOptionPane.showMessageDialog(null, "O número da comanda deve ser maior do que 0");
		}
	}

	public void addItem(ItemProduto item) {
		if (item != null) {
			listaProdutos.add(item);
		}
	}

	public double valorTotal() {
		double total = 0;
		for (int i = 0; i < listaProdutos.size(); i++) {
			total += listaProdutos.get(i).getSubtotal();
		}
		return total;
	}

	public String imprimirComanda() {
		String dados = "Comanda n " + numero + "\n";
		for (int i = 0; i < listaProdutos.size(); i++) {
			dados += listaProdutos.get(i).getProduto().getNome() + " R$"
					+ listaProdutos.get(i).getProduto().getValorUnitario() + " -"
					+ listaProdutos.get(i).getQuantidade();
			if(listaProdutos.get(i).getQuantidade() == 1) {
				dados += "item\n";
			} else {
				dados += "itens \n";
			}
		}
		dados += "Total: R$" + valorTotal();
		return dados;
	}
}
