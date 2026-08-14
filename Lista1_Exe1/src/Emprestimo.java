
public class Emprestimo {
	private String dtRetirada;
	private String dtPrevista;
	private String situacao;
	private Livro livro;
	private Leitor leitor;
	
	public String getDtRetirada() {
		return dtRetirada;
	}
	public void setDtRetirada(String dtRetirada) {
		this.dtRetirada = dtRetirada;
	}
	
	public String getDtPrevista() {
		return dtPrevista;
	}
	public void setDtPrevista(String dtPrevista) {
		this.dtPrevista = dtPrevista;
	}
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Leitor getLeitor() {
		return leitor;
	}
	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}
}
