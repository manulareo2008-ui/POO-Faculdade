import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
	private int codigo;
	private String nome;
	private String cidade;
	private List<Voo> voos;

	public Aeroporto(int codigo, String nome, String cidade) {
		setCodigo(codigo);
		setNome(nome);
		setCidade(cidade);
		voos = new ArrayList<Voo>();
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCodigo(int codigo) throws IllegalArgumentException {
		if (codigo <= 0) {
			throw new IllegalArgumentException("O código deve ser maior do que 0");
		}
		this.codigo = codigo;
	}

	public void setNome(String nome) throws IllegalArgumentException {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome deve ser informado");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve ter pelo menos 3 letras");
		}
		this.nome = nome;
	}

	public void setCidade(String cidade) throws IllegalArgumentException {
		if (cidade == null || cidade.isBlank()) {
			throw new IllegalArgumentException("A cidade deve ser informada");
		}
		if (cidade.length() < 3) {
			throw new IllegalArgumentException("A cidade deve ter pelo menos 3 letras");
		}
		this.cidade = cidade;
	}


	public void addVoo(Voo voo) throws IllegalArgumentException {
		if (voo == null) {
			throw new IllegalArgumentException("O voo deve ser informado");
		}
		for (Voo v : voos) {
			if (v.getNumero() == voo.getNumero()) {
				throw new IllegalArgumentException("Já existe um voo com o número " + voo.getNumero());
			}
		}
		voos.add(voo);   
	}

	public Voo buscarVooPeloNumero(int numero) throws IllegalArgumentException {
		for (Voo v : voos) {
			if (v.getNumero() == numero) {
				return v;
			}
		}
		throw new IllegalArgumentException("Voo " + numero + " não cadastrado"); 
	}

	public void removerVoo(int numero) throws IllegalArgumentException {
		Voo v = buscarVooPeloNumero(numero);   
		voos.remove(v);
	}
 
	public String listarVoos() {
		String dados = "";
		for (Voo v : voos) {
			dados += v.imprimirDados() + "\n";
		}
		return dados;
	}
}