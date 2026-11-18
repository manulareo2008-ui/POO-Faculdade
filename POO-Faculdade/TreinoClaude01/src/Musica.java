
public class Musica {
	private String titulo;
	private String artista;
	private int duracao;
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getArtista() {
		return artista;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setTitulo(String titulo) {
		if(titulo != null && titulo.length() >= 2) {
			this.titulo = titulo;
		} else {
			System.out.println("Deve conter titulo");
		}
	}
	
	public void setArtista(String artista) {
		if(artista != null && artista.length() >= 2) {
			this.artista = artista;
		} else {
			System.out.println("O artista deve ser preenchido");
		}
	}
	
	public void setDuracao(int duracao) {
		if(duracao > 0) {
			this.duracao = duracao;
		} else {
			System.out.println("A duração deve ser superior a 0 segundos");
		}
	}
}
