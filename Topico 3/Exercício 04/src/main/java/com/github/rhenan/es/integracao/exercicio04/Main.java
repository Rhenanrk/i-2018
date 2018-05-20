/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenan.es.integracao.exercicio04;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Classe principal do programa
 *
 * Serializo o objeto Individuo
 */
public class Main {

    /**
     * Método principal
     *
     * @param args
     */
    public static void main(String[] args) {

        Individuo fulano = new Individuo();

        serializaObjeto(fulano);

        desserializaObjeto();


    }

    private static void serializaObjeto(Individuo fulano) {
        try {
            // cria JAXB context e inicializa o Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(Individuo.class);
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
            jaxbMarshaller.marshal(fulano, XMLfile);

            System.out.println("\n---------\nObjeto serializado com sucesso!\n---------");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void desserializaObjeto() {
        try {
            // cria JAXB context
            JAXBContext context = JAXBContext.newInstance(Individuo.class);

            // transforme arquivo XML em objeto
            Unmarshaller un = context.createUnmarshaller();

            // instancia a partir de objeto serializado em doc XML
            Scanner leitor = new Scanner(System.in);
            System.out.print("Nome do arquivo de entrada: ");
            String arquivoEntrada = leitor.next();
            Individuo fulano = (Individuo) un.unmarshal(new FileReader(arquivoEntrada + ".xml"));

            System.out.println("\n---------\nObjeto desserializado com sucesso!\n---------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
