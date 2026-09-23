import java.util.List;
import java.util.ArrayList;

public class Oficina {
	private String nome;
	private String endereco;
	private String telefone;
	private List<Servico> servicos;

	public Oficina(String nome, String endereco, String telefone) {
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
		servicos = new ArrayList<Servico>();
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome deve ser informado");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve ter pelo menos 3 caracteres");
		}

		this.nome = nome;
	}

	public void setEndereco(String endereco) throws IllegalArgumentException {
		if (endereco == null || endereco.isBlank()) {
			throw new IllegalArgumentException("O endereco deve ser informado");
		}
		if (endereco.length() < 3) {
			throw new IllegalArgumentException("O endereco deve ter pelo menos 3 caracteres");
		}

		this.endereco = endereco;
	}

	public void setTelefone(String telefone) throws IllegalArgumentException {
		if (telefone == null || telefone.isBlank()) {
			throw new IllegalArgumentException("O telefone deve ser informado");
		}
		if (telefone.length() != 11) {
			throw new IllegalArgumentException("O telefone deve ter 11 caracteres");
		}

		this.telefone = telefone;
	}

	public void setServicos(List<Servico> servicos) throws IllegalArgumentException {
		if (servicos == null | servicos.isEmpty()) {
			throw new IllegalArgumentException("A lista deve ter serviços cadastrados");
		}

		this.servicos = servicos;
	}

	public String imprimirDados() {
		String dados = getNome() + " - " + getEndereco() + " - " + getTelefone() + "\nLista de serviços:\n";
		for (Servico s : servicos) {
			dados += s.imprimirDados() + "\n";
		}

		return dados;
	}

	public Servico buscarServico(int numero) {
		for (Servico s : servicos) {
			if (s.getNumero() == numero) {
				return s;
			}
		}

		return null;
	}

	public void addServico(Servico servico) {
		if (servico != null) {
			servicos.add(servico);
		}
	}

	public boolean localizarServico(int numero) {
		if (servicos == null || servicos.isEmpty()) {
			throw new IllegalArgumentException(
					"A lista de serviços deve ter pelo menos 1 serviço para poder localizar-lo");
		}
		for (Servico s : servicos) {
			if (s.getNumero() == numero) {
				return true;
			}
		}

		return false;
	}

	public boolean removerServico(int numero) {
		Servico a = buscarServico(numero);
		if (a == null) {
			return false;
		}

		servicos.remove(a);
		return true;
	}

	public String listarServicos() {
		String lista = "";
		for (Servico s : servicos) {
			lista += s.imprimirDados() + "\n";
		}

		return lista;
	}

	public float valorTotalArrecadado() {
		float total = 0;
		for (Servico s : servicos) {
			total += s.getValor();
		}

		return total;
	}

	public Servico servicoComMaiorValorCobrado() {
		Servico maior = servicos.get(0);
		for (Servico s : servicos) {
			if (s.getValor() > maior.getValor()) {
				maior = s;
			}
		}

		return maior;
	}

	public int servicosEmDeterminadoVeiculo(String placa) {
		if (servicos == null || servicos.isEmpty()) {
			throw new IllegalArgumentException(
					"A lista de serviços deve ter pelo menos 1 serviço para poder informar a quantidade");
		}
		int total = 0;
		for (Servico s : servicos) {
			if (s.getVeiculo().getPlaca().equals(placa)) {
				total++;
			}
		}

		return total;
	}

	public int servicosComValorMaiorDoQueOInformado(float valor) throws IllegalArgumentException {
		if (servicos == null || servicos.isEmpty()) {
			throw new IllegalArgumentException(
					"A lista de serviços deve ter pelo menos 1 serviço para poder informar a quantidade");
		}
		int total = 0;
		for (Servico s : servicos) {
			if (s.getValor() > valor) {
				total++;
			}
		}

		return total;
	}
}