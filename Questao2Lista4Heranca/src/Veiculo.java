
public abstract class Veiculo {
	private String placa;
	private String modelo;
	private double valorDiaria;
	private int totalDias;

	public Veiculo(String placa, String modelo, double valorDiaria, int totalDias) {
		setPlaca(placa);
		setModelo(modelo);
		setValorDiaria(valorDiaria);
		setTotalDias(totalDias);
	}

	public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public int getTotalDias() {
		return totalDias;
	}

	public void setPlaca(String placa) throws CampoVazioException {
		if (placa == null || placa.isBlank()) {
			throw new CampoVazioException("Placa");
		}
		if (placa.length() < 5) {
			throw new IllegalArgumentException("Placa deve ter, pelo menos, 5 caracteres");
		}

		this.placa = placa;
	}

	public void setModelo(String modelo) throws CampoVazioException {
		if (modelo == null || modelo.isBlank()) {
			throw new CampoVazioException("Modelo");
		}

		this.modelo = modelo;
	}

	public void setValorDiaria(double valorDiaria) throws MenorIgual0Exception {
		if (valorDiaria <= 0) {
			throw new MenorIgual0Exception("Valor da diaria");
		}

		this.valorDiaria = valorDiaria;
	}

	public void setTotalDias(int totalDias) throws MenorIgual0Exception {
		if (totalDias <= 0) {
			throw new MenorIgual0Exception("Total de diarias");
		}

		this.totalDias = totalDias;
	}

	public String imprimirDados() {
		return "Placa: " + getPlaca() + " - Modelo: " + getModelo() + " - Valor diaria: R$" + getValorDiaria()
				+ " - Total dias: " + getTotalDias();
	}
	
	public double calcularValorBase() {
		return getValorDiaria() * getTotalDias();
	}
	
	public abstract double calcularValorFinal();
}
