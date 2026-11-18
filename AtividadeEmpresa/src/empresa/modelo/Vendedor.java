package empresa.modelo;

import java.util.ArrayList;
import java.util.List;

import empresa.excecao.CampoVazioException;
import empresa.excecao.MenorIgual0Exception;

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

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setPercentualComissao(double percentualComissao) throws MenorIgual0Exception {
		if (percentualComissao <= 0) {
			throw new MenorIgual0Exception("Percentual de comissão");
		}

		this.percentualComissao = percentualComissao;
	}
	
	public void incluirVenda(Venda v) throws CampoVazioException {
		if(v == null) {
			throw new CampoVazioException("Venda");
		}
		for(Venda venda: vendas) {
			if(venda == v) {
				throw new IllegalArgumentException("Venda já cadastrada");
			}
		}
		
		vendas.add(v);
	}
	
	@Override
	public double calcularSalario() {
		double total = getSalarioBase();
		for(Venda v: vendas) {
			total += v.getValor() * (getPercentualComissao() / 100);
		}
		
		return total;
	}
}
