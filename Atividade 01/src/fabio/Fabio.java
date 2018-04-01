package fabio;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

public class Fabio {

    public static void main(String[] args) throws IOException {
        Locale loc = new Locale("pt", "BR");
        String nome_arquivo = "";
        Scanner ler = new Scanner(System.in, "UTF-8");
        
        // Tarefa 01: 4 primeiros bytes de arquivo texto
        System.out.println("Entre com o nome e a extenção do arquivo texto:");
        nome_arquivo = ler.nextLine();
        System.out.println("Os 4 primeiros bytes do arquivo são:");
        FileInputStream fis = new FileInputStream(nome_arquivo);
        DataInputStream dis = new DataInputStream(fis);

        int valor = dis.readInt();
        dis.close();
        System.out.println(Integer.toHexString(valor).substring(0, 4));
        System.out.println("======================");

        // Tarefa 01: Macig Number de arquivo .class
        System.out.println("Entre com o nome e a extenção do arquivo de classe:");
        nome_arquivo = ler.nextLine();

        FileInputStream fis2 = new FileInputStream(nome_arquivo);
        DataInputStream dis2 = new DataInputStream(fis2);

        valor = dis2.readInt();
        dis2.close();
        System.out.println(Integer.toHexString(valor));
        System.out.println("======================");
        
        // Tarefa 02: Verificar se arquivo é um JPEG
        System.out.println("Entre com o nome e a extenção do arquivo JPEG:");
        nome_arquivo = ler.nextLine();

        FileInputStream fis3 = new FileInputStream(nome_arquivo);
        DataInputStream dis3 = new DataInputStream(fis3);

        valor = dis3.readInt();
        dis3.close();
        if (Integer.toHexString(valor).substring(0, 4).equals("ffd8")) {
            System.out.println("O arquivo é um jpeg");
        } else {
            System.out.println("O arquivo não é um jpeg");
        }
        
        // Tarefa 03: Exibir conteúdo de arquivo em UTF-8
        Charset uft8 = Charset.forName("UTF-8");
        System.out.println("Entre com o nome do arquivo a ser exibido:");
        nome_arquivo = ler.nextLine();
        Path arquivo = Paths.get(nome_arquivo);
        for (String linha : Files.readAllLines(arquivo, uft8)) {
            System.out.println(linha);
        }
        System.out.println("======================");
        
        // Tarefa 04: Escrever conteúdo em arquivo em UTF-8
        String conteudo = null;
        System.out.println("Entre com o nome do arquivo:");
        nome_arquivo = ler.nextLine();
        System.out.println("Entre com o que será gravado no arquivo:");
        conteudo = ler.nextLine();
        System.out.println("======================\nConteúdo atual do arquivo:");
        
        conteudo = "caminhão";
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nome_arquivo, true), StandardCharsets.UTF_8));
        escritor.write(conteudo);
        escritor.newLine();
        escritor.close();
    }
}
