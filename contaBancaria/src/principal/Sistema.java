package principal;

import javax.swing.JOptionPane;

import banco.ContaEspecial;
import heranca.Cliente;

public class Sistema {

	public Sistema() {

		Cliente cliente = new Cliente("João Silva", "Rua 10");

		try {

			ContaEspecial conta1 = new ContaEspecial("001", cliente, 100.0);
			conta1.depositar(20);
			conta1.sacar(50);
			JOptionPane.showMessageDialog(null, "Caso 1 - Saldo: " + conta1.getSaldo());

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		try {
			ContaEspecial conta2 = new ContaEspecial("002", cliente, 100);
			conta2.depositar(20);
			conta2.sacar(120);
			JOptionPane.showMessageDialog(null, conta2.getSaldo());

		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		try {

			ContaEspecial conta3 = new ContaEspecial("003", cliente, 100);
			conta3.depositar(20);
			conta3.sacar(120.01);
			JOptionPane.showMessageDialog(null, conta3.getSaldo());

		} catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Sistema();
	}
}
