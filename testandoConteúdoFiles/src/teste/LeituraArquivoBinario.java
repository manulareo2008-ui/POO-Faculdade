package teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LeituraArquivoBinario {
    public static void main(String[] args) throws IOException {
        File f = new File("dados.dat");
        FileInputStream fis = new FileInputStream(f);
        int dado;
        while (true) {
            dado = fis.read();
            if (dado != -1) {
                System.out.println(dado);
            } else {
                break;
            }
        }
        fis.close();
        System.out.println("Terminou");
    }
}