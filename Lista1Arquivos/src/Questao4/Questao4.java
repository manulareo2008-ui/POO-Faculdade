package Questao4;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Questao4 {

	public static void main(String[] args) throws FileNotFoundException {
		new Questao4();
	}

	public Questao4() throws FileNotFoundException {
		Scanner leitor = new Scanner(new File("notas.txt"));
		
		File relatorio = new File("relatorio.txt");
		PrintWriter saida = new PrintWriter(relatorio);
		saida.println("RELATORIO DE NOTAS");

		int linha = 0;
		int aprovados = 0;
		int reprovados = 0;
		double media = 0;
		int validos = 0;
		while(leitor.hasNextLine()) {
			linha++;
			String texto = leitor.nextLine();
			String[] partes = texto.split(";");
			
			try {
				double nota = Double.parseDouble(partes[1]);
				if(partes[0].isBlank()) {
					throw new IllegalArgumentException("Nome não informado");
				}
				if(!(nota >= 0 && nota <= 10)) {
					throw new IllegalArgumentException("Nota inválida");
				}
				
				String situacao;
				if(nota >= 6.0) {				
					situacao = "APROVADO";
					aprovados++;
					
				} else {
					situacao = "REPROVADO";
					reprovados++;	
				}
				
				media += nota;
				validos++;
				saida.println(partes[0] + ";" + nota + ";" + situacao);
				
			} catch(ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
				System.out.println("Linha " + linha + " ruim");
			}
		}
		saida.println("Total aprovados: " + aprovados + "\nTotal reprovados " + reprovados);
		
		if(validos == 0) {
			saida.println("A média está indisponível");
		} else {
			saida.println("Nota média das notas válidas: " + media/validos);

		}
		saida.close();
		leitor.close();
	}
}


