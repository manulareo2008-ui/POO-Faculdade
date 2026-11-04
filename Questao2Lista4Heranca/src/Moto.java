
public class Moto extends Veiculo {
	private boolean cilindradas;

	public Moto(String placa, String modelo, double valorDiaria, int totalDias, boolean cilindradas) {
		super(placa, modelo, valorDiaria, totalDias);
		setCilindradas(cilindradas);
	}

	public boolean isCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(boolean cilindradas) {
		this.cilindradas = cilindradas;
	}

	@Override
	public double calcularValorFinal() {
		if (getTotalDias() > 7) {
			if (cilindradas == false) {
				return calcularValorBase() - (calcularValorBase() * 0.1);
			} else {
				return calcularValorBase() - (calcularValorBase() * 0.05);
			}
		} else {
			return calcularValorBase();
		}
	}

	@Override
	public String imprimirDados() {
		String dados = super.imprimirDados();
		if (cilindradas) {
			dados += " - Possui cilindradas: Sim";
		} else {
			dados += " - Possui cilindradas: Não";
		}

		dados += " - Valor final: R$" + calcularValorFinal();
		return dados;
	}
}
