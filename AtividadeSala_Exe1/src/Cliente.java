import java.util.Date;

public class Cliente {
	private String nome;
	private String telefone;
	private Date dataPrimeira;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty() && nome.length() >= 3) {
			this.nome = nome;
		} else {
			System.out.println("O nome deve ser preenchido");
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone != null && !telefone.isEmpty() && telefone.length() >= 8) {
			this.telefone = telefone;
		} else {
			System.out.println("O telefone deve ser preenchido");
		}
	}

	public Date getDataPrimeira() {
		return dataPrimeira;
	}

	public void setDataPrimeira(Date DataPrimeira) {
		if(dataPrimeira != null) {
			this.dataPrimeira = dataPrimeira;
		} else {
			System.out.println("A data de cadastro do cliente deve ser preenchida");
		}
	}
}
