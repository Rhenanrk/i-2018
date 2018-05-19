package serializable_1;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializable {

    public static void main(String[] args) {

        Objeto classe2 = new Objeto("Rhenan");

        try {

            //Gera o arquivo para armazenar o objeto
            FileOutputStream arquivoGrav
                    = new FileOutputStream("C:/Users/rhena/Desktop/saida.dat");

            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

            //Grava o objeto cliente no arquivo
            objGravar.writeObject(classe2);

            objGravar.flush();

            objGravar.close();

            arquivoGrav.flush();

            arquivoGrav.close();

            System.out.println("Objeto gravado com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
