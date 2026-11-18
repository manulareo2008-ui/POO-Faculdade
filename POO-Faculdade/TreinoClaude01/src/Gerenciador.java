import java.util.Scanner;

public class Gerenciador {

	private Scanner leitor;
	private Musica[] musica;
	private Playlist[] playlist;
	private int qntMusicas;
	private int qntPlaylists;

	public Gerenciador() {
		leitor = new Scanner(System.in);
		musica = new Musica[20];
		playlist = new Playlist[20];

		String menu = "\n 1 - Cadastrar música\n 2 - cadastrar playlist\n 3 - listar músicas\n 4 - listar playlists\n 5 - listar musicas da playlist\n 0 - sair";
		int opcao = 0;

		do {
			System.out.print("Escolha uma das opções: " + menu + ": ");
			opcao = leitor.nextInt();

			switch (opcao) {
			case 1:
				cadastrarMusica();
				break;

			case 2:
				cadastrarPlaylist();
				break;

			case 3:
				listarMusicas();
				break;

			case 4:
				listarPLaylists();
				break;
				
			case 5:
				listarMusicasPlaylist();
				break;
				
			case 0:
				break;
				
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 0);
	}

	public void cadastrarMusica() {

		System.out.println("Qual o título da música: ");
		String titulo = leitor.next();

		System.out.println("Qual o artista da música: ");
		String artista = leitor.next();

		System.out.println("Qual a duração da música: ");
		int duracao = leitor.nextInt();

		Musica m = new Musica();
		m.setArtista(artista);
		m.setDuracao(duracao);
		m.setTitulo(titulo);

		musica[qntMusicas] = m;
		qntMusicas++;
	}

	public void cadastrarPlaylist() {

		Musica[] musicasDaPlaylist = new Musica[20];
		int qntMusicasPlaylist = 0;

		System.out.println("Qual o nome da playlist: ");
		String nome = leitor.next();

		System.out.println("Deseja cadastrar uma música à playlist: ");
		char resposta = leitor.next().toLowerCase().charAt(0);

		while (resposta == 's') {
			System.out.println("Músicas disponíveis: ");
			for (int i = 0; i < qntMusicas; i++) {
				System.out.println(i + " - " + musica[i].getTitulo() + " (" + musica[i].getArtista() + ")");
			}
			int opcao = leitor.nextInt();

			musicasDaPlaylist[qntMusicasPlaylist] = musica[opcao];
			qntMusicasPlaylist++;

			System.out.println("Deseja adicionar outra música à playlist: ");
			resposta = leitor.next().toLowerCase().charAt(0);
		}

		Playlist p = new Playlist();
		p.setNome(nome);
		p.setColecaoMusicas(musicasDaPlaylist);

		playlist[qntPlaylists] = p;
		qntPlaylists++;
	}

	public void listarMusicas() {

		System.out.println("Músicas cadastradas:\n");
		
		for (int i = 0; i < qntMusicas; i++) {
			System.out.println((i + 1) + ": " + musica[i].getTitulo() + " ("
					+ musica[i].getArtista() + ")");
		}
	}

	public void listarPLaylists() {

		System.out.println("Playlists cadastradas: \n");
		
		for (int i = 0; i < qntPlaylists; i++) {
			System.out.println((i + 1) + ": " + playlist[i].getNome());
		}
	}
	
	public void listarMusicasPlaylist() {

	    System.out.println("Selecione uma das playlists cadastradas: ");
	    for (int i = 0; i < qntPlaylists; i++) {
	        System.out.println(i + " - " + playlist[i].getNome());
	    }
	    int opcao = leitor.nextInt();

	    System.out.println("Músicas da playlist " + playlist[opcao].getNome() + ":");

	    Musica[] musicasDaPlaylist = playlist[opcao].getColecaoMusicas();
	    for (int i = 0; i < musicasDaPlaylist.length; i++) {
	        if (musicasDaPlaylist[i] != null) {
	            System.out.println(musicasDaPlaylist[i].getTitulo() + " - " + musicasDaPlaylist[i].getArtista());
	        }
	    }
	}
	
	public static void main(String[] args) {
		
		new Gerenciador();
	}
}
