package fazenda.modelo;

import java.util.ArrayList;
import java.util.List;

import fazenda.excessoes.CampoVazioException;

public class Plantacao {
	private String nome;
	private List<Plantio> plantios;

	public Plantacao(String nome) {
		setNome(nome);
		plantios = new ArrayList<Plantio>();
	}

	public String getNome() {
		return nome;
	}

	public List<Plantio> getPlantios() {
		return plantios;
	}

	public void setNome(String nome) throws CampoVazioException {
		if (nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		if (nome.length() < 3) {
			throw new IllegalArgumentException("Nome deve ter, pelo menos, 3 letras");
		}

		this.nome = nome;
	}

	public void adicionarPlantio(Plantio plantio) throws CampoVazioException {
		if (plantio == null) {
			throw new CampoVazioException("Plantio");
		}
		for (Plantio p : plantios) {
			if (p == plantio) {
				throw new IllegalArgumentException("Plantio já presente na lista");
			}
		}

		plantios.add(plantio);
	}

	public double callcularProducaoTotal() {
		if (plantios.isEmpty()) {
			return 0;
		}
		double total = 0;
		for (Plantio p : plantios) {
			total += p.calcularProducao();
		}

		return total;
	}
}
