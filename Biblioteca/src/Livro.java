import javax.swing.JOptionPane;

public class Livro {
	private int codigo;
	private String titulo;
	
	public Livro(int codigo, String titulo) {
		setCodigo(codigo);
		setTitulo(titulo);
	}
	
	public int getCodigo() {
		return codigo;
	} 
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
		} else {
			JOptionPane.showMessageDialog(null,  "O código deve ser maior do que 0");
		}
	}
	
	public void setTitulo(String titulo) {
		if(titulo != null && !titulo.isBlank()) {
			this.titulo = titulo;
		} else {
			JOptionPane.showMessageDialog(null,  "O títilo deve ser preenchido");
		}
	}
}
