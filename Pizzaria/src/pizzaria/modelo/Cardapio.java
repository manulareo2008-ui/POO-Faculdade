package pizzaria.modelo;

import java.util.ArrayList;
import java.util.List;

import pizzaria.excessao.CampoVazioException;

public class Cardapio {
	private String nome;
	private List<Pizza> colecaoPizzas;

	public Cardapio(String nome) {
		setNome(nome);
		colecaoPizzas = new ArrayList<Pizza>();
	}

	public String getNome() {
		return nome;
	}

	public List<Pizza> getColecaoPizzas() {
		return colecaoPizzas;
	}

	public void setNome(String nome) throws CampoVazioException {
		if (nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("Nome deve ter, pelo menos, 3 letras");
		}

		this.nome = nome;
	}

	public void addPizza(Pizza pizza) throws CampoVazioException {
		if (pizza == null) {
			throw new CampoVazioException("Pizza");
		}
		for (Pizza p : colecaoPizzas) {
			if (p == pizza) {
				throw new IllegalArgumentException("Pizza já cadastrada");
			}
		}

		colecaoPizzas.add(pizza);
	}

	public double calcularTotal() {
		if (colecaoPizzas.isEmpty())
			return 0;
		double total = 0;
		for (Pizza p : colecaoPizzas) {
			total += p.calcularPreco();
		}

		return total;
	}
}
