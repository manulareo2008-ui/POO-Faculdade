package empresa.modelo;
import java.util.List;

import empresa.excecao.CampoVazioException;

import java.util.ArrayList;

public class ListaFuncionarios {
	private List<Funcionario> funcionarios;
	
	public ListaFuncionarios() {
		funcionarios = new ArrayList<Funcionario>();;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) throws CampoVazioException {
		if(funcionarios.isEmpty()) {
			throw new CampoVazioException("Funcionario");
		}
		
		this.funcionarios = funcionarios;
	}
	
	public void addFuncionario(Funcionario funcionario) throws IllegalArgumentException {
		if(funcionario == null) {
			throw new IllegalArgumentException("Funcionario deve ser preenchido");
		}
		
		for(Funcionario f: funcionarios) {
			if(f.getMatricula().equalsIgnoreCase(funcionario.getMatricula())) {
				throw new IllegalArgumentException("Funcionario já cadastrado");
			}
		}
		
		funcionarios.add(funcionario);
	}
	
	public boolean removerFuncionario(Funcionario funcionario) {
		if(funcionario == null) {
			return false;
		}
		
		for(Funcionario f: funcionarios) {
			if(f.getMatricula().equalsIgnoreCase(funcionario.getMatricula())) {
				funcionarios.remove(f);
				return true;
			}
		}
		
		return false;
	}
	
	public String imprimirDadosESalarios() {
		String dados = "";
		for(Funcionario f: funcionarios) {
			dados += f.imprimirDados() + " - Salario final: R$" + f.calcularSalario() + "\n";
		}
		
		return dados;
	}
	
	public double totalFolhaPagamentos() {
		double total = 0;
		for(Funcionario f: funcionarios) {
			total += f.calcularSalario();
		}
		
		return total;
	}
}
