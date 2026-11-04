
public abstract class Funcionario {
	private String nome;
	private double salarioBase;
	
	public Funcionario(String nome, double salarioBase) {
		setNome(nome);
		setSalarioBase(salarioBase);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		if(nome.length() < 3) {
			throw new IllegalArgumentException("Nome deve ter, pelo menos, 3 caracteres");
		}
		
		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		if(salarioBase <= 0) {
			throw new MenorIgual0Exception("Salário base");
		}
		
		this.salarioBase = salarioBase;
	}
	
	public abstract double calcularSalario();
}
