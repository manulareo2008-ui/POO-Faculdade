import java.io.File;
import java.util.Scanner;

public class Questao1 {

	public static void main(String[] args) {

		boolean achou = false;
		while (achou == false) {
			Scanner leitor = new Scanner(System.in);

			System.out.print("Informe o caminho: ");
			String caminho = leitor.nextLine();
			File f = new File(caminho);

			if (f.exists()) {
				achou = true;
				
				if (f.isDirectory()) {
					System.out.println("Diretório");
				} else if (f.isFile()) {
					System.out.println("Arquivo");
				}

				System.out.println(f.getName());
				System.out.println(f.getAbsolutePath());

				if (f.canRead()) {
					System.out.println("Pode ler");
				} else {
					System.out.println("Não pode ler");
				}

				if (f.canWrite()) {
					System.out.println("Pode escrever");
				} else {
					System.out.println("Não pode escrever");
				}

				if (f.isFile()) {
					System.out.println(f.length());
				}
				
			} else {
				System.out.println("O caminho não existe, informe um que sim exista:");
				achou = false;
			}
		}
	}
}
