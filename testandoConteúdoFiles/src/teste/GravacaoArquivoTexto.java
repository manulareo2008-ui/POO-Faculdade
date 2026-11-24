package teste;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class GravacaoArquivoTexto {
    public static void main(String[] args) throws IOException {
        // 1) Cria o arquivo (se já existir, é recriado)
        File arquivo = new File("C:\\POO-Faculdade\\testandoConteúdoFiles\\texto.txt");
        PrintWriter arquivoTexto = new PrintWriter(arquivo);
        arquivoTexto.println("Primeira linha");
        arquivoTexto.print(true);
        arquivoTexto.printf("Preço: %20.2f", 1234.5);
        arquivoTexto.close();

        // 2) Acrescenta ao final, sem apagar
        FileOutputStream fos = new FileOutputStream(arquivo, true);
        PrintWriter acrescimo = new PrintWriter(fos);
        acrescimo.println("nova linha");
        acrescimo.close();

        // 3) Com codificação específica
        String linha = "áéíóúç!";
        PrintWriter out = new PrintWriter("arq4.txt", "UTF-8");
        out.write(linha);
        out.close();
    }
}