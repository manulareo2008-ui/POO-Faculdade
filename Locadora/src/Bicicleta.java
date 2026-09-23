
public class Bicicleta {
	private int codigo;
	private String modelo;
	private float valorHora;
	private Cliente cliente;
	
	public Bicicleta(int codigo, String modelo, float valorHora, Cliente cliente) {
		setCodigo(codigo);
		setModelo(modelo);
		setValorHora(valorHora);
		setCliente(cliente);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public float getValorHora() {
		return valorHora;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCodigo(int codigo) throws IllegalArgumentException {
		if(codigo <= 0) {
			throw new IllegalArgumentException("O código deve ser maior do que 0");
		}
		
		this.codigo = codigo;
	}
	
	public void setModelo(String modelo) throws IllegalArgumentException {
		if (modelo == null || modelo.isBlank()) {
			throw new IllegalArgumentException("O modelo deve ser informado");
		}
		if (modelo.length() < 3) {
			throw new IllegalArgumentException("O modelo deve ter pelo menos 3 caracteres");
		}

		this.modelo = modelo;
	}
	
	public void setValorHora(float valorHora) throws IllegalArgumentException {
		if(valorHora <= 0) {
			throw new IllegalArgumentException("O valor cobrado por hora deve ser maior do que 0");
		}
		
		this.valorHora = valorHora;
	}
	
	public void setCliente (Cliente cliente) throws IllegalArgumentException {
		if(cliente == null) {
			throw new IllegalArgumentException("O cliente deve ser informado");
		}
		
		this.cliente  = cliente;
	}
	
	public String imprimirDados() {
		return getCodigo() + " - " + getModelo() + " - " + getValorHora() + " - " + getCliente().getNome();
	}
}
