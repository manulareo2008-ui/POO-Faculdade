import java.util.Scanner;
import java.util.Date;

public class Sistema {

	private Scanner leitor;
	private Cliente[] clientes;
	private Tema[] temas;
	private Aluguel[] alugueis;
	private int qntAtualCiente;
	private int qntAtualTema;
	private int qntAtualAluguel;

	public Sistema() {
		leitor = new Scanner(System.in);
		clientes = new Cliente[20];
		temas = new Tema[20];
		alugueis = new Aluguel[30];

		String menuTexto = "1 - Inserir um cliente\n" + "2 - inserir um tema\n" + "3 - inserir aluguel\n"
				+ "4 - listar cliente\n" + "5 - listar tema\n" + "6 - listar alugueis\n" + "0 - sair";

		int opcao = 0;

		do {
			System.out.println("Digite: \n" + menuTexto + ": ");
			opcao = leitor.nextInt();

			switch (opcao) {
			case 1:
				inserirCliente();
				break;
			case 2:
				inserirTema();
				break;

			case 3:
				inserirAluguel();
				break;

			case 4:
				listarCliente();
				break;

			case 5:
				listarTema();
				break;

			case 6:
				listarAlugueis();
				break;

			case 0:
				break;

			default:
				System.out.println("Opção invalida");
			}
		} while (opcao != 0);
	}

	private void listarAlugueis() {

	}

	private void listarTema() {

	}

	private void listarCliente() {

		for (int i = 0; i < qntAtualCiente; i++) {
			System.out.println("Nome: " + clientes[i].getNome() + " - " + clientes[i].getTelefone()
					+ "\nData de cadastro: " + clientes[i].getDataPrimeira().toString());
		}
	}

	private void inserirAluguel() {
		leitor = new Scanner(System.in);
		
		System.out.println("Qual o nome do cliente: ");
		String cliente = leitor.next();
		System.out.println("Qual o endereço: ");
		String endereco = leitor.next();
		System.out.println("Qual o tema: ");
		String tema = leitor.next();
		System.out.println("Qual a data: ");
		Date dataAluguel = new Date();
		System.out.println("Qual a hora inicial: ");
		int horaInicial = leitor.nextInt();
		System.out.println("Qual a hora final: ");
		int horaFinal = leitor.nextInt();
		
		Aluguel a1 = new Aluguel();

		a1.setEndereco(endereco);
        a1.setData(dataAluguel);
        a1.setHoraInicio(horaInicial);
        a1.setHoraFim(horaFinal);
        
        alugueis[qntAtualAluguel] = a1;
        qntAtualAluguel++;
        
        System.out.println("Aluguel cadastrado com sucesso!");
	}

	private void inserirTema() {

	}

	private void inserirCliente() {
		leitor = new Scanner(System.in);
		
		System.out.println("Digite o nome do cliente: ");
		String nome = leitor.next();
		System.out.println("Digite o telefone do cliente: ");
		String telefone = leitor.next();

		Cliente c1 = new Cliente();
		c1.setNome(nome);
		c1.setTelefone(telefone);
		c1.setDataPrimeira(new Date());

		clientes[qntAtualCiente] = c1;
		qntAtualCiente++;
	}

	public static void main(String[] args) {
		new Sistema();
	}
}

