
public class Dono {
	private String nome;
	private String telefone;
	
	public Dono(String nome, String telefone) {
		setNome(nome);
		setTelefone(telefone);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setNome(String nome) {
		if(nome == null || nome.isBlank()) {
			System.out.println("O nome do dono deve ser informado");
		} else if(nome.length() < 3) {
			System.out.println("O nome deve ter pelo menos 3 caracteres");
		} else {
			this.nome = nome;
		}
	}
	
	public void setTelefone(String telefone) {
		if(telefone == null || telefone.isBlank()) {
			System.out.println("O telefone do dono deve ser informado");
		} else if(telefone.length() < 11) {
			System.out.println("O telefone deve ter pelo menos 11 caracteres");
		} else {
			this.telefone = telefone;
		}
	}
	
	public String imprimirDados() {
		return getNome() + " - " + getTelefone();
	}
}