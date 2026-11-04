
public class Circulo extends FormaGeometrica {
	private double raio;

	public Circulo(String cor, double raio) {
		super(cor);
		setRaio(raio);
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) throws MenorIgual0Exception {
		if(raio <= 0) {
			throw new MenorIgual0Exception("Raio");
		}
		
		this.raio = raio;
	}

	@Override
	public double calcularArea() {
		return Math.PI * (getRaio() * getRaio());
	}

	@Override
	public double calcularPerimetro() {
		return 2 * Math.PI * getRaio();
	}

	@Override
	public String imprimirDados() {
		return super.imprimirDados() + " - Raio: " + getRaio() + "- Área: " + calcularArea() + " - Perimetro: "
				+ calcularPerimetro();
	}
}
