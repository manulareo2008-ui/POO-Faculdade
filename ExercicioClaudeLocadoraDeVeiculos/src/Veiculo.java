
public class Veiculo {
	private int placa;
	private String modelo;
	private double valorDiaria;

	public Veiculo(int placa, String modelo, double valorDIaria) {
		setPlaca(placa);
		setModelo(modelo);
		setValorDiaria(valorDiaria);
	}

	public int getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setPlaca(int placa) {
		if (placa <= 0) {
			System.out.println("A placa deve ser maior do que 0");
		} else {
			this.placa = placa;
		}
	}

	public void setModelo(String modelo) {
		if (modelo == null || modelo.isBlank()) {
			System.out.println("O modelo deve ser informado");
		} else if (modelo.length() < 3) {
			System.out.println("O modelo deve ter no mínimo 3 caracteres");
		} else {
			this.modelo = modelo;
		}
	}

	public void setValorDiaria(double valorDiaria) {
		if (valorDiaria <= 0) {
			System.out.println("O valor da diaria deve ser maior do que R$0");
		} else {
			this.valorDiaria = valorDiaria;
		}
	}

	public String imprimirDados() {
		return getPlaca() + " - " + getModelo() + " - " + getValorDiaria();
	}
}
