package pizzaria.modelo;

import pizzaria.excessao.CampoVazioException;
import pizzaria.excessao.MenorIgual0Exception;

public abstract class Pizza {
	private String nome;
	private double precoBase;
	
	public Pizza(String nome, double precoBase) {
		setNome(nome);
		setPrecoBase(precoBase);
	}

	public String getNome() {
		return nome;
	}
	
	public double getPrecoBase() {
		return precoBase;
	}

	public void setNome(String nome) throws CampoVazioException {
		if(nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		if(nome.length() < 3) {
			throw new IllegalArgumentException("Nome deve ter, pelo menos, 3 letras");
		}
		
		this.nome = nome;
	}

	public void setPrecoBase(double precoBase) throws MenorIgual0Exception {
		if(precoBase <= 0) {
			throw new MenorIgual0Exception("Preço base");
		}
		
		this.precoBase = precoBase;
	}

	public abstract double calcularPreco();
}
