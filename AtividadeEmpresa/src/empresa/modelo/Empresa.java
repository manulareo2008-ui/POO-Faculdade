package empresa.modelo;
import java.util.List;
import java.util.ArrayList;

import empresa.excecao.CampoVazioException;

public class Empresa {
	private String nome;
	private List<Funcionario> funcionarios;
	
	public Empresa(String nome) {
		setNome(nome);
		funcionarios = new ArrayList<Funcionario>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void setNome(String nome) throws CampoVazioException {
		if(nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		if(nome.length() < 3) {
			throw new IllegalArgumentException("Nome deve ter, pelo menos, 3 caracteres");
		}
		
		this.nome = nome;
	}
	
	public void incluirFuncionario(Funcionario f) throws CampoVazioException {
		if(f == null) {
			throw new CampoVazioException("Funcionario");
		}
		for(Funcionario funcionario: funcionarios) {
			if(funcionario == f) {
				throw new IllegalArgumentException("Funcionario já cadastrado");
			}
		}
		
		funcionarios.add(f);
	}
	
	public void removerFuncionario(Funcionario f) throws CampoVazioException{
		if(f == null) {
			throw new CampoVazioException("Funcionario");
		}
		boolean encontrado = false;
		Funcionario esperado = null;
		for(Funcionario funcionario: funcionarios) {
			if(funcionario == f) {
				encontrado = true;
				esperado = funcionario;
			}
		}
		
		if(encontrado) {
			funcionarios.remove(esperado);
		} else {
			throw new IllegalArgumentException("Funcionario não cadastrado");
		}
	}
	
	public double calcularCustosSalarios() {
		double total = 0;
		for(Funcionario f: funcionarios) {
			total += f.calcularSalario();
		}
		
		return total;
	}
}
