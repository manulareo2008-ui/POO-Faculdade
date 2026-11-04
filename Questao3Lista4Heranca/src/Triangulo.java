
public class Triangulo extends FormaGeometrica {
	private double lado1;
	private double lado2;
	private double lado3;

	public Triangulo(String cor, double lado1, double lado2, double lado3) {
		super(cor);
		setLado1(lado1);
		setLado2(lado2);
		setLado3(lado3);
	}

	public double getLado1() {
		return lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public double getLado3() {
		return lado3;
	}

	public void setLado1(double lado1) throws MenorIgual0Exception {
		if (lado1 <= 0) {
			throw new MenorIgual0Exception("Lado 1");
		}

		this.lado1 = lado1;
	}

	public void setLado2(double lado2) throws MenorIgual0Exception {
		if (lado2 <= 0) {
			throw new MenorIgual0Exception("Lado 2");
		}

		this.lado2 = lado2;
	}

	public void setLado3(double lado3) throws MenorIgual0Exception {
		if (lado3 <= 0) {
			throw new MenorIgual0Exception("Lado 3");
		}

		this.lado3 = lado3;
	}

	@Override
	public double calcularArea() {
		double s = (getLado1() + getLado2() + getLado3()) / 2;
		double area = s * (s - getLado1()) * (s - getLado2()) * (s - getLado3());
		double areaFinal = Math.sqrt(area);
		return areaFinal;
	}

	@Override
	public double calcularPerimetro() {
		return getLado1() + getLado2() + getLado3();
	}

	@Override
	public String imprimirDados() {
		return super.imprimirDados() + " - Lado 1: " + getLado1() + " - Lado 2: " + getLado2() + " - Lado 3: "
				+ getLado3() + " - Área: " + calcularArea() + " - Perimetro: " + calcularPerimetro();
	}
}
