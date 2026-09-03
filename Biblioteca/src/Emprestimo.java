import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class Emprestimo {

	private Cliente cliente;
	private Date data;
	private List<Livro> listaLivros;

	public Emprestimo(Cliente cliente) {
		setCliente(cliente);
		setData(new Date());
		listaLivros = new ArrayList<Livro>();
	}
	
	public void addLivro(Livro livro) {
		if (livro != null) {
			listaLivros.add(livro);
		} else {
			System.out.println("O livro deve ser informado");
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Date getData() {
		return data;
	}

	public List<Livro> getListaLivros() {
		return listaLivros;
	}

	public void setCliente(Cliente cliente) {
		if (cliente != null) {
			this.cliente = cliente;
		} else {
			System.out.println("O cliente deve ser preenchido");
		}
	}

	public void setData(Date data) {
		if (data != null) {
			this.data = data;
		} else {
			JOptionPane.showMessageDialog(null, "A data deve ser preenchida");
		}
	}

	public String imprimirEmprestimo() {
		return getCodigo() + " - " + getNome() + 
	} 
	
	public String imprimirDados() {
		String dados = data.toString() + "\n";
		dados += cliente.imprimirDados() = "\n";
		
		for(Livro l:listaLivros) {
			dados += l.imprimirDados() = "\n";
		}
	}
}
