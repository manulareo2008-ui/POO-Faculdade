package teste;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GravacaoArquivoBinario {

	public static void main(String[] args) throws IOException {

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