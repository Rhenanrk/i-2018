/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenan.es.integracao.exercicio04;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Individuo fulano = new Individuo();

        serializaObjeto(fulano);


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
}
