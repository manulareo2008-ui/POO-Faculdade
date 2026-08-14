public class Sistema {
	public static void main(String[] args) {
		
		Categoria categoria = new Categoria();
		categoria.setNome("Terror");
		categoria.setDescricao("Um livro inesqucivel");
		
		Leitor leitor = new Leitor();
		leitor.setNome("Manuel Lareo");
		leitor.setCpf("111.222.333.45");
		leitor.setTelefone("99999-9999");
		leitor.setEmail("messi@gmail.com");
		
		Autor autor = new Autor();
		autor.setNome("Vianna");
		autor.setCpf("777.777.777-89");
		
		Livro livro = new Livro();
		livro.setTitulo("The last Dance");
		livro.setAnoPublicacao(2000);
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		livro.setNrPagina(500);
		
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDtPrevista("30-12-2026");
		emprestimo.setDtRetirada("25-12-2026");
		emprestimo.setLeitor(leitor);
		emprestimo.setLivro(livro);
		emprestimo.setSituacao("Alugado");
		
		System.out.println("Nome do leitor: " + emprestimo.getLeitor().getNome());
		System.out.println("CPF do autor: " + emprestimo.getLivro().getAutor().getCpf());
		System.out.println("Descrição do livro: " + emprestimo.getLivro().getCategoria().getDescricao());
		System.out.println("Ano de publicação: " + emprestimo.getLivro().getAnoPublicacao());
	}
}
