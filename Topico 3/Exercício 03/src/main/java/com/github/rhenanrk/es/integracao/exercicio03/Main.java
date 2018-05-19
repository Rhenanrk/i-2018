/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenanrk.es.integracao.exercicio03;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Classe principal do programa
 * Usuário define, por meio de terminal, se irá gerar um arquivo XML a partir dos objetos pré-definidos
 * ou se irá gerar objetos a partir de um arquivo XML de entrada
 */
public class Main {

    /**
     * Método principal do programa
     * Invoca os metodos de serialização e desserialização
     *
     * @param args
     */
    public static void main(String[] args) {

        // criando estudantes
        List<Estudante> estudanteList = new ArrayList<Estudante>();
        Estudante rhenan = new Estudante("Rhenan Konrad");
        estudanteList.add(rhenan);
        Estudante joao = new Estudante("João Alfredo");
        estudanteList.add(joao);

        // definindo endereço dos estudantes
        Endereco endereco = new Endereco("74665-555", "Avenida Afonso Pena", "s/n", "Apartamento");
        rhenan.setEndereco(endereco);

        endereco = new Endereco("82975-882", "Rua das Laranjeiras", "12", "Casa");
        joao.setEndereco(endereco);

        // criando a turma e adicionando a lista de estudantes
        Turma turma = new Turma();
        turma.setListOfEstudantes((ArrayList<Estudante>) estudanteList);

        Scanner leitor = new Scanner(System.in);
        System.out.print("1 - Serializa objeto\n2 - Desserializa objeto\nAlternativa: ");
        int opcao = leitor.nextInt();

        switch (opcao) {
            case 1:
                // método que converte objetos em XML e serializa
                serializaObjeto(turma);
                break;

            case 2:
                // método que converte arquivo XML em objeto
                desserializaObjeto();
                break;
        }
    }

    /**
     * Método responsável por serializar o objeto passado como parametro
     *
     * @param turma
     */
    private static void serializaObjeto(Turma turma) {
        try {
            // cria JAXB context e inicializa o Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Turma.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // configurando para obter o formato de saída adequado
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            // especificando o nome do arquivo xml que será criado na pasta raiz
            Scanner leitor = new Scanner(System.in);
            System.out.print("Nome do arquivo a ser gerado: ");
            String arquivoSaída = leitor.next();
            File XMLfile = new File(arquivoSaída + ".xml");

            // escrevendo no arquivo XML
            jaxbMarshaller.marshal(turma, XMLfile);

            System.out.println("\n---------\nObjeto serializado com sucesso!\n---------");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método responsável por gerar objeto a partir de arquivo XML de entrada
     */
    private static void desserializaObjeto() {
        try {
            // cria JAXB context
            JAXBContext context = JAXBContext.newInstance(Turma.class);

            // transforme arquivo XML em objeto
            Unmarshaller un = context.createUnmarshaller();

            // instancia a partir de objeto serializado em doc XML
            Scanner leitor = new Scanner(System.in);
            System.out.print("Nome do arquivo de entrada: ");
            String arquivoEntrada = leitor.next();
            Turma turma = (Turma) un.unmarshal(new FileReader(arquivoEntrada + ".xml"));

            System.out.println("\n---------\nObjeto desserializado com sucesso!\n---------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

