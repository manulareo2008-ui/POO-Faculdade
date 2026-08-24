import java.util.Scanner;

public class Gerenciador {
	private Scanner leitor;
	private Livro[] livro;
	private Emprestimo[] emprestimo;
	private int qntLivros;
	private int qntEmprestimos;

	public Gerenciador() {
		leitor = new Scanner(System.in);
		livro = new Livro[20];
		emprestimo = new Emprestimo[20];

		String menu = "Escolha uma das opções abaixo: " + "\n1 - cadastrar livro \n2 - registrar empréstimo "
				+ "\n3 - listar livros \n4 - listar empréstimos \n0 - sair";
		int opcao = 0;
		do {
			System.out.println(menu);
			opcao = leitor.nextInt();

			switch (opcao) {
			case 1:
				cadastrarLivro();
				break;

			case 2:
				registrarEmprestimo();
				break;

			case 3:
				listarLivros();
				break;

			case 4:
				listarEmprestimo();
				break;

			case 0:
				break;

			default:
				System.out.println("Opção inexistente");
			}
		} while (opcao != 0);
	}

	public void cadastrarLivro() {

		System.out.println("Qual o titulo do livro: ");
		String titulo = leitor.next();
		System.out.println("Qual o autor do livro: ");
		String autor = leitor.next();
		System.out.println("Qual foi o ano de publicação do livro: ");
		int anoPublicacao = leitor.nextInt();

		Livro l = new Livro();
		l.setTitulo(titulo);
		l.setAutor(autor);
		l.setAnoPublicacao(anoPublicacao);

		livro[qntLivros] = l;
		qntLivros++;
	}

	public void registrarEmprestimo() {

		System.out.println("Qual o nome do aluno que alugou o livro: ");
		String nomeAluno = leitor.next();
		System.out.println("Qual o prazo de entrega: ");
		int prazoDias = leitor.nextInt();
		System.out.println("Escolha um dos livros cadastrados para o empréstimo: ");
		for (int i = 0; i < qntLivros; i++) {
			System.out.println((i + 1) + " - " + livro[i].getTitulo());
		}
		int opcao = leitor.nextInt();

		Emprestimo e = new Emprestimo();
		e.setNomeAluno(nomeAluno);
		e.setPrazoDias(prazoDias);
		e.setLivro(livro[opcao - 1]);

		emprestimo[qntEmprestimos] = e;
		qntEmprestimos++;
	}

	public void listarLivros() {
		for (int i = 0; i < qntLivros; i++) {
			System.out.println((i + 1) + " - " + livro[i].getTitulo() + " (" + livro[i].getAutor() + ")");
		}
	}

	public void listarEmprestimo() {
		for (int i = 0; i < qntEmprestimos; i++) {
			System.out.println("Emprestimo " + (i + 1) + " - Nome do aluno que pegou o livro: "
					+ emprestimo[i].getNomeAluno() + " - Nome do livro: " + emprestimo[i].getLivro().getTitulo()
					+ " - Prazo de entrega (em dias): " + emprestimo[i].getPrazoDias());
		}
	}

	public static void main(String[] args) {
		new Gerenciador();
	}
}
