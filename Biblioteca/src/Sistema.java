import javax.swing.JOptionPane;

public class Sistema {

	public Sistema() {
		
		String nomeCliente1 = JOptionPane.showInputDialog("Qual o nome do primeiro cliente: ");
		String codigoCliente1 = JOptionPane.showInputDialog("Qual o código do " + nomeCliente1 + ": ");
		int codigo1 = Integer.parseInt(codigoCliente1);
		String emailCliente1 = JOptionPane.showInputDialog("Qual o e-mail do " + nomeCliente1 + ": ");
		
		Cliente c1 = new Cliente(codigo1, nomeCliente1, emailCliente1);
				
		String tituloLivro1 = JOptionPane.showInputDialog("Qual o título do livro 1: ");
		String codigoLivro1 = JOptionPane.showInputDialog("Qual o código do livro " + tituloLivro1 + ": ");
		int intCodigo1 = Integer.parseInt(codigoLivro1);
		
		Livro l1 = new Livro(intCodigo1, tituloLivro1);
		
		Emprestimo emprestimo = new Emprestimo(c1);
		
		JOptionPane.showConfirmDialog(null,  emprestimo.imprimirDados());
	}

	public static void main(String[] args) {
		new Sistema();
	}
}