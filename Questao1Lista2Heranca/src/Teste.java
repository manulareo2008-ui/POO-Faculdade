import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void testarProduto() {
		//Para que este teste funcione, teria que ser removido o abstract da classe Produto
		/*Produto p = new Produto("Nome", 20, 4);
		assertEquals(p.getNome(), "Nome");
		assertEquals(p.getPreco(), 20);
		assertEquals(p.getMesesGarantia(), 4);
		*/
	}

	@Test
	void testarSmartphone() {
		Smartphone s = new Smartphone(1000, 4, 250, true);
		assertEquals(s.getNome(), "Smartphone");
		assertEquals(s.getPreco(), 1000);
		assertEquals(s.getMesesGarantia(), 4);
		assertEquals(s.getArmazenamento(), 250);
		assertTrue(s.isBanda5G());

		s.setArmazenamento(256);
		assertEquals(s.getMesesGarantia(), 7);
		assertEquals(s.desconto(), 50);
		assertEquals(s.precoComDesconto(), 950);
	}

	@Test
	void testarNotebook() {
		Notebook n = new Notebook("Notebook", 5000, 3, 10, false);
		assertEquals(n.getNome(), "Notebook");
		assertEquals(n.getPreco(), 5000);
		assertEquals(n.getMesesGarantia(), 3);
		assertEquals(n.getRam(), 10);
		assertFalse(n.isSsd());

		n.setRam(16);
		n.setSsd(true);
		assertEquals(n.desconto(), 400);
		assertEquals(n.getMesesGarantia(), 9);
		assertEquals(n.precoComDesconto(), 4600);
	}

	@Test
	void testarCampanha() {
		Notebook n1 = new Notebook("Notebook", 3000, 3, 16, false);
		Notebook n2 = new Notebook("Notebook", 1000, 2, 8, true);
		Smartphone s1 = new Smartphone(500, 1, 256, true);

		Campanha campanha = new Campanha();
		campanha.addProduto(n1);
		campanha.addProduto(n2);
		campanha.addProduto(s1);

		assertEquals(campanha.precoTotal(), 4395);

		String texto = "Notebook\nR$3000.0 - Garantia: 9\nNotebook\nR$920.0 - Garantia: 2\nSmartphone\n" + "R$475.0 - Garantia: 4\n";
		assertEquals(campanha.imprimir(), texto);
	}
}
