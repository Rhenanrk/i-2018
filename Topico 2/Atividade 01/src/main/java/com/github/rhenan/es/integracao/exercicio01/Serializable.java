/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 *
 */

package com.github.rhenan.es.integracao.exercicio01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Classe responsável por serializar o objeto
 * Retornara a exceção "NotSerializableException" pois o objeto não foi mercado como "Serializable"
 */
public class Serializable {

    /**
     * Método principal do programa
     * @param args
     */
    public static void main(String[] args) {
        Objeto obj = new Objeto("Teste");

        try {
            //Gera o arquivo para armazenar o objeto
            FileOutputStream arquivoGrav = new FileOutputStream("saida.txt");

            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

            //Grava o objeto cliente no arquivo
            objGravar.writeObject(obj);

            objGravar.flush();
            arquivoGrav.flush();
            objGravar.close();
            arquivoGrav.close();

            System.out.println("Objeto gravado com sucesso!");

        } catch (IOException e) {
            System.out.println("Catch: \nErro ao serializar objeto: " + e);
        }
    }
}
