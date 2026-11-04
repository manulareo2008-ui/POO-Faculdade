package veterinaria.modelo;

import veterinaria.excecao.CampoVazioException;

public class Cao extends Animal {
	private String porte;

	public Cao(int nrRegistro, String nome, int idade, String porte) {
		super(nrRegistro, nome, idade);
		setPorte(porte);
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) throws CampoVazioException {
		if (porte == null || porte.isBlank()) {
			throw new CampoVazioException("Porte");
		}
		if (!porte.equalsIgnoreCase("pequeno") && !porte.equalsIgnoreCase("médio")
				&& !porte.equalsIgnoreCase("grande")) {
			throw new IllegalArgumentException("Porte deve ser pequeno, médio ou grande");
		}

		this.porte = porte;
	}

	@Override
	public double calcularValorEspecie() {
		if (getPorte().equalsIgnoreCase("grande")) {
			return getValorBase() * 1.3;
		}

		return getValorBase();
	}

	@Override
	public String imprimirDados() {
		return super.imprimirDados() + " - Porte: " + getPorte() + " - Valor final: " + valorFinal();
	}
}
