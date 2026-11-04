
public abstract class FormaGeometrica {
	private String cor;
	
	public FormaGeometrica(String cor) {
		setCor(cor);
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) throws CampoVazioException {
		if(cor == null || cor.isBlank()) {
			throw new CampoVazioException("Cor");
		}
		if(cor.length() < 4) {
			throw new IllegalArgumentException("Cor deve ter, pelo menos, 4 caracteres");
		}
		
		this.cor = cor;
	}
	
	public abstract double calcularArea();
	
	public abstract double calcularPerimetro();
	
	public String exibirCor() {
		return "Cor: " + getCor();
	}
	
	public String imprimirDados() {
		return exibirCor();
	}
}
