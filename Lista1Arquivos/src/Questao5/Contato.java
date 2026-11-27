package Questao5;

public class Contato {

	private int codigo;
	private String nome;
	private String telefone;
	
	public Contato(int codigo, String nome, String telefone) throws MenorIgual0Exception, CampoVazioException {
		setCodigo(codigo);
		setNome(nome);
		setTelefone(telefone);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) throws MenorIgual0Exception {
		if(codigo <= 0) {
			throw new MenorIgual0Exception("Código");
		}
		
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws CampoVazioException {
		if(nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		
		if(nome.contains(";")) {
			throw new IllegalArgumentException("Nome não pode conter ;");
		}
		
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws CampoVazioException {
		if(telefone == null || telefone.isBlank()) {
			throw new CampoVazioException("Telefone");
		}
		
		if(telefone.contains(";")) {
			throw new IllegalArgumentException("Telefone não pode conter ;");
		}
		this.telefone = telefone;
	}
	
	public String imprimirDados() {
		return "Código: " + getCodigo() + " - Nome: " + getNome() + " - Telefone: " + getTelefone(); 
	}
	
	public String umaLinha() {
		return codigo + ";" + nome + ";" + telefone;
	}
}
