import java.util.List;
import java.util.ArrayList;

public class Locadora {
	private List<Veiculo> veiculos;
	
	public Locadora() {
		veiculos = new ArrayList<Veiculo>();
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public void addVeiculo(Veiculo veiculo) throws CampoVazioException {
		if(veiculo == null) {
			throw new CampoVazioException("Veiculo");
		}
		for(Veiculo v: veiculos) {
			if(v.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
				throw new IllegalArgumentException("Veiculo já cadastrado");
			}
		}
		
		veiculos.add(veiculo);
	}
	
	public boolean removerVeiculo(Veiculo veiculo) {
		if(veiculo == null) {
			return false;
		}
		for(Veiculo v: veiculos) {
			if(v.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
				veiculos.remove(v);
				return true;
			}
		}
		
		return false;
	}
	
	public String imprimirInformacoesVeiculos() {
		String dados = "";
		for(Veiculo v: veiculos) {
			dados += v.imprimirDados() + "\n";
		}
		
		return dados;
	}
	
	public double maiorValorPago() {
		double maior =  0;
		for(Veiculo v: veiculos) {
			if(v.calcularValorFinal() > maior) {
				maior = v.calcularValorFinal();
			}
		}
		
		return maior;
	}
	
	public int totalVeiculos() {
		return veiculos.size();
	}
	
	public double valorTotal() {
		double total = 0;
		for(Veiculo v: veiculos) {
			total += v.calcularValorFinal();
		}
		
		return total;
	}
}
