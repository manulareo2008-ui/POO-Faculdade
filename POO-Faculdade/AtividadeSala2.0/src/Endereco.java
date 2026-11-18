
public class Endereco {
	private String rua;
	private String CEP;
	private int numero;
	private String estado;

	public String getRua() {
		return rua;
	}

	public String getCEP() {
		return CEP;
	}

	public int getNumero() {
		return numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setRua(String rua) {
		if(rua != null & rua.length() >= 3) {
			this.rua = rua;
		} else {
			System.out.println("A rua deve ser preenchida");
		}
	}
	
	public void setCEP(String CEP) {
		if(CEP != null & CEP.length() >= 3) {
			this.CEP = CEP;
		} else {
			System.out.println("O CEP deve ser preenchida");
		}
	}
	
	public void setNumero(int numero) {
		if(numero > 0) {
			this.numero = numero;
		} else {
			System.out.println("O CEP deve ser preenchida");
		}
	}
	
	public void setEstado(String estado) {
		if(estado != null & estado.length() >= 2) {
			this.estado = estado;
		} else {
			System.out.println("O estado deve ser preenchida");
		}
	}
}
