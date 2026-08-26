
public class Cliente {
	private String telefone;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setNome(String nome) {
		if(nome != null && nome.length() >= 3) {
			this.nome = nome;
		} else {
			System.out.println("O nome deve ser preenchido");
		}
	}
	
	public void setTelefone(String telefone) {
		if(telefone != null && telefone.length() >= 8) {
			this.telefone = telefone;
		} else {
			System.out.println("O telefone deve ser preenchido");
		}
	}
}
