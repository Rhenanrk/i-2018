package fabio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class testes {

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        String nome_arquivo = null, conteudo;
        System.out.println("Entre com o nome do arquivo:");

        String stringToConvert = ler.nextLine();
        byte[] theByteArray = stringToConvert.getBytes();

        theByteArray.toString();
        String s = new String(theByteArray, Charset.forName("UTF-8"));
        System.out.println(s);

        /*
        nome_arquivo = ler.nextLine();
        System.out.println(nome_arquivo);
        
        
        System.out.println("Entre com o que será gravado no arquivo:");
        conteudo = ler.nextLine();
        System.out.println("======================\nConteúdo atual do arquivo:");
        
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nome_arquivo, true), StandardCharsets.UTF_8));
        escritor.write(conteudo);
        escritor.newLine();
        escritor.close();
        
        
        
        Charset uft8 = Charset.forName("UTF-8");
        Path arquivo = Paths.get(nome_arquivo);
        for (String linha : Files.readAllLines(arquivo, uft8)) {
            System.out.println(linha);
        }
         */
    }

}
