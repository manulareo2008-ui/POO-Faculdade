package empresa.teste;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import empresa.modelo.FuncionarioComissionado;
import empresa.modelo.FuncionarioFixo;
import empresa.modelo.FuncionarioHorista;
import empresa.modelo.ListaFuncionarios;


class Testes {

	@Test
	void testarFuncionarioFixo() {
		FuncionarioFixo fx1 = new FuncionarioFixo("Manuel", "Matricula1", 1000);
		assertEquals(fx1.calcularSalario(), 1000);
		assertEquals(fx1.imprimirDados(), "Nome: Manuel - Matricula: Matricula1");
	}

	@Test
	void testarFuncionarioHorista() {
		FuncionarioHorista fh1 = new FuncionarioHorista("Manuel", "Matricula1", 100, 40);
		assertEquals(fh1.calcularSalario(), 4000);
		assertEquals(fh1.imprimirDados(), "Nome: Manuel - Matricula: Matricula1");
	}

	@Test
	void testarFuncionarioComissionado() {
		FuncionarioComissionado fc1 = new FuncionarioComissionado("Manuel", "Matricula1", 2000, 10000, 20);
		assertEquals(fc1.calcularSalario(), 4000);
		assertEquals(fc1.imprimirDados(), "Nome: Manuel - Matricula: Matricula1");
	}

	@Test
	void testarListaFuncionarios() {
		ListaFuncionarios lista = new ListaFuncionarios();

		FuncionarioComissionado fc1 = new FuncionarioComissionado("Manuel", "Matricula1", 2000, 10000, 20);
		FuncionarioHorista fh1 = new FuncionarioHorista("João", "Matricula2", 100, 40);
		FuncionarioFixo fx1 = new FuncionarioFixo("Gabriel", "Matricula3", 1000);

		lista.addFuncionario(fc1);
		lista.addFuncionario(fh1);
		lista.addFuncionario(fx1);

		assertEquals(lista.getFuncionarios().size(), 3);
		assertEquals(lista.imprimirDadosESalarios(),
				"Nome: Manuel - Matricula: Matricula1 - Salario final: R$4000.0\n"
						+ "Nome: João - Matricula: Matricula2 - Salario final: R$4000.0\n"
						+ "Nome: Gabriel - Matricula: Matricula3 - Salario final: R$1000.0\n");
		assertEquals(lista.totalFolhaPagamentos(), 9000);
		
		lista.removerFuncionario(fx1);
		lista.removerFuncionario(fx1);
		lista.removerFuncionario(null);
		
		assertEquals(lista.getFuncionarios().size(), 2);
		assertEquals(lista.totalFolhaPagamentos(), 8000);
	}
}