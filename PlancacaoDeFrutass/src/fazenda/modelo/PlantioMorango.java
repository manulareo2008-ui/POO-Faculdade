package fazenda.modelo;

import fazenda.excessoes.MenorIgual0Exception;

public class PlantioMorango extends Plantio {
	private double kgPorMuda;

	public PlantioMorango(String variedade, int quantidadeMudas, double kgPorMuda) {
		super(variedade, quantidadeMudas);
		setKgPorMuda(kgPorMuda);
	}

	public double getKgPorMuda() {
		return kgPorMuda;
	}

	private void setKgPorMuda(double kgPorMuda) {
		if (kgPorMuda <= 0) {
			throw new MenorIgual0Exception("Kg por muda");
		}

		this.kgPorMuda = kgPorMuda;
	}

	@Override
	public double calcularProducao() {
		return getQuantidadeMudas() * getKgPorMuda();
	}
}
