
public class Caminhao extends Veiculo {
	private double capacidadeToneladas;

	public Caminhao(String placa, String modelo, double valorDiaria, int totalDias, double capacidadeToneladas) {
		super(placa, modelo, valorDiaria, totalDias);
		setCapacidadeToneladas(capacidadeToneladas);
	}

	public double getCapacidadeToneladas() {
		return capacidadeToneladas;
	}

	public void setCapacidadeToneladas(double capacidadeToneladas) throws MenorIgual0Exception {
		if (capacidadeToneladas <= 0) {
			throw new MenorIgual0Exception("Capacidade em toneladas");
		}
		this.capacidadeToneladas = capacidadeToneladas;
	}

	@Override
	public double calcularValorFinal() {
		return calcularValorBase() + (capacidadeToneladas * 100);
	}

	@Override
	public String imprimirDados() {
		return super.imprimirDados() + " - Capacidade toneladas: " + capacidadeToneladas + " - Valor final: R$"
				+ calcularValorFinal();
	}
}
