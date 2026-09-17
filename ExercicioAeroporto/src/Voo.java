
public class Voo {
	private int numero;
	private String destino;
	private int qntPassageiros;
	private String horarioPrevisto;
	private Aeronave aeronave;
	
	public Voo(Aeronave aeronave, int numero, String destino, int qntPassageiros, String horarioPrevisto) {
		setAeronave(aeronave);
		setNumero(numero);
		setDestino(destino);
		setQntPassageiros(qntPassageiros);
		setHorarioPrevisto(horarioPrevisto);
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public int getQntPassageiros() {
		return qntPassageiros;
	}
	
	public String getHorarioPrevisto() {
		return horarioPrevisto;
	}
	
	public Aeronave getAeronave() {
		return aeronave;
	}
	
	public void setNumero(int numero) throws IllegalArgumentException {
		if(numero <= 0) {
			throw new IllegalArgumentException("O número deve ser maior do que 0");
		}
		
		this.numero = numero;
	}
	
	public void setDestino(String destino) throws IllegalArgumentException {
		if(destino == null || destino.isBlank()) {
			throw new IllegalArgumentException("O destino deve ser informado");
		}
		if(destino.length() < 3) {
			throw new IllegalArgumentException("O destino deve ter pelo menos 3 letras");
		}
		
		this.destino = destino;
	}
	
	public void setQntPassageiros(int qntPassageiros) throws IllegalArgumentException {
		if(qntPassageiros < 0 || qntPassageiros > aeronave.getCapacidadeMaxima()) {
			throw new IllegalArgumentException("O número de passageiros da aeronave não pode ser menor do que 0 e nem maior do que o número máximo permitido");
		}
		
		this.qntPassageiros = qntPassageiros;
	}
	
	public void setHorarioPrevisto(String horarioPrevisto) throws IllegalArgumentException {
		if(horarioPrevisto == null || horarioPrevisto.isBlank()) {
			throw new IllegalArgumentException("O horario previsto deve ser informado");
		}
		
		this.horarioPrevisto = horarioPrevisto;
	}
	
	public void setAeronave(Aeronave aeronave) {
		if(aeronave == null) {
			throw new IllegalArgumentException("A aeronave deve ser informada");
		}
		
		this.aeronave = aeronave;
	}
	
	public String imprimirDados() {
		return getNumero() + " - " + getDestino() + " - " + getQntPassageiros() + " - "  + getHorarioPrevisto() + " - " + getAeronave().getModelo();		
	}
}
