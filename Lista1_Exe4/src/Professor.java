
public class Professor {
	private String nome;
	private String formacao;
	private String telefone;
	private Idioma idiomaEspecializacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Idioma getIdiomaEspecializacao() {
		return idiomaEspecializacao;
	}
	public void setIdiomaEspecializacao(Idioma idiomaEspecializacao) {
		this.idiomaEspecializacao = idiomaEspecializacao;
	}
}
