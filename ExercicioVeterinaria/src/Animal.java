
public class Animal {
	private String nome;
	private String especie;
	private Dono dono;
	private float[] pesos;
	private int pesoAtual;

	public Animal(String nome, String especie) {
		setNome(nome);
		setEspecie(especie);
		pesos = new float[3];
	}

	public String getNome() {
		return nome;
	}

	public String getEspecie() {
		return especie;

	}

	public Dono getDono() {
		return dono;

	}

	public float[] getPesos() {
		return pesos;
	}

	public void setNome(String nome) {
		if (nome == null || nome.isBlank()) {
			System.out.println("O nome do dono deve ser informado");
		} else if (nome.length() < 3) {
			System.out.println("O nome deve ter pelo menos 3 caracteres");
		} else {
			this.nome = nome;
		}
	}

	public void setEspecie(String especie) {
		if (especie == null || especie.isBlank()) {
			System.out.println("A especie do animal deve ser informado");
		} else if (especie.length() < 3) {
			System.out.println("A especie deve ter pelo menos 3 caracteres");
		} else {
			this.especie = especie;
		}
	}

	public void setDono(Dono dono) {
		if (dono == null) {
			System.out.println("O dono deve ser informado");
		} else {
			this.dono = dono;
		}
	}

	
}
