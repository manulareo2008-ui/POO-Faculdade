package pizzaria.modelo;

import pizzaria.excessao.MenorIgual0Exception;

public class PizzaDoce extends Pizza {
	private boolean cobertura;
	private double valor;

	public PizzaDoce(String nome, double precoBase, boolean cobertura, double valor) {
		super(nome, precoBase);
		setCobertura(cobertura);
		setValor(valor);
	}

	public boolean isCobertura() {
		return cobertura;
	}

	public double getValor() {
		return valor;
	}

	public void setCobertura(boolean cobertura) {
		this.cobertura = cobertura;
	}

	public void setValor(double valor) throws MenorIgual0Exception {
		if (valor <= 0) {
			throw new MenorIgual0Exception("Valor");
		}
		this.valor = valor;
	}

	@Override 
	public double calcularPreco() {
		if(isCobertura()) {
			return getValor() + getPrecoBase();
		}
		
		return getPrecoBase();
	}
}
