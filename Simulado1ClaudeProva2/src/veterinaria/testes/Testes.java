package veterinaria.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import veterinaria.excecao.CampoVazioException;
import veterinaria.excecao.MenorIgual0Exception;
import veterinaria.modelo.Ave;
import veterinaria.modelo.Cao;
import veterinaria.modelo.Clinica;
import veterinaria.modelo.Gato;
import veterinaria.modelo.Tutor;

// assertEquals(ESPERADO, REAL): assim a mensagem de falha mostra os valores no lugar certo.
class Testes {

	@Test
	void testarCao() {
		Cao cao = new Cao(1, "Rex", 5, "grande");
		assertEquals(1, cao.getNrRegistro());
		assertEquals("Rex", cao.getNome());
		assertEquals(5, cao.getIdade());
		assertEquals("grande", cao.getPorte());
		assertEquals(156, cao.valorFinal(), 0.01); // 120 + 30%

		cao.setPorte("PEQUENO"); // maiúsculas e minúsculas são aceitas
		assertEquals(120, cao.valorFinal(), 0.01);

		cao.setPorte("médio");
		assertEquals(120, cao.valorFinal(), 0.01);

		assertEquals("Número de registro: 1 - Nome: Rex - Idade: 5 - Porte: médio - Valor final: 120.0",
				cao.imprimirDados());

		assertThrows(IllegalArgumentException.class, () -> cao.setPorte("gigante"));
		assertThrows(CampoVazioException.class, () -> cao.setPorte(" "));
		assertThrows(CampoVazioException.class, () -> cao.setPorte(null));
	}

	@Test
	void testarGato() {
		Gato gato = new Gato(2, "Mia", 3, false);
		assertEquals(145, gato.valorFinal(), 0.01); // 120 + 25 (não castrado)
		assertEquals("Número de registro: 2 - Nome: Mia - Idade: 3 - Castrado: Não - Valor final: 145.0",
				gato.imprimirDados());

		gato.setCastrado(true);
		assertEquals(120, gato.valorFinal(), 0.01);
		assertEquals("Número de registro: 2 - Nome: Mia - Idade: 3 - Castrado: Sim - Valor final: 120.0",
				gato.imprimirDados());
	}

	@Test
	void testarAve() {
		Ave ave = new Ave(3, "Loro", 2, true);
		assertEquals(240, ave.valorFinal(), 0.01); // dobro do valor base
		assertEquals("Número de registro: 3 - Nome: Loro - Idade: 2 - Silvestre: Sim - Valor final: 240.0",
				ave.imprimirDados());

		ave.setSilvestre(false);
		assertEquals(120, ave.valorFinal(), 0.01);
	}

	@Test
	void testarAdicionalIdade() {
		// Limite: 10 anos NÃO tem adicional; 11 anos tem.
		assertEquals(156, new Cao(1, "Rex", 10, "grande").valorFinal(), 0.01);
		assertEquals(196, new Cao(1, "Rex", 11, "grande").valorFinal(), 0.01); // 156 + 40

		assertEquals(185, new Gato(2, "Mia", 11, false).valorFinal(), 0.01); // 145 + 40
		assertEquals(280, new Ave(3, "Loro", 15, true).valorFinal(), 0.01); // 240 + 40

		// Chamar duas vezes não pode mudar o valor
		Cao idoso = new Cao(4, "Thor", 12, "pequeno");
		assertEquals(160, idoso.valorFinal(), 0.01);
		assertEquals(160, idoso.valorFinal(), 0.01);
	}

	@Test
	void testarValidacoesAnimal() {
		assertThrows(MenorIgual0Exception.class, () -> new Gato(0, "Mia", 2, true));
		assertThrows(CampoVazioException.class, () -> new Gato(1, "", 2, true));
		assertThrows(CampoVazioException.class, () -> new Gato(1, null, 2, true));
		assertThrows(IllegalArgumentException.class, () -> new Gato(1, "Mia", -1, true));

		Gato filhote = new Gato(1, "Lu", 0, true); // filhote de 0 anos e nome curto são válidos
		assertEquals(0, filhote.getIdade());
		assertEquals("Lu", filhote.getNome());
	}

