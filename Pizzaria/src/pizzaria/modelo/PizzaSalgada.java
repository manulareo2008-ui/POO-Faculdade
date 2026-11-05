package pizzaria.modelo;

import pizzaria.excessao.MenorIgual0Exception;

public class PizzaSalgada extends Pizza {
	private boolean bordaRecheada;
	private double valorBorda;
	
	public PizzaSalgada(String nome, double precoBase, boolean bordaRecheada, double valorBorda) {
		super(nome, precoBase);
		setBordaRecheada(bordaRecheada);
		setValorBorda(valorBorda);
	}

	public boolean isBordaRecheada() {
		return bordaRecheada;
	}
	
	public double getValorBorda() {
		return valorBorda;
	}

	public void setBordaRecheada(boolean bordaRecheada) {
		this.bordaRecheada = bordaRecheada;
	}

	public void setValorBorda(double valorBorda) throws MenorIgual0Exception {
		if(valorBorda <= 0) {
			throw new MenorIgual0Exception("Valor");
		}
		this.valorBorda = valorBorda;
	}

	@Override
	public double calcularPreco() {
		if(isBordaRecheada()) {
			return getPrecoBase() + getValorBorda();
		}
		
		return getPrecoBase();
	}
}
