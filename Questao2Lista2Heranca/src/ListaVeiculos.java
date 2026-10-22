import java.util.ArrayList;
import java.util.List;

public class ListaVeiculos {
	private List<Veiculo> veiculos;

	public ListaVeiculos() {
		veiculos = new ArrayList<Veiculo>();
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void addVeiculo(Veiculo veiculo) {
		if (veiculo == null) {
			throw new IllegalArgumentException("O veículo deve ser informado");
		}
		for (Veiculo v : veiculos) {
			if (v.getPlaca().equals(veiculo.getPlaca())) {
				throw new IllegalArgumentException("Esse veículo já está na lista");
			}
		}

		veiculos.add(veiculo);
	}

	public Veiculo maisEconomico(double qntKm, double precoLitro) {
		if (veiculos.isEmpty()) {
			return null;
		}

		Veiculo maisEconomico = veiculos.get(0);
		for (Veiculo v : veiculos) {
			if (maisEconomico.custoTotal(qntKm, precoLitro) > v.custoTotal(qntKm, precoLitro)) {
				maisEconomico = v;
			}
		}

		return maisEconomico;
	}
	
	public double custoTotalGeral(double qntKm, double precoLitro) {
		double total = 0;
		for(Veiculo v: veiculos) {
			total += v.custoTotal(qntKm, precoLitro);
		}
		
		return total;
 	}
	
	public String imprimirDados(double qntKm, double precoLitro) {
	    if (veiculos.isEmpty()) {
	        return "Nenhum veículo cadastrado.";
	    }
	    String dados = "Informações da lista de veículos: \n";
	    for (Veiculo v : veiculos) {
	        dados += "Placa: " + v.getPlaca()
	               + " - Custo: R$ " + v.custoTotal(qntKm, precoLitro)
	               + " - Eficiência: " + (v.eficiencia() * 100) + "%\n";
	    }
	    dados += "Custo total: R$ " + custoTotalGeral(qntKm, precoLitro) + "\n";
	    return dados;
	}
}













