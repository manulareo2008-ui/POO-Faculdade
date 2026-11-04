import java.util.List;
import java.util.ArrayList;

public class ProgramaDesenho {
	private List<FormaGeometrica> formas;
	
	public ProgramaDesenho() {
		formas = new ArrayList<FormaGeometrica>();
	}
	
	public List<FormaGeometrica> getFormas() {
		return formas;
	}
	
	public void addForma(FormaGeometrica f) throws CampoVazioException {
		if(f == null) {
			throw new CampoVazioException("Forma geométrica");
		}
		
		for(FormaGeometrica forma: formas) {
			if(forma.calcularArea() == f.calcularArea()) {
				if(forma.calcularPerimetro() == f.calcularPerimetro()) {
					if(forma.getCor().equals(f.getCor())) {
						throw new IllegalArgumentException("Forma já cadastrada");
					}
				}
			}
		}
		
		formas.add(f);
	}
	
	public boolean removerForma(FormaGeometrica f) {
		if(f == null) {
			return false;
		}
		
		for(FormaGeometrica forma: formas) {
			if(forma.calcularArea() == f.calcularArea()) {
				if(forma.calcularPerimetro() == f.calcularPerimetro()) {
					if(forma.getCor().equals(f.getCor())) {
						formas.remove(forma);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public double somarAreas() {
		double total = 0;
		for(FormaGeometrica forma: formas) {
			total += forma.calcularArea();
		}
		
		return total;
	}
	
	public double somarPerimetros() {
		double total = 0;
		for(FormaGeometrica forma: formas) {
			total += forma.calcularPerimetro();
		}
		
		return total;
	}
	
	public int totalFormas() {
		return formas.size();
	}
	
	public String imprimirTodosOsDados() {
		String dados = "";
		for(FormaGeometrica forma: formas) {
			dados += forma.imprimirDados() + "\n";
		}
		
		return dados;
	}
}
