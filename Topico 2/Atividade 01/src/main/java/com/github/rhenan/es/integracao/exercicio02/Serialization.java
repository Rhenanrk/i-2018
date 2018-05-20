/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 *
 */

package com.github.rhenan.es.integracao.exercicio02;

import com.google.gson.Gson;

import java.io.*;

/**
 * Classe principal do programa
 * Responde à questão numero 02 da lista 01 de Serialização
 *
 * Faz uso da biblioteca Gson para serializar e desserializar um objeto Pessoa, que contem nome, idade e faz uso de
 * outra classe, "Endereco", que contem o endereço da pessoa
 *
 * O objeto é criado no main com os respectivos atributos
 *
 * O método main invoca o método "serializaObjeto", que transforma o objeto Pessoa em um arquivo TXT com os dados
 * formatados pelo Gson
 *
 * O método main tambem invoca o método "desserializaObjeto", que recebe o arquivo TXT e, fazendo uso da biblioteca
 * Gson, transforma o conteúdo em um objeto da classe "pessoaDesserializada" e imprime os atributos da classe para fins
 * de teste.
 *
 */
public class Serialization {

    /**
     * Método principal do programa
     * Invoca os métodos "serializaObjeto" e "desserializaObjeto"
     *
     * @param args
     */
    public static void main(String[] args) {
        Pessoa rhenan = new Pessoa("Rhenan Konrad", 20);
        Endereco endereco = new Endereco("74665-555", "Avenida Afonso Pena");
        rhenan.setEndereco(endereco);
        Gson gson = new Gson();
        String pessoa = gson.toJson(rhenan);

        serializaObjeto(pessoa);

        desserializaObjeto(gson);
    }

    /**
     * Método responsável por serializar o objeto Pessoa em um arquivo TXT com a formatação JSON
     *
     * @param pessoa
     */
    private static void serializaObjeto(String pessoa) {
        File arq = new File("pessoa.txt");
        try {
            FileWriter fw = new FileWriter(arq);
            fw.write(pessoa);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método responsável por desserializar o arquivo "pessoa.txt" gerado pela biblioteca Gson no padrão JSON
     * e transforma o conteúdo em um objeto da classe "pessoaDesserializada"
     *
     * @param gson
     */
    private static void desserializaObjeto(Gson gson) {
        try {
            FileReader ler = new FileReader("pessoa.txt");
            BufferedReader reader = new BufferedReader(ler);
            String linha;
            while ((linha = reader.readLine()) != null) {
                pessoaDesserializada rhenanLido = gson.fromJson(linha, pessoaDesserializada.class);
                System.out.println("Nome: " + rhenanLido.getNome() + "\nIdade: " + rhenanLido.getIdade());
                System.out.println("CEP: " + rhenanLido.getEndereco().getCEP() + "\nLogradouro: " + rhenanLido.getEndereco().getLogradouro());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
