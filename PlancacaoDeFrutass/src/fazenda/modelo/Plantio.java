package fazenda.modelo;

import fazenda.excessoes.CampoVazioException;
import fazenda.excessoes.MenorIgual0Exception;

public abstract class Plantio {
	private String variedade;
	private int quantidadeMudas;

	public Plantio(String variedade, int quantidadeMudas) {
		setVariedade(variedade);
		setQuantidadeMudas(quantidadeMudas);
	}

	public String getVariedade() {
		return variedade;
	}

	public int getQuantidadeMudas() {
		return quantidadeMudas;
	}

	public void setVariedade(String variedade) throws CampoVazioException {
		if (variedade == null || variedade.isBlank()) {
			throw new CampoVazioException("Variedade");
		}
		this.variedade = variedade;
	}

	public void setQuantidadeMudas(int quantidadeMudas) throws MenorIgual0Exception {
		if (quantidadeMudas <= 0) {
			throw new MenorIgual0Exception("Quantidade de mudas");
		}

		this.quantidadeMudas = quantidadeMudas;
	}

	public abstract double calcularProducao();
}