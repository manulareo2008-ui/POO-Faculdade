package QuestaoTesteReplica4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplicaQuestao4 {

	public static void main(String[] args) throws FileNotFoundException {
		new ReplicaQuestao4();
	}

	public ReplicaQuestao4() throws FileNotFoundException {

		File estoque = new File("estoque.txt");
		if(!estoque.isFile()) {
			System.out.println("Estoque.txt não existe");
			return;
		}
		
		Scanner leitor = new Scanner(estoque);
		
		File arquivo = new File("reposicao.txt");
		PrintWriter reposicao = new PrintWriter(arquivo);
		reposicao.println("ARQUIVO DE REPOSIÇÃO");

		int linha = 0;
		int precisaReposicao = 0;
		double valorTotal = 0;
		String produtoMaiorValor = "";
		double maiorPreco = 0;
		int validos = 0;
		if (estoque.exists()) {
			while (leitor.hasNextLine()) {
				linha++;
				String texto = leitor.nextLine();
				String[] partes = texto.split(";");

				try {
					if (partes[0].isBlank()) {
						throw new IllegalArgumentException("Nome do produto deve ser preenchido");
					}

					int qnt = Integer.parseInt(partes[1]);
					if (qnt < 0) {
						throw new IllegalArgumentException("Quantidade não pode ser menor que 0");
					}

					double preco = Double.parseDouble(partes[2]);
					if (preco <= 0) {
						throw new IllegalArgumentException("Preço deve ser maior que 0");
					}

					if (qnt < 5) {
						reposicao.println("Unidades faltantes para chegar a 5: " + (5 - qnt));
						reposicao.println("Produto: " + partes[0]);
						reposicao.println("Quantidade atual: " + qnt);
						precisaReposicao++;
					}


					if (produtoMaiorValor == null || maiorPreco < preco){
						produtoMaiorValor = partes[0];
						maiorPreco = preco;
					}
					validos++;
					valorTotal += preco * qnt;
				} catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
					System.out.println("Linha " + linha + " inválida");
				}
			}
		}

		reposicao.println("Total de produtos que precisam de reposição: " + precisaReposicao);
		if (validos == 0) {
			reposicao.println("Produto de maior valor e valor total no estoque indisponíveis");
		} else {
			reposicao.println("Valor total do estoque: R$" + valorTotal);
			reposicao.println("Produto de maior preço: " + produtoMaiorValor);		}
		
		leitor.close();
		reposicao.close();
	}
}
