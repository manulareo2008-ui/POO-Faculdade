import java.util.List;

public class Comanda {
	//private ItemProduto[] itens;
	private int numero;
	//private int qntAtualProduto;
	private List<ItemProduto> itens;

	public Comanda() {
		//itens = new ItemProduto[20];
	    //qntAtualProduto = 0;
		itens = new Arreylisy<ItemProduto>();
	}

	public ItemProduto[] getItens() {
		return itens;
	}

	public int numeracao() {
		return numero;
	}

	public void setItemProduto(ItemProduto[] item) {
		this.itens = itens;
	}

	public void setNumero(int numero) {
		if (numero > 0) {
			this.numero = numero;
		} else {
			System.out.println("A numeração não pode ser meno ou igual a 0");
		}
	}

	public void addItem(ItemProduto item) {
		if (item == null) {
			System.out.println("Item deve ser informado");
		} else {
			//itens[qntAtualProduto] = item;
			//qntAtualProduto++;
			itens.add(item);
		}
	}

	public String imprimirComanda() {
		String dados = "";

		// System.out.println(numero);
		dados += numero;
		for (int i = 0; i < itens.size(); i++) {
			// System.out.print(itens[i].getProduto().getNome() + " R$"
			// + itens[i].getProduto().getValorUnitario() + " - "
			// + itens[i].getQuantidade());

			dados += (itens.get(i).getProduto().getNome() + " R$" + itens.get(i).getProduto().getValorUnitario() + " - "
					+ itens.get(i).getQuantidade());

			if (itens.get(i).getQuantidade() == 1) {
				// System.out.println(" item");
				dados += " item\n";
			} else {
				// System.out.println(" itens");
				dados += " itens\n";
			}
		}
		return dados;
	}
}
