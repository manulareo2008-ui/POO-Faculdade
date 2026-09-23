public class Veiculo {
	private String placa;
	private String modelo; 
	private String nomeProprietario;
	
	public Veiculo(String placa, String modelo, String nomeProprietario) {
		setPlaca(placa);
		setModelo(modelo);
		setNomeProprietario(nomeProprietario);
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	
	public void setPlaca(String placa) throws IllegalArgumentException {
		if(placa == null || placa.isBlank()) {
			throw new IllegalArgumentException("A placa deve ser informada");
		}
		if(placa.length() < 3) {
			throw new IllegalArgumentException("A placa deve conter pelo menos 3 caracteres");
		}
		
		this.placa = placa;
	}
	
	public void setModelo(String modelo) throws IllegalArgumentException {
		if(modelo == null || modelo.isBlank()) {
			throw new IllegalArgumentException("O modelo deve ser informado");
		}
		if(modelo.length() < 3) {
			throw new IllegalArgumentException("O modelo deve conter pelo menos 3 caracteres");
		}
		
		this.modelo = modelo;
	}
	
	public void setNomeProprietario(String nomeProprietario) throws IllegalArgumentException {
		if(nomeProprietario == null || nomeProprietario.isBlank()) {
			throw new IllegalArgumentException("O nome do proprietario deve ser informado");
		}
		if(nomeProprietario.length() < 3) {
			throw new IllegalArgumentException("O nome do proprietario deve conter pelo menos 3 caracteres");
		}
		
		this.nomeProprietario = nomeProprietario;
	}
	
	public String imprimirDados() {
		return getPlaca() + " - " + getModelo() + " - " + getNomeProprietario();
	}
}