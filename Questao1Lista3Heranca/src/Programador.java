import java.util.ArrayList;
import java.util.List;

public class Programador extends Funcionario {
	private List<String> linguagens;

	public Programador(String nome, double salarioBase) {
		super(nome, salarioBase);
		linguagens = new ArrayList<String>();
	}
	
	public List<String> getLinguagens() {
		return linguagens;
	}

	@Override
	public double calcularSalario() {
		return getSalarioBase() * 1.2;
	}

	public void incluirLinguagem(String linguagem) throws CampoVazioException {
		if(linguagem == null || linguagem.isBlank()) {
			throw new CampoVazioException("Linguagem");
		}
		
		linguagens.add(linguagem);
	}

	public void removerLinguagem(String linguagem) {
		String encontrada = null;
		for(String l: linguagens) {
			if(l.equalsIgnoreCase(linguagem)) {
				encontrada = l;
				break;
			}
		}
		
		if(encontrada == null) {
			throw new IllegalArgumentException("A linguagem " + linguagem + " não se encontra na lista");
		}
		
		linguagens.remove(encontrada);
	}
}
