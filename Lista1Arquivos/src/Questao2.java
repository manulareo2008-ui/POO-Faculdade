import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Questao2 {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Caminho da pasta-base: ");
        String caminhoPastaBase = leitor.nextLine();
        File pastaBase = new File(caminhoPastaBase);

        System.out.print("Nome do projeto: ");
        String nomeProjeto = leitor.nextLine();
        leitor.close();

        // Etapa 1: a pasta-base precisa existir e ser uma pasta
        if (!pastaBase.exists() || !pastaBase.isDirectory()) {
            System.out.println("A pasta-base não existe ou não é uma pasta.");
            return;
        }

        // Acumuladores do relatório
        String criados = "";
        String jaExistiam = "";
        String conflitos = "";
        String falhas = "";

        // Etapa 2: pasta do projeto
        File pastaProjeto = new File(pastaBase, nomeProjeto);
        if (!pastaProjeto.exists()) {
            if (pastaProjeto.mkdir()) {
                criados += "Pasta " + nomeProjeto + "\n";
            } else {
                falhas += "Não foi possível criar a pasta " + nomeProjeto + "\n";
            }
        } else if (pastaProjeto.isDirectory()) {
            jaExistiam += "Pasta " + nomeProjeto + "\n";
        } else {
            conflitos += "Existe um arquivo com o nome " + nomeProjeto + " no lugar da pasta\n";
        }

        // Só continua se a pasta do projeto existe de fato (criada agora ou já existente)
        if (pastaProjeto.isDirectory()) {

            // Etapa 3: subpastas
            String[] subpastas = {"dados", "relatorios", "backup"};
            for (String nome : subpastas) {
                File sub = new File(pastaProjeto, nome);
                if (!sub.exists()) {
                    if (sub.mkdir()) {
                        criados += "Pasta " + nome + "\n";
                    } else {
                        falhas += "Não foi possível criar a pasta " + nome + "\n";
                    }
                } else if (sub.isDirectory()) {
                    jaExistiam += "Pasta " + nome + "\n";
                } else {
                    conflitos += "Existe um arquivo com o nome " + nome + " no lugar da pasta\n";
                }
            }

            // Etapa 4: README.txt
            File readme = new File(pastaProjeto, "README.txt");
            if (!readme.exists()) {
                readme.createNewFile();   // lança IOException se falhar
                criados += "Arquivo README.txt\n";
            } else if (readme.isFile()) {
                jaExistiam += "Arquivo README.txt\n";
            } else {
                conflitos += "Existe uma pasta com o nome README.txt no lugar do arquivo\n";
            }
        }

        // Etapa 5: relatório
        System.out.println("--- Criados ---");
        System.out.print(criados);
        System.out.println("--- Já existiam ---");
        System.out.print(jaExistiam);
        System.out.println("--- Conflitos ---");
        System.out.print(conflitos);
        System.out.println("--- Falhas ---");
        System.out.print(falhas);
    }
}