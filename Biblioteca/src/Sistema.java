import javax.swing.JOptionPane;

public class Sistema {
	
	public Sistema() {
		
	Cliente c1 = new Cliente(1, "Manuel", "manu@.com");
	
	Livro l1 = new Livro(10, "Coimbra linda");
	
    Emprestimo emprestimo = new Emprestimo(c1);

    JOptionPane.showMessageDialog(null, emprestimo.imprimirDados());
    	
	emprestimo.addLivro(l1);
	
	JOptionPane.showMessageDialog(null, emprestimo.imprimirDados());
	}
	
	public static void main(String[] args) {
		new Sistema();
	}
}