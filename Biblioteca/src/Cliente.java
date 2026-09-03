import javax.swing.JOptionPane;

public class Cliente {
	private String nome;
	private int codigo;
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
		if(codigo > 0) {
			this.codigo = codigo;
		} else {
			JOptionPane.showMessageDialog(null, "o código deve ser maior do que 0");
		}
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.isBlank()) {
			this.nome = nome;
		} else {
			JOptionPane.showMessageDialog(null, "O nome deve ser preenchido");
		}
	}
	
	public void setEmail(String email) {
		if(email != null && !email.isBlank()) {
			this.email = email;
		} else {
			JOptionPane.showMessageDialog(null, "O e-mail deve ser preenchido");
		}
	}
}
