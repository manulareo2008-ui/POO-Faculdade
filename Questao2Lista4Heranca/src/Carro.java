
public class Carro extends Veiculo {
	private int qntPortas;

	public Carro(String placa, String modelo, double valorDiaria, int totalDias, int qntPortas) {
		super(placa, modelo, valorDiaria, totalDias);
		setQntPortas(qntPortas);
	}

	public int getQntPortas() {
		return qntPortas;
	}

	public void setQntPortas(int qntPortas) throws MenorIgual0Exception {
		if (qntPortas <= 0) {
			throw new MenorIgual0Exception("Quantidade de portas");
		}

		this.qntPortas = qntPortas;
	}

	@Override
	public double calcularValorFinal() {
		return calcularValorBase() + 50;

	}

	@Override
	public String imprimirDados() {
		return super.imprimirDados() + " - Quantidade de portas: " + getQntPortas() + " - Valor final: R$"
				+ calcularValorFinal();
	
	}
}
