package veterinaria.modelo;

public class Gato extends Animal {
	private boolean castrado;

	public Gato(int nrRegistro, String nome, int idade, boolean castrado) {
		super(nrRegistro, nome, idade);
		setCastrado(castrado);
	}

	public boolean isCastrado() {
		return castrado;
	}

	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}

	@Override
	public double calcularValorEspecie() {
		if (!isCastrado()) {
			return getValorBase() + 25;
		}

		return getValorBase();
	}

	@Override
	public String imprimirDados() {
		if (isCastrado()) {
			return super.imprimirDados() + " - Castrado: Sim - Valor final: " + valorFinal();
		}

		return super.imprimirDados() + " - Castrado: Não - Valor final: " + valorFinal();
	}
}
