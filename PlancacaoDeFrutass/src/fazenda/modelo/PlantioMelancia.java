package fazenda.modelo;

import fazenda.excessoes.MenorIgual0Exception;

public class PlantioMelancia extends Plantio {
	private int frutosPorMuda;
	private double pesoMedioFruto;

	public PlantioMelancia(String variedade, int quantidadeMudas, int frutosPorMuda, double pesoMedioFruto) {
		super(variedade, quantidadeMudas);
		setFrutosPorMuda(frutosPorMuda);
		setPesoMedioFruto(pesoMedioFruto);
	}

	public int getFrutosPorMuda() {
		return frutosPorMuda;
	}

	public double getPesoMedioFruto() {
		return pesoMedioFruto;
	}

	public void setFrutosPorMuda(int frutosPorMuda) throws MenorIgual0Exception {
		if (frutosPorMuda <= 0) {
			throw new MenorIgual0Exception("Frutos por muda");
		}

		this.frutosPorMuda = frutosPorMuda;
	}

	public void setPesoMedioFruto(double pesoMedioFruto) {
		if (pesoMedioFruto <= 0) {
			throw new MenorIgual0Exception("Peso medio do fruto");
		}

		this.pesoMedioFruto = pesoMedioFruto;
	}

	@Override
	public double calcularProducao() {
		return getQuantidadeMudas() * getFrutosPorMuda() * getPesoMedioFruto();
	}
}
