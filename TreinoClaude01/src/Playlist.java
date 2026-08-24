
public class Playlist {
	private String nome;
	private Musica[] colecaoMusicas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null && nome.length() >= 3) {
			this.nome = nome;
		} else {
			System.out.println("Nome invalido");
		}
	}
	
	public Musica[] getColecaoMusicas () {
		return colecaoMusicas;
	}
	public void setColecaoMusicas(Musica[] colecaoMusicas) {
		this.colecaoMusicas = colecaoMusicas;
	}
}
