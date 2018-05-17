package com.github.rhenanrk.es.integracao.exercicio01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Classe responssável por traduzir o arquivo de entrada em formato .CSV em
 * um arquivo .XML com o mesmo nomo do arquivo de entrada
 *
 * @author rhenanrk
 */

public class ManipulaArquivo {

    /**
     *Método responssável por ler o arquivo
     *
     * @param arq
     * @throws Exception
     */
    public static void geraXML(String arq, Conversor conversor) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arq + ".csv")));
        BufferedWriter write = new BufferedWriter(new FileWriter(arq + ".xml"));

        String linha;
        final String VIRGULA = ",";
        final String cabecalho = "NOME,EMAIL";

        write.append("<?xml version='1.0' encoding='UTF-8'?>" + "\n");
        write.append("<alunos>" + "\n");

        while ((linha = reader.readLine()) != null) {
            String xml = conversor.converte(linha);
            //converte(write, linha, VIRGULA, cabecalho);
        }

        write.append("</alunos>");

        reader.close();
        write.close();
    }

    public void fazAlgo() throws IOException {
        Stream<String> carregaLinhas = getLines();
        processaLinha(carregaLinhas);
    }

    private Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get("x.txt"));
    }

    private void processaLinha(Stream<String> carregaLinhas) {
        carregaLinhas
                .map(l -> novaLinha(l))
                .forEach(l -> salvar(l));
    }

    private static String converte(BufferedWriter write, String linha, String VIRGULA, String cabecalho) throws IOException {
        if (linha.contains(cabecalho))
            return "";
        else    {
            String[] dadosUsuario = linha.split(VIRGULA);
            StringBuilder sb = new StringBuilder();
            sb.append("   <aluno>\n");
            write.append("    <aluno>" + "\n");
            write.append("        <nome>" + dadosUsuario[0] + "</nome>" + "\n");
            write.append("        <email>" + dadosUsuario[1] + "</email>" + "\n");
            write.append("    </aluno>" + "\n");
            return sb.toString();
        }
    }
}

interface Conversor {
    String converte(String linha);
}