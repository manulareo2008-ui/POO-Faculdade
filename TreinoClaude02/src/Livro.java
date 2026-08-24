
public class Livro {
	private String titulo;
	private String autor;
	private int anoPublicacao;

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setTitulo(String titulo) {
		if (titulo != null && titulo.length() >= 2) {
			this.titulo = titulo;
		} else {
			System.out.println("O título deve ser preenchido");
		}
	}

	public void setAutor(String autor) {
		if (autor != null && autor.length() >= 2) {
			this.autor = autor;
		} else {
			System.out.println("O autor deve ser preenchido");
		}
	}

	public void setAnoPublicacao(int anoPublicacao) {
		if (anoPublicacao > 0) {
			this.anoPublicacao = anoPublicacao;
		} else {
			System.out.println("O ano de publicação deve ser maior do que 0");
		}
	}
}
