package empresa.modelo;
import empresa.excecao.MenorIgual0Exception;

public class FuncionarioFixo extends Funcionario {
	private double salarioBase;

	public FuncionarioFixo(String nome, String matricula, double salarioBase) {
		super(nome, matricula);
		setSalarioBase(salarioBase);
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

	@Override
	public double calcularSalario() {
		return getSalarioBase();
	}
}
