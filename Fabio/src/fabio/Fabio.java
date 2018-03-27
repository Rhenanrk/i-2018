package fabio;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Fabio {

    public static void main(String[] args) throws IOException {
        String nome_arquivo = "teste.txt";
        /* Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o nome do arquivo:");
        nome_arquivo = sc.nextLine();
        System.out.println("======================"); */

        FileInputStream fis = new FileInputStream(nome_arquivo);
        DataInputStream dis = new DataInputStream(fis);

        int valor = dis.readInt();
        dis.close();
        String resultado = Integer.toHexString(valor);
        System.out.println(resultado);

    }
}
