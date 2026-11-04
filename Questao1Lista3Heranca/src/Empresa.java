import java.util.ArrayList;
import java.util.List;

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

	public void setNome(String nome) {
		if (nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve ter, pelo menos, 3 caracteres");
		}
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void incluirFuncionario(Funcionario f) throws IllegalArgumentException {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getNome().equalsIgnoreCase(f.getNome())) {
				throw new IllegalArgumentException("Esse funcionario já esta na lista");
			}
		}

		funcionarios.add(f);
	}

	public void removerFuncionario(Funcionario f) {
		if(!funcionarios.remove(f)) {
			throw new IllegalArgumentException("Funcionario não existente");
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
