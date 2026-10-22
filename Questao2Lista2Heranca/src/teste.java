import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class teste {

	@Test
	void test() {
		Carro c1 = new Carro("1", 100, 10, true);
		Carro c2 = new Carro("2", 150, 15, true);
		Onibus o1 = new Onibus("3", 200, 5, 50);
		ListaVeiculos l1 = new ListaVeiculos();
		l1.addVeiculo(c1);
		l1.addVeiculo(c2);
		l1.addVeiculo(o1);
		assertEquals(l1.maisEconomico(100, 200), c2);
		assertEquals(l1.custoTotalGeral(100, 100), 4518,518518);
	}

}
