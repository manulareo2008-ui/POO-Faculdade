package teste;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GravacaoDadosPrimitivos {
    public static void main(String[] args) throws IOException {
        double preco = 19.9;

        File f = new File("dados.bin");
        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeDouble(preco);
        dos.writeBoolean(true);
        dos.writeUTF("FURB");
        dos.close();
    }
}