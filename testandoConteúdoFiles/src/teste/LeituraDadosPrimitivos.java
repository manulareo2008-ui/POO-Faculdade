package teste;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LeituraDadosPrimitivos {
    public static void main(String[] args) throws IOException {
        File f = new File("dados.bin");
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        double preco = dis.readDouble();
        boolean bool = dis.readBoolean();
        String instituicao = dis.readUTF();
        dis.close();

        System.out.println(preco);
        System.out.println(bool);
        System.out.println(instituicao);
    }
}