// copyright
package com.github.rhenanrk.es.integracao.exercicio01;

import java.util.Scanner;

/**
 * Classe principal responssável por chamar o método que gera o arquivo esperado no formato .XML e passa
 * como paramentro o nome do arquivo de entrada no formato .CSV
 *

 */

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Nome do arquivo .CSV: ");
        String arq = leitor.nextLine();

        ManipulaArquivo.geraXML(arq);
    }
}

