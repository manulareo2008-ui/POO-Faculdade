package empresa.modelo;

import empresa.excecao.MenorIgual0Exception;

public class Venda {
	private double valor;
	
	public Venda(double valor) {
		setValor(valor);
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) throws MenorIgual0Exception{
		if(valor <= 0) {
			throw new MenorIgual0Exception("Valor");
		}
		
		this.valor = valor;
	}
}
