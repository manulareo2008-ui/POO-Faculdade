
public class Aeronave {
	private int codigo;
	private String modelo;
	private int capacidadeMaxima;

	public Aeronave(int codigo, String modelo, int capacidadeMaxima) {
		setCodigo(codigo);
		setModelo(modelo);
		setCapacidadeMaxima(capacidadeMaxima);
	}

	public int getCodigo() {
		return codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCodigo(int codigo) throws IllegalArgumentException {
		if (codigo <= 0) {
			throw new IllegalArgumentException("O código deve ser maior do que 0");
		}

		this.codigo = codigo;
	}

	public void setModelo(String modelo) throws IllegalArgumentException {
		if (modelo == null || modelo.isBlank()) {
			throw new IllegalArgumentException("O modelo deve ser informado");
		}
		if (modelo.length() < 3) {
			throw new IllegalArgumentException("O modelo deve ter pelo menos 3 letras");
		}

		this.modelo = modelo;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) throws IllegalArgumentException {
		if (capacidadeMaxima <= 0) {
			throw new IllegalArgumentException("A capacidade máxima deve ser superior a 0");
		}

		this.capacidadeMaxima = capacidadeMaxima;
	}

	public String imprimirDados() {
		return getCodigo() + " - " + getModelo() + " - " + getCapacidadeMaxima();
	}
}
