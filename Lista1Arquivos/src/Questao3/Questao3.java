package Questao3;

import java.io.File;
import java.util.Scanner;

public class Questao3 {

	public static void main(String[] args) {
		new Questao3();
	}

	public Questao3() {
		Scanner leitor = new Scanner(System.in);

		System.out.print("Qual o caminho do diretório: ");
		String caminho = leitor.nextLine();

		File pastaBase = new File(caminho);
		if (pastaBase.exists()) {
			if (pastaBase.isDirectory()) {

				int qntArquivos = 0;
				int qntSubpastas = 0;
				long somaTamanhoArquivos = 0;
				File maior = null;

				File[] arquivosDaPastaBase = pastaBase.listFiles();
				if (arquivosDaPastaBase == null) {
					System.out.println("Falha na listagem");
				} else if (arquivosDaPastaBase.length == 0) {
					System.out.println("Pasta-base sem nada dentro");
				} else {
					for (File itens : arquivosDaPastaBase) {
						System.out.println("Nome: " + itens.getName());
						if (itens.isDirectory()) {
							System.out.println(itens.getName() + " é um Diretório");
							qntSubpastas++;
						} else {
							System.out.println(itens.getName() + " é um Arquivo");
							System.out.println(itens.getName() + " possui " + itens.length() + " bytes\n");
							qntArquivos++;
							somaTamanhoArquivos += itens.length();

							if (maior == null || itens.length() > maior.length()) {
								maior = itens;
							}
						}
					}
					
					System.out.println("Quantidade de arquivos dentro da pasta-base: " + qntArquivos);
					System.out.println("Quantidade de subpastas dentro da pasta-base: " + qntSubpastas);
					System.out.println("Soma dos tamanhos dos arquivos da pasta-base: " + somaTamanhoArquivos);
					if (maior == null) {
						System.out.println("Não há arquivos dentro da pasta-base");
					} else {
						System.out.println("Maior arquivo da pasta-base: " + maior.getName());
					}
				}
				
			} else {
				System.out.println("A pasta-base não é uma pasta");
			}

		} else {
			System.out.println("A pasta-base não existe");
		}
	}
}
