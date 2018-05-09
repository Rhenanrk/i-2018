package com.github.rhenanrk.es.integracao.exercicio01;

import java.io.*;

/**
 * Classe responssável por traduzir um arquivo .CSV em .XML
 *
 * @author rhenanrk
 */

public class ManipulaArquivo {
    public static void geraXML(String arq) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arq + ".csv")));
        BufferedWriter write = new BufferedWriter(new FileWriter(arq + ".xml"));

        String linha;
        final String VIRGULA = ",";
        final String cabecalho = "NOME,EMAIL";

        write.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" + "\n");
        write.append("<alunos>" + "\n");

        while ((linha = reader.readLine()) != null) {
            if (linha.contains(cabecalho))
                continue;
            else {
                String[] dadosUsuario = linha.split(VIRGULA);
                write.append("    <aluno>" + "\n");
                write.append("        <nome>" + dadosUsuario[0] + "</nome>" + "\n");
                write.append("        <email>" + dadosUsuario[1] + "</email>" + "\n");
                write.append("    </aluno>" + "\n");
            }
        }

        write.append("</alunos>");

        reader.close();
        write.close();
    }
}