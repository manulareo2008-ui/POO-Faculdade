
public class Retangulo extends FormaGeometrica {
	private double base;
	private double altura;

	public Retangulo(String cor, double base, double altura) {
		super(cor);
		setBase(base);
		setAltura(altura);
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}

	public void setBase(double base) throws MenorIgual0Exception {
		if (base <= 0) {
			throw new MenorIgual0Exception("Base");
		}

		this.base = base;
	}

	public void setAltura(double altura) throws MenorIgual0Exception {
		if (altura <= 0) {
			throw new MenorIgual0Exception("Altura");
		}

		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		return getBase() * getAltura();
	}

	@Override
	public double calcularPerimetro() {
		return (getBase() * 2) + (getAltura() * 2);
	}

	@Override
	public String imprimirDados() {
		return super.imprimirDados() + " - Base: " + getBase() + " - Altura: " + getAltura() + " - Área: "
				+ calcularArea() + " - Perimetro: " + calcularPerimetro();
	}
}
