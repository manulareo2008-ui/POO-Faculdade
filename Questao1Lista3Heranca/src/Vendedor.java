import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario {
	private double percentualComissao;
	private List<Venda> vendas;

	public Vendedor(String nome, double salarioBase, double percentualComissao) {
		super(nome, salarioBase);
		setPercentualComissao(percentualComissao);
		vendas = new ArrayList<Venda>();
	}

	public double getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(double percentualComissao) throws MenorIgual0Exception {
		if (percentualComissao <= 0) {
			throw new MenorIgual0Exception("Percentual de comissão");
		}
		
		this.percentualComissao = percentualComissao;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void incluirVenda(Venda v) {
		if(v == null) {
			throw new IllegalArgumentException("Venda deve ser informada");
		}

		vendas.add(v);
	}

	@Override
	public double calcularSalario() {
		double totalVendas = 0;
		for(Venda v: vendas) {
			totalVendas += v.getValor();
		}
		
		return getSalarioBase() + totalVendas * percentualComissao / 100;
	}
}
