package Questao1;

import java.io.File;
import java.util.Scanner;

public class Questao1 {

	public static void main(String[] args) {
		new Questao1();
	}

	public Questao1() {
		Scanner leitor = new Scanner(System.in);

		System.out.println("Digite o caminho: ");
		String caminho = leitor.nextLine();

		File f = new File(caminho);

		if (f.exists()) {
			System.out.println("Caminho existente");
			
			if (f.isFile()) {
				System.out.println("Arquivo");
			} else {
				System.out.println("Diretório");
			}

			System.out.println("Nome: " + f.getName());
			System.out.println("Caminho absoluto: " + f.getAbsolutePath());
			System.out.println("Pode escrever: " + f.canWrite());
			System.out.println("Pode ler: " + f.canRead());

			if (f.isFile()) {
				System.out.println("Tamanho: " + f.length() + " bytes");
			}
		} else {
			System.out.println("Caminho inexistente");
		}

		leitor.close();
	}
}
