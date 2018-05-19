/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.rhenanrk.es.integracao.exercicio01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.ArrayList;

/**
 * Classe principal do programa.
 * Transforma arquivo CSV em um arquivo XML.
 * O arquivo de origem deve estar na pasta raiz da aplicação.
 */
public class Main {

    /**
     * Método principal do programa.
     *
     * @param args
     */
    public static void main(String[] args) throws JAXBException, IOException {

        Turma turma = new Turma();
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        transformaCsvEmObjeto(turma, alunos);

        transformaObjetoEmXml(turma);
    }

    /**
     * Método responsável por transformar o arquivo CSV em objeto do tipo Aluno e adicionar à turma
     *
     * @param turma
     * @param alunos
     */
    private static void transformaCsvEmObjeto(Turma turma, ArrayList<Aluno> alunos) {
        BufferedReader br = null;
        String linha = "";
        String VIRGULA = ",";
        final String cabecalho = "NOME,EMAIL";

        try {
            br = new BufferedReader(new FileReader("Arq.csv"));
            while ((linha = br.readLine()) != null) {
                if (linha.contains(cabecalho))
                    continue;

                String[] line = linha.split(VIRGULA);

                Aluno aluno = new Aluno();
                aluno.setNome(line[line.length - 2]);
                aluno.setEmail(line[line.length - 1]);

                alunos.add(aluno);
            }
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo: " + e);
        }
        turma.setAlunos(alunos);
    }

    /**
     * Método responsável por transformar o objeto do tipo Turma em arquivo XML
     *
     * @param turma
     */
    private static void transformaObjetoEmXml(Turma turma) {
        try {
            JAXBContext context = JAXBContext.newInstance(Turma.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            m.marshal(turma, new File("Arq.xml"));
        } catch (JAXBException e) {
            System.out.println("Erro na criação do arquivo de saída: " + e);
        }
    }
}