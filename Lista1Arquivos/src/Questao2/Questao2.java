package Questao2;

import java.util.Scanner;
import java.io.File;

public class Questao2 {

	public static void main(String[] args) {
		new Questao2();
	}

	public Questao2() {

		Scanner leitor = new Scanner(System.in);

		System.out.print("Caminho da pasta-base: ");
		String caminho = leitor.nextLine();

		File pastaBase = new File(caminho);

		System.out.print("Nome do projeto: ");
		String projetoParaCriar = leitor.nextLine();
		
		leitor.close();

		if (projetoParaCriar.isBlank()) {
			System.out.println("Nome do projeto deve ser informado");
			return;
		}

		String criados = "";
		String falhas = "";
		String jaExistiam = "";
		String conflito = "";

		if (pastaBase.exists()) {
			if (pastaBase.isDirectory()) {
				File projetoBase = new File(pastaBase, projetoParaCriar);
				if (!projetoBase.exists()) {
					if (projetoBase.mkdir()) {
						criados += projetoBase.getName() + "\n";
					} else {
						falhas += projetoBase.getName() + "\n";
					}
				} else if (projetoBase.isDirectory()) {
					jaExistiam += projetoBase.getName() + "\n";
				} else {
					conflito += projetoBase.getName() + "\n";
				}

				if (projetoBase.isDirectory()) {
					String[] subpastas = { "dados", "relatorios", "backup" };
					for (String nome : subpastas) {
						File sub = new File(projetoBase, nome);
						if (!sub.exists()) {
							if (sub.mkdir()) {
								criados += nome + "\n";
							} else {
								falhas += nome + "\n";
							}
						} else if (sub.isDirectory()) {
							jaExistiam += nome + "\n";
						} else {
							conflito += nome + "\n";
						}
					}
				}

				System.out.println("Criados: " + criados);
				System.out.println("Falhas: " + falhas);
				System.out.println("Já existiam: " + jaExistiam);
				System.out.println("Conflito: " + conflito);

			} else {
				System.out.println("A pasta-base não é uma pasta, portanto, nada criado");
			}
		} else {
			System.out.println("Pasta apontada não existe, portando, nada criado");
		}
	}
}
