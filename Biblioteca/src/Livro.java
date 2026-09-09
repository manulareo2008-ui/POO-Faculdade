
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
		if(codigo <= 0) {
			System.out.println("O código deve ser maior do que 0");
		} else {
			this.codigo = codigo;
		}
	}
	
	public void setTitulo(String titulo) {
		if(titulo == null || titulo.isBlank()) {
			System.out.println("O título deve ser informado");
		} else if(titulo.length() < 3) {
			System.out.println("O título deve ter mais do que 2 caracteres");
		} else {
			this.titulo = titulo;
		}
	}
	
	public String imprimirDados() {
		return getCodigo() + " - " + getTitulo();
	}
}
