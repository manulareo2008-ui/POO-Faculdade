package teste;

import java.io.File;
import java.io.IOException;

public class AcessoSistemaArquivos {

	public static void main(String[] args) throws IOException {

		File diretorio = new File("C:\\Users\\Alejandro\\OneDrive\\Documentos\\a");

		// dentro do conteudoDiretorio, é colocado cada arquivo e pasta presente dentro
		// do diretório apontado (no caso é o ".").
		File[] conteudoDiretorio = diretorio.listFiles();
		for (File item : conteudoDiretorio) {
			if (item.isDirectory()) {
				System.out.println("Diretório: " + item.getName());
			} else {
				System.out.println("Arquivo " + item.getName() + " tem " + item.length() + " bytes");
			}
		}
	}
}
