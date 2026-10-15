package testes;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import banco.ContaBancaria;
import banco.ContaEspecial;
import heranca.Cliente;

class testeObjeto {

	@Test
	void test() {
		assert (true);
		assertEquals("Luciana", "Luciana");
	}

	@Test
	void testarSetCliente() {
		Cliente c1 = new Cliente("João Silva", "Rua 10");
		assertEquals(c1.getNome(), "João Silva");
		assertEquals(c1.getEndereco(), "Rua 10");
	}

	@Test
	void sacarValorNegativoContaBase() {
		ContaBancaria conta = new ContaBancaria("123", new Cliente("Luciana", "Rua XV"), 100);
		conta.sacar(50);
		assertEquals(conta.getSaldo(), 50);
	}

	@Test
	void sacarValorNegativoContaBase1() {
	    ContaBancaria conta = new ContaBancaria("123", new Cliente("Luciana", "Rua XV"), 100);

	    IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {
	        conta.sacar(150);
	    });

	    assertEquals("Valor deve ser menor que o saldo da conta." + "Saldo atual 100.0R$" , excecao.getMessage());
	}
}
