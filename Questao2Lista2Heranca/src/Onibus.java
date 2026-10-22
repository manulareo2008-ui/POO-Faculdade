
public class Onibus extends Veiculo{
	private int nrPassageiros;
	
	public Onibus(String placa, double capTanque, double consumo, int nrPassageiros) {
		super(placa, capTanque, consumo);
		setNrPassageiros(nrPassageiros);
	}

	public int getNrPassageiros() {
		return nrPassageiros;
	}

	public void setNrPassageiros(int nrPassageiros) {
		if(nrPassageiros < 0) {
			throw new ValorMenorZeroException("Numero de passageiros");
		}
		if(nrPassageiros >= 200) {
			throw new IllegalArgumentException("O número de passageiros deve ser menor que 200");
		}
		this.nrPassageiros = nrPassageiros;
	}

	@Override
	public double eficiencia() {
	    int faixas = nrPassageiros / 10;
	    double eficiencia = 1;
	    eficiencia -= faixas * 0.05;
	    return eficiencia;
	}
}
