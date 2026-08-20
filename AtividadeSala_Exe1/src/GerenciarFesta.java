import java.util.Date;
import java.util.Scanner;

public class GerenciarFesta {

	private Scanner s;
	private Cliente[] clientes;
	private Tema[] temas;
	private Aluguel[] alugueis;
	private int qtdAtualCliente;
	private int qtdAtualTema;
	private int qtdAtualAluguel;

	public GerenciarFesta() {
		s = new Scanner(System.in);
		
		clientes = new Cliente[20];
		temas = new Tema[20];
		alugueis = new Aluguel[30];

		String menuTexto = "1 - inserir cliente\n" +
				"2 - inserir tema\n" + 
				"3 - inserir aluguel\n" +
				"4 - listar clientes\n" + 
				"5 - listar temas\n" + 
				"6 - listar alugueis\n" + 
				"0 - sair";
		int opcao = 0;
		do {
			System.out.print("Digite: \n" + menuTexto + ":");
			opcao = s.nextInt();

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
				listarAluguel();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida");
			}

		} while (opcao != 0);

	}

	private void listarAluguel() {
		for (int i = 0; i < qtdAtualAluguel; i++) {
			System.out.println(alugueis[i].getHoraInicio() + " - " + alugueis[i].getHoraFim() +
					"\n"+ alugueis[i].getEndereco());
			System.out.println("Cliente: ");
			listarCliente(alugueis[i].getCliente().getNome());
			
			System.out.println("Tema: " + alugueis[i].getTema().getNome());
			System.out.println("Item do tema: " + alugueis[i].getTema().getItens()[0].getNome());
		}
		
	}
	
	
	//Polimorfismo
	//@Overload
	private void listarTema() {
		for (int i = 0; i < qtdAtualTema; i++) {
			listarTema(i);
		}
	}
	//Polimorfismo
    //@Overload
	private void listarTema(int codigo) {
		System.out.println(codigo + " Nome: " + temas[codigo].getNome() + " - R$" + 
				temas[codigo].getValorAluguel() + "\nToalha: " + 
				temas[codigo].getCorToalha());
		
		for (int j = 0; j < temas[codigo].getItens().length; j++) {
			
			Item item = temas[codigo].getItens()[j];
			if (item != null) {
				System.out.println(item.getNome() + "  " + item.getQtd());
			}
			
			
		}
		System.out.println();
	}

	private void listarCliente() {
		for (int i = 0; i < qtdAtualCliente; i++) {
			listarCliente(i);
			System.out.println();
		}
		
	}

	private void listarCliente(int codigo) {
		System.out.println(codigo + " Nome: " + clientes[codigo].getNome() + " - " + 
				clientes[codigo].getTelefone() + "\nData de cadastro: " + 
				clientes[codigo].getDataPrimeiraCompra().toString());
	}
	
	private void listarCliente(String nome) {
		for (int codigo = 0; codigo < qtdAtualCliente; codigo++) {
			Cliente c1 = clientes[codigo];
			if (c1 != null && c1.getNome().equals(nome)) {
				System.out.println(codigo + " Nome: " + clientes[codigo].getNome() + " - " + 
						clientes[codigo].getTelefone() + "\nData de cadastro: " + 
						clientes[codigo].getDataPrimeiraCompra().toString());
				return;
			}
		}
	}
	
	private void inserirAluguel() {
		System.out.print("Hora inicio: ");
		int hraInicio = s.nextInt();
		
		System.out.print("Hora fim: ");
		int hraFim = s.nextInt();
		
		System.out.print("Endereço: ");
		String endereco = s.next();
		
		System.out.println("Escolha um cliente da lista: ");
		listarCliente();
		int indiceCliente = s.nextInt();
		
		int indiceTema = 0;
		do {
			System.out.println("Escolha um tema da lista: ");
			listarTema();
			indiceTema = s.nextInt();
		} while (indiceTema < 0 && indiceTema > qtdAtualTema);
		
		Aluguel a = new Aluguel();
		a.setHoraInicio(hraInicio);
		a.setHoraFim(hraFim);
		a.setEndereco(endereco);
		a.setCliente(clientes[indiceCliente]);
		a.setTema(temas[indiceTema]);
		
		alugueis[qtdAtualAluguel] = a;
		qtdAtualAluguel++;
	}

	private void inserirTema() {
		Item[] itens = new Item[20];
		int qtItem = 0;
		
 		System.out.print("Você deseja inserir um item? S - Sim, N - Não");
		char resposta = s.next().toLowerCase().charAt(0);
		
		while (resposta == 's') {
			System.out.print("Digite o nome do item: ");
			String nome = s.next();
			System.out.print("Digite a quantidade do item: ");
			int qtd = s.nextInt();

			Item i = new Item();
			i.setNome(nome);
			i.setQtd(qtd);

			itens[qtItem] = i;
			qtItem++;

			System.out.print("Você deseja inserir um item? S - Sim, N - Não");
			resposta = s.next().toLowerCase().charAt(0);
		}
		
		Tema t = new Tema();
		System.out.print("Nome do tema: ");
		String nome = s.next();
		System.out.print("Valor do aluguel do tema: ");
		float valor = s.nextFloat();
		System.out.print("Cor da toalha do tema: ");
		String cor = s.next();
		
		t.setItens(itens);
		t.setNome(nome);
		t.setValorAluguel(valor);
		t.setCorToalha(cor);
		
		temas[qtdAtualTema] = t;
		qtdAtualTema++;
	}

	private void inserirCliente() {
		s = new Scanner(System.in);
		
		System.out.print("Digite o nome do cliente: ");
		String nome = s.next();
		System.out.print("Digite o telefone do cliente: ");
		String telefone = s.next();
		
		Cliente c1 = new Cliente();
		c1.setNome(nome);
		c1.setTelefone(telefone);
		c1.setDataPrimeiraCompra(new Date()); //pega a data de hoje - data do cadastro
		
		clientes[qtdAtualCliente] = c1;
		qtdAtualCliente++;
		
	}

	public static void main(String[] args) {
		new GerenciarFesta();
	}
}