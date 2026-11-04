package veterinaria.modelo;

public class Ave extends Animal {
	private boolean silvestre;

	public Ave(int nrRegistro, String nome, int idade, boolean silvestre) {
		super(nrRegistro, nome, idade);
		setSilvestre(silvestre);
	}

	public boolean isSilvestre() {
		return silvestre;
	}

	public void setSilvestre(boolean silvestre) {
		this.silvestre = silvestre;
	}

	@Override
	public double calcularValorEspecie() {
		if (isSilvestre()) {
			return getValorBase() * 2;
		}

		return getValorBase();
	}

	@Override
	public String imprimirDados() {
		if (isSilvestre()) {
			return super.imprimirDados() + " - Silvestre: Sim - Valor final: " + valorFinal();
		}

		return super.imprimirDados() + " - Silvestre: Não - Valor final: " + valorFinal();
	}
}
