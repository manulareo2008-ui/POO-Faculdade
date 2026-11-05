package fazenda.testes;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import fazenda.modelo.Plantacao;
import fazenda.modelo.PlantioMelancia;
import fazenda.modelo.PlantioMorango;

class Teste {

	@Test
	void testandoClasses() {
		Plantacao sitio = new Plantacao("Sítio Primavera");
		PlantioMorango morango = new PlantioMorango("Albion", 100, 0.8);
		PlantioMelancia melancia = new PlantioMelancia("Crimson Sweet", 20, 2, 5);
		
		sitio.adicionarPlantio(morango);
		sitio.adicionarPlantio(melancia);
		
		assertEquals(sitio.callcularProducaoTotal(), 280.0);
		JOptionPane.showMessageDialog(null, "Produção total estimada: " + sitio.callcularProducaoTotal());
	}

}
