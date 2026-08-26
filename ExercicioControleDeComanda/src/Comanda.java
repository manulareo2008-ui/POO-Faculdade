
public class Comanda {
	private ItemProduto[] itens;
	private int numero;
	private int qntAtualProduto;

	public Comanda() {
		itens = new ItemProduto[20];
		qntAtualProduto = 0;
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
			itens[qntAtualProduto] = item;
			qntAtualProduto++;
		}
	}

	public String imprimirComanda() {
		String dados = "";

		// System.out.println(numero);
		dados += numero;
		for (int i = 0; i < qntAtualProduto; i++) {
			// System.out.print(itens[i].getProduto().getNome() + " R$"
			// + itens[i].getProduto().getValorUnitario() + " - "
			// + itens[i].getQuantidade());

			dados += (itens[i].getProduto().getNome() + " R$" + itens[i].getProduto().getValorUnitario() + " - "
					+ itens[i].getQuantidade());

			if (itens[qntAtualProduto].getQuantidade() == 1) {
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
