
public class Carro extends Veiculo {
	private boolean arCondicionado;
	
	public Carro(String placa, double capTanque, double consumo, boolean arCondicionado) {
		super(placa, capTanque, consumo);
		setArCondicionado(arCondicionado);
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	@Override
	public double eficiencia() {
		double eficiencia = 1;
		if(arCondicionado) {
			eficiencia -= 0.1;
		}
		return eficiencia;
	}
}
