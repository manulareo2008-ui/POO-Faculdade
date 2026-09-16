
public class Animal {
	private String nome;
	private String especie;
	private Dono dono;
	private float[] pesos;
	private int pesoAtual;

	public Animal(String nome, String especie, Dono dono) {
		setDono(dono);
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

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome do animal deve ser informado");
		}
		
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome do animal deve ter pelo menos 3 caracteres");
		} 
		
		this.nome = nome;
	}

	public void setEspecie(String especie) throws IllegalArgumentException {
		if (especie == null || especie.isBlank()) {
			throw new IllegalArgumentException("A especie do animal deve ser informada");
		} 
		
		if (especie.length() < 3) {
			throw new IllegalArgumentException("A especie deve ter pelo menos 3 caracteres");
		}
		
		this.especie = especie;
	}

	public void setDono(Dono dono) throws IllegalArgumentException {
		if (dono == null) {
			throw new IllegalArgumentException("O dono deve ser informado");
		}
		
		this.dono = dono;
	}

	public void setPesos(float[] pesos) throws IllegalArgumentException {
		if(pesos == null || pesos.length != 3) {
			throw new IllegalArgumentException("Devem ser informados os 3 pesos");
		}
		
		for(float p: pesos) {
			if(p <= 0) {
				throw new IllegalArgumentException("O peso deve ser superior a 0");
			}
		}
		
		for(int i = 0; i < pesos.length; i++) {
			this.pesos[i] = pesos[i];
		}
		pesoAtual = 3;
	}
	
	public void addPeso(float peso) throws IllegalArgumentException{
		if(pesoAtual >= pesos.length) {
			throw new IllegalArgumentException("O animal já possui os 3 pesos regitrados");
		}
		
		if(peso <= 0) {
			throw new IllegalArgumentException("O peso informado deve ser superior a 0");
		}
		
		pesos[pesoAtual] = peso;
		pesoAtual++;
	}
	
	public float calcularMediaPeso() {
		if(pesoAtual != pesos.length) {
			throw new IllegalArgumentException("O animal deve ter 3 pesos preenchidos");
		}
		
		float soma = 0;
		for(int i = 0; i < pesos.length; i++) {
			soma += pesos[i];
		}
		
		return soma / pesos.length;
	}
	
	public String imprimirDados() {
		String dados = getNome() + " - " + getEspecie() + " - Dono: " + getDono().getNome();
		
		if(pesos.length == pesoAtual) {
			dados += " - Média: " + calcularMediaPeso();
		} else {
			dados += " - Média: pesos ainda não informados"; 
		}
		
		return dados;
	}
}
