package teste;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class a {

	public static void main(String[] args) throws IOException{

		/*
		 * File diretorio = new File("C:\\Aula 3 prog\\Aula 3 prog\\src");
		 * 
		 * dentro do conteudoDiretorio, é colocado cada arquivo e pasta presente dentro
		 * do diretório apontado (no caso é o "."). File[] conteudoDiretorio =
		 * diretorio.listFiles(); for (File item : conteudoDiretorio) { if
		 * (item.isDirectory()) { System.out.println("Diretório: " + item.getName()); }
		 * else { System.out.println("Arquivo " + item.getName() + " tem " +
		 * item.length() + " bytes"); } }
		 */
		
		File arquivo = new File("dados.dat");
        FileOutputStream fos = new FileOutputStream(arquivo);
        fos.write(79);
        fos.write(105);
        fos.close();

        fos = new FileOutputStream(arquivo, true);
        fos.write(65);
        fos.close();
	}
}