
public abstract class Veiculo {
	private String placa;
	private double capTanque;
	private double consumo;

	public Veiculo(String placa, double capTanque, double consumo) {
		setPlaca(placa);
		setCapTanque(capTanque);
		setConsumo(consumo);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		if (placa == null || placa.isBlank()) {
			throw new CampoNaoInformadoException("Placa");
		}
		this.placa = placa;
	}

	public double getCapTanque() {
		return capTanque;
	}

	public void setCapTanque(double capTanque) {
		if (capTanque <= 0) {
			throw new ValorMenorZeroException("A capacidade do tanque");
		}
		this.capTanque = capTanque;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		if (consumo <= 0) {
			throw new ValorMenorZeroException("O consumo");
		}
		this.consumo = consumo;
	}

	public abstract double eficiencia();
	
	public double consumoEfetivo() {
		return consumo * eficiencia();
	}
	
	public double autonomia() {
		return capTanque * consumoEfetivo();
	}
	
	public double custoTotal(double qntKm, double precoLitro) {
		if(qntKm <= 0) {
			throw new ValorMenorZeroException("A quantidad de Km");
		}
		if(precoLitro <= 0) {
			throw new ValorMenorZeroException("O preço por litro");
		}
		
		double litros = qntKm / consumoEfetivo();
		return litros * precoLitro;
	}
}
