	@Test
	void testarTutor() {
		Tutor tutor = new Tutor("Manuel", "996558432");
		Cao cao = new Cao(1, "Rex", 12, "grande"); // 196
		Gato gato = new Gato(2, "Mia", 3, false); // 145
		Ave ave = new Ave(3, "Loro", 2, true); // 240

		tutor.addAnimal(cao);
		tutor.addAnimal(gato);
		tutor.addAnimal(ave);

		assertEquals("Manuel", tutor.getNome());
		assertEquals("996558432", tutor.getTelefone());
		assertEquals(3, tutor.getAnimais().size());
		assertEquals(581, tutor.valorTotalTutor(), 0.01);

		assertTrue(tutor.removerAnimal(cao));
		assertFalse(tutor.removerAnimal(cao)); // já foi removido
		assertFalse(tutor.removerAnimal(null));
		assertEquals(2, tutor.getAnimais().size());
		assertEquals(385, tutor.valorTotalTutor(), 0.01);

		assertEquals("Nome: Manuel - Telefone: 996558432 - Total animais: 2\n"
				+ "Lista de animais do tutor e seus respectivos dados:\n"
				+ "Número de registro: 2 - Nome: Mia - Idade: 3 - Castrado: Não - Valor final: 145.0\n"
				+ "Número de registro: 3 - Nome: Loro - Idade: 2 - Silvestre: Sim - Valor final: 240.0\n",
				tutor.imprimirDadosTutor());
	}

	@Test
	void testarRegrasTutor() {
		Tutor tutor = new Tutor("Manuel", "996558432");
		tutor.addAnimal(new Gato(1, "Mia", 2, true));
		tutor.addAnimal(new Gato(2, "Tom", 2, true));
		tutor.addAnimal(new Gato(3, "Zoe", 2, true));

		// registro repetido (mesmo número, outro animal)
		assertThrows(IllegalArgumentException.class, () -> tutor.addAnimal(new Cao(1, "Rex", 3, "pequeno")));

		tutor.addAnimal(new Gato(4, "Bia", 2, true)); // 4º animal: aceito
		assertEquals(4, tutor.getAnimais().size());

		// 5º animal: recusado
		assertThrows(IllegalArgumentException.class, () -> tutor.addAnimal(new Gato(5, "Ana", 2, true)));
		assertThrows(CampoVazioException.class, () -> tutor.addAnimal(null));

		assertThrows(CampoVazioException.class, () -> new Tutor(" ", "996558432"));
		assertThrows(IllegalArgumentException.class, () -> new Tutor("Manuel", "1234"));
	}

	@Test
	void testarClinica() {
		Clinica clinica = new Clinica();

		// Clínica vazia
		assertEquals(0, clinica.faturamentoPrevisto(), 0.01);
		assertEquals(0, clinica.totalAnimaisCadastrados());
		assertEquals("", clinica.listarAnimais10Anos());
		assertThrows(IllegalArgumentException.class, () -> clinica.tutorDeMaiorValor());

		Tutor manuel = new Tutor("Manuel", "996558432");
		manuel.addAnimal(new Cao(1, "Rex", 12, "grande")); // 196
		manuel.addAnimal(new Gato(2, "Mia", 3, false)); // 145
		manuel.addAnimal(new Ave(3, "Loro", 2, true)); // 240 -> total 581

		Tutor joana = new Tutor("Joana", "988887777");
		joana.addAnimal(new Gato(10, "Tom", 11, true)); // 120 + 40 = 160
		joana.addAnimal(new Cao(11, "Bob", 4, "pequeno")); // 120 -> total 280

		clinica.addTutor(manuel);
		clinica.addTutor(joana);

		assertEquals(2, clinica.getTutores().size());
		assertEquals(861, clinica.faturamentoPrevisto(), 0.01); // 581 + 280
		assertEquals(manuel, clinica.tutorDeMaiorValor());
		assertEquals(5, clinica.totalAnimaisCadastrados());
		assertEquals("Número de registro: 1 - Nome: Rex - Idade: 12 - Porte: grande - Valor final: 196.0\n"
				+ "Número de registro: 10 - Nome: Tom - Idade: 11 - Castrado: Sim - Valor final: 160.0\n",
				clinica.listarAnimais10Anos());

		assertThrows(IllegalArgumentException.class, () -> clinica.addTutor(manuel)); // mesmo tutor 2x
		assertThrows(CampoVazioException.class, () -> clinica.addTutor(null));

		assertTrue(clinica.removerTutor(manuel));
		assertFalse(clinica.removerTutor(manuel));
		assertEquals(280, clinica.faturamentoPrevisto(), 0.01);
		assertEquals(joana, clinica.tutorDeMaiorValor());
		assertEquals(2, clinica.totalAnimaisCadastrados());
	}
}
