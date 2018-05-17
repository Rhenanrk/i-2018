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

public class Main {
    public static void main(String[] args) {

        // criando estudantes
        List<Estudante> estudanteList = new ArrayList<Estudante>();
        Estudante rhenan = new Estudante("Rhenan Konrad");
        estudanteList.add(rhenan);
        Estudante joao = new Estudante("Menino Neymar");
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
        System.out.print("1 - Serializa objeto\n2 - Desserializa objeto\nOpção: ");
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

    private static void serializaObjeto(Turma turma) {
        try {
            // cria JAXB context e inicializa o Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Turma.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // configurando para obter o formato de saída adequado
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // especificando o nome do arquivo xml que será criado na pasta raiz
            File XMLfile = new File("Turma.xml");

            // escrevendo no arquivo XML
            jaxbMarshaller.marshal(turma, XMLfile);

            System.out.println("---------\nObjeto serializado com sucesso!\n---------");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void desserializaObjeto() {
        try {
            // cria JAXB context
            JAXBContext context = JAXBContext.newInstance(Turma.class);

            // transforme arquivo XML em objeto
            Unmarshaller un = context.createUnmarshaller();

            // instancia a partir de objeto serializado em doc XML
            Turma turma = (Turma) un.unmarshal(new FileReader("Turma.xml"));

            System.out.println("---------\nObjeto desserializado com sucesso!\n---------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

