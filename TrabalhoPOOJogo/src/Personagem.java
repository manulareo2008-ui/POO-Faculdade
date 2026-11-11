
public abstract class Personagem {
	private String nome;
	private double vidaMaxima;
	private double vida;
	private double defesa;
	private int alcanceMaximo;

	public Personagem(String nome, double vidaMaxima, double vida, double defesa, int alcanceMaximo) {
		setNome(nome);
		setVidaMaxima(vidaMaxima);
		setVida(vida);
		setDefesa(defesa);
		setAlcanceMaximo(alcanceMaximo);
	}

	public double getVidaMaxima() {
		return vidaMaxima;
	}

	public String getNome() {
		return nome;
	}

	public double getVida() {
		return vida;
	}

	public double getDefesa() {
		return defesa;
	}

	public int getAlcanceMaximo() {
		return alcanceMaximo;
	}


	private void setVidaMaxima(double vidaMaxima) throws MenorIgual0Exception {
		if (vidaMaxima <= 0) {
			throw new MenorIgual0Exception("Vida máxima");
		}

		this.vidaMaxima = vidaMaxima;
	}

	private void setNome(String nome) throws CampoVazioException {
		if (nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}

		if (nome.length() < 2) {
			throw new IllegalArgumentException("Nome deve ter, pelo menos, duas letras");
		}

		this.nome = nome;
	}

	private void setVida(double vida) throws MenorIgual0Exception {
		if (vida <= 0) {
			throw new MenorIgual0Exception("Vida inicial");
		}
		if(vida > vidaMaxima) {
			throw new IllegalArgumentException("Vida não pode ser maior do que a vida máxima");
		}
		this.vida = vida;
	}

	private void setDefesa(double defesa) throws MenorIgual0Exception {
		if (defesa <= 0) {
			throw new MenorIgual0Exception("Defesa");
		}
		this.defesa = defesa;
	}

	private void setAlcanceMaximo(int alcanceMaximo) throws MenorIgual0Exception {
		if (alcanceMaximo <= 0) {
			throw new MenorIgual0Exception("Alcance máximo");
		}

		this.alcanceMaximo = alcanceMaximo;
	}
	
	public abstract double calcularDano(int distancia);
}
