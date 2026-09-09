import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimo {
	private Date dataEmprestimo;
	private Cliente cliente;
	private List<Livro> livros;

	public Emprestimo(Cliente cliente) {
		setCliente(cliente);
		setDataEmprestimo(new Date());
		livros = new ArrayList<Livro>();
	}
	
	public void addLivro(Livro livro) {
		if(livro == null) {
			System.out.println("Livro deve ser informado");
		} else {
			livros.add(livro);
		}
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		if(dataEmprestimo == null) {
			System.out.println("A data deve ser preenchida");
		} else {
			this.dataEmprestimo = dataEmprestimo;
		}
	}
	
	public void setCliente(Cliente cliente) {
		if(cliente == null) {
			System.out.println("Cliente deve ser informado");
		} else {
			this.cliente = cliente;
		}
	}
	
	public void setLivros(List<Livro> livros) {
		if(livros == null) {
			System.out.println("Livros não podem ser nulo");
		} else {
			this.livros = livros;
		}
	}
	
	public String imprimirDados() {
		String dados = dataEmprestimo.toString() + "\n";
		dados += cliente.imprimirDados() + "\n";
		
		for(Livro l:livros) {
			dados += l.imprimirDados() + "\n";
		}
		
		return dados;
	}
}
