package teste;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class GravacaoArquivoTexto {

    public static void main(String[] args) throws IOException {
        // 1. Gravação de arquivo texto (Slide 4)
        File arquivo = new File("texto.txt");
        PrintWriter arquivoTexto = new PrintWriter(arquivo);
        arquivoTexto.println("Primeira linha");
        arquivoTexto.print(true);
        arquivoTexto.printf("Preço: %20.2f", 1234.5);
        arquivoTexto.close();

        // 2. Inclusão de novo texto no final do arquivo (Slide 7)
        FileOutputStream fos = new FileOutputStream(arquivo, true);
        arquivoTexto = new PrintWriter(fos);
        arquivoTexto.println("nova linha");
        arquivoTexto.close();

        // 3. Gravação com codificação específica (Slide 12)
        String linha = "áéíóúc!";
        PrintWriter out = new PrintWriter("arq4.txt", "UTF-8");
        out.write(linha);
        out.close();
    }
}



s