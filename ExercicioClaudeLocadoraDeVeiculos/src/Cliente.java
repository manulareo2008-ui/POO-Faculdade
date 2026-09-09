
public class Cliente {
	private int codigo;
	private String nome;
	private String cpf;
	
	public Cliente(int codigo, String nome, String cpf) {
		setCodigo(codigo);
		setNome(nome);
		setCpf(cpf);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCodigo(int codigo) {
		if(codigo <= 0) {
			System.out.println("O código deve ser maior do que 0");
		} else {
			this.codigo = codigo;
		}
	}
	
	public void setNome(String nome) {
		if(nome == null || nome.isBlank()) {
			System.out.println("O nome deve ser informado");
		} else if(nome.length() < 3) {
			System.out.println("O nome deve ter pelo menos 3 caracteres");
		} else {
			this.nome = nome;
		}
	}
	
	public void setCpf(String cpf) {
		if(cpf == null || cpf.isBlank()) {
			System.out.println("O CPF deve ser informado");
		} else if(cpf.length() != 14) {
			System.out.println("CPF incompleto, deve possuir os 14 caracteres (incluindo os pontos e o traço)");
		} else {
			this.cpf = cpf;
		}
	}
	
	public String imprimirDados() {
		return getCodigo() + " - " + getNome() + " - " + getCpf();
	}
}
