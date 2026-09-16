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
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("O nome deve ser informado");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve ter pelo menos 3 letras");
		}

		this.nome = nome;
	}
	
	public void setCidade(String cidade) throws IllegalArgumentException {
		if (cidade == null || cidade.isEmpty()) {
			throw new IllegalArgumentException("A cidade deve ser informado");
		}
		if (cidade.length() < 3) {
			throw new IllegalArgumentException("A cidade deve ter pelo menos 3 letras");
		}

		this.cidade = cidade;
	}
	
	public void setVoos(List<Voo> voos) throws IllegalArgumentException {
		if(voos == null || voos.isEmpty()) {
			throw new IllegalArgumentException("Os voos devem ser informados");
		}
		
		this.voos = voos;
	}
	
	public void addVoo(Voo voo) throws IllegalArgumentException {
		if(voo == null) {
			throw new IllegalArgumentException("O voo deve ser informado");
		}
		
		voos.add(voo);
	}
	
	public Voo buscarVooPeloNumero(int numero) {
		for(Voo v: voos) {
			if(v.getNumero() == numero) {
				return v;
			}
		}
		
		return null;
	}
	
	public boolean removerVoo(int numero) {
		Voo v = buscarVooPeloNumero(numero);
		if(v == null) {
			return false;
		}
		
		voos.remove(v);
		return true;
	}
}
