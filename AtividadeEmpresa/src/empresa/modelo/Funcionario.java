package empresa.modelo;

import empresa.excecao.CampoVazioException;
import empresa.excecao.MenorIgual0Exception;

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

	public void setNome(String nome) throws CampoVazioException {
		if (nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("Nome deve ter, pelo menos, 3 caracteres");
		}

		this.nome = nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) throws MenorIgual0Exception {
		if (salarioBase <= 0) {
			throw new MenorIgual0Exception("Salario base");
		}
		
		this.salarioBase = salarioBase;
	}

	public abstract double calcularSalario();
}
