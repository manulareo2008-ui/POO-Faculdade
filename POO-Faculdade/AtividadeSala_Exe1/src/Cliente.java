import java.util.Date;

public class Cliente {

	private String nome;
	private Date dataPrimeiraCompra;
	private String telefone;

	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty() && nome.length() >= 3) {
			this.nome = nome;
		} else {
			System.out.println("Nome deve ser preenchido");
			//TODO mudar posteriormente para exceção
		}
	}

	public void setTelefone(String telefone) {
		if (telefone != null && !telefone.isEmpty()) {
			this.telefone = telefone;
		} else {
			System.out.println("Telefone deve ser preenchido");
		}
	}

	//REVER ESSE MÉTODO:
	public void setDataPrimeiraCompra(Date dataPrimeiraCompra) {
		if (dataPrimeiraCompra != null) {
			this.dataPrimeiraCompra = dataPrimeiraCompra;
		} else {
			System.out.println("Data deve ser preenchido");
		}
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public Date getDataPrimeiraCompra() {
		return dataPrimeiraCompra;
		//TODO verificar se o método será assim
	}
}
