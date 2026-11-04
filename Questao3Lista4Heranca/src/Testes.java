import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testes {

	@Test
	void testarCirculo() {
		Circulo circulo = new Circulo("Amarelo", 5);
		assertEquals(circulo.getCor(), "Amarelo");
		assertEquals(circulo.getRaio(), 5);
		assertEquals(circulo.calcularArea(), 78.54, 0.01);
		assertEquals(circulo.calcularPerimetro(), 31.415, 0.01);
	}

	@Test
	void testarRetangulo() {
		Retangulo retangulo = new Retangulo("Verde", 10, 5);
		assertEquals(retangulo.getCor(), "Verde");
		assertEquals(retangulo.getAltura(), 5);
		assertEquals(retangulo.getBase(), 10);
		assertEquals(retangulo.calcularArea(), 50);
		assertEquals(retangulo.calcularPerimetro(), 30);
	}
	
	@Test
	void testarTriangulo() {
		Triangulo triangulo = new Triangulo("Preto", 3, 4, 5);
		assertEquals(triangulo.calcularArea(), 6);
		assertEquals(triangulo.calcularPerimetro(), 12);
	}
	
	
}
