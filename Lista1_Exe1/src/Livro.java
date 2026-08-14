
public class Livro {
	private String titulo;
	private Autor autor;
	private int anoPublicacao;
	private int nrPagina;
	private Categoria categoria;
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public int getNrPagina() {
		return nrPagina;
	}
	public void setNrPagina(int nrPagina) {
		this.nrPagina = nrPagina;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}

