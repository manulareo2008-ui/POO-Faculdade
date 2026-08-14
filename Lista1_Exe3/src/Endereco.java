
public class Endereco {
	private String rua;
	private String cep;
	private String bairro;
	private UF uf;
	private int numero;
	
	public String getrua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public UF getUF() {
		return uf;
	}
	public void setUF(UF uf) {
		this.uf = uf;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
