
public class Cliente {
	private int codigo;
	private String nome;
	private String email;
	
	public Cliente(int codigo, String nome, String email) {
		setCodigo(codigo);
		setNome(nome);
		setEmail(email);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
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
			System.out.println("O nome deve ser preenchido");
		} else if(nome.length() < 3) {
			System.out.println("O nome deve ter mais do que 2 caracteres");
		} else {
			this.nome = nome;
		}
	}
	
	public void setEmail(String email) {
		if(email == null || email.isBlank()) {
			System.out.println("O e-mail deve ser preenchido");
		} else if(email.length() < 3) {
			System.out.println("O e-mail deve ter no minimo 3 caracteres");
		} else {
			this.email = email;
		}
	}
	
	public String imprimirDados() {
		return getCodigo() + " - " + getNome() + " (" + getEmail() + ")";
	}
}