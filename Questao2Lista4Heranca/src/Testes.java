import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testes {

	@Test
	void testarCadastroCarro() {
		Carro carro = new Carro("00001", "Fiat", 100, 5, 4);
		assertEquals(carro.calcularValorBase(), 500);
		assertEquals(carro.calcularValorFinal(), 550);
	}

	@Test
	void testarCadastroMoto() {
		Moto moto = new Moto("00002", "Braba", 200, 10, false);
		assertEquals(moto.getModelo(), "Braba");
		assertEquals(moto.calcularValorFinal(), 1800);
	}

	@Test
	void testarCadastroCaminhao() {
		Caminhao caminhao = new Caminhao("00003", "Giga", 500, 5, 3);
		assertEquals(caminhao.calcularValorFinal(), 2800);
	}

	@Test
	void testarLocadora() {
		Locadora locadora = new Locadora();

		Moto moto = new Moto("00002", "Braba", 200, 10, false);
		Carro carro = new Carro("00001", "Fiat", 100, 5, 4);
		Caminhao caminhao = new Caminhao("00003", "Giga", 500, 5, 3);

		locadora.addVeiculo(moto);
		locadora.addVeiculo(carro);
		locadora.addVeiculo(caminhao);

		assertEquals(locadora.totalVeiculos(), 3);
		assertEquals(locadora.getVeiculos().size(), 3);
		assertEquals(locadora.valorTotal(), 5150);
		assertEquals(locadora.imprimirInformacoesVeiculos(),
				"Placa: 00002 - Modelo: Braba - Valor diaria: R$200.0 - Total dias: 10 - Possui cilindradas: "
			  + "Não - Valor final: R$1800.0\nPlaca: 00001 - Modelo: Fiat - Valor diaria: R$100.0 - Total dias: "
			  + "5 - Quantidade de portas: 4 - Valor final: R$550.0\nPlaca: 00003 - Modelo: Giga - Valor diaria: R$500.0 - Total dias: 5 - "
			  + "Capacidade toneladas: 3.0 - Valor final: R$2800.0\n");
	}
}
