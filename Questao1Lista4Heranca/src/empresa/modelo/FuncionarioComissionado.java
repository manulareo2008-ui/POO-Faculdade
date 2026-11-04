package empresa.modelo;
import empresa.excecao.MenorIgual0Exception;

public class FuncionarioComissionado extends Funcionario {
	private double salarioBase;
	private double totalVendas;
	private double percentualComissao;

	public FuncionarioComissionado(String nome, String matricula, double salarioBase, double totalVendas,
			double percentualComissao) {
		super(nome, matricula);
		setSalarioBase(salarioBase);
		setTotalVendas(totalVendas);
		setPercentualComissao(percentualComissao);
	}

	public double getSalarioBase() {
		return salarioBase;
	}
	
	public double getTotalVendas() {
		return totalVendas;
	}
	
	public double getPercentualComissao() {
		return percentualComissao;
	}

	public void setSalarioBase(double salarioBase) throws MenorIgual0Exception {
		if(salarioBase <= 0) {
			throw new MenorIgual0Exception("Salario base");
		}
		
		this.salarioBase = salarioBase;
	}

	public void setTotalVendas(double totalVendas) throws IllegalArgumentException {
		if(totalVendas < 0) {
			throw new IllegalArgumentException("Total de vendas deve ser maior ou igual a 0");
		}
		
		this.totalVendas = totalVendas;
	}

	public void setPercentualComissao(double percentualComissao) throws IllegalArgumentException {
		if(percentualComissao < 0) {
			throw new IllegalArgumentException("Percentual de comissão deve ser maior ou igual a 0");
		}
		
		this.percentualComissao = percentualComissao;
	}
	
	@Override
	public double calcularSalario() {
		return getSalarioBase() + (getTotalVendas() * (getPercentualComissao() / 100));
	}
}
