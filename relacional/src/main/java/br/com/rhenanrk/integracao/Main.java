/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.integracao;

import br.com.rhenanrk.dao.IndividuoDao;
import br.com.rhenanrk.dao.NomeDao;
import br.com.rhenanrk.dao.RepresentacaoDao;
import br.com.rhenanrk.dto.IndividuoDto;
import br.com.rhenanrk.dto.NomeDto;
import br.com.rhenanrk.dto.RepresentacaoDto;

import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        int opcao;
        Scanner leitor = new Scanner(System.in);

        do {
            System.out.print("1 - Inserir nova pessoa\n" +
                    "Opcao: ");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1: // insere pessoa no banco de dados

                    // inserindo na tabela individuo
                    IndividuoDto individuoDto = new IndividuoDto();
                    IndividuoDao individuoDao = new IndividuoDao();
                    UUID uuid = UUID.randomUUID();
                    String myRandom = uuid.toString();
                    String surrogateKey = myRandom.substring(0, 10);
                    individuoDto.setsurrogateKey(surrogateKey);
                    individuoDao.inserir(individuoDto);

                    // inserindo na tabela nome
                    NomeDto nomeDto = new NomeDto();
                    NomeDao nomeDao = new NomeDao();
                    String titulos, nomes, sobrenomes, sufixos, inicioUso, fimUso;
                    int preferido, usoCondicional, uso;

                    nomeDto.setSurrogateKey(surrogateKey);
                    System.out.print("CADASTRO DE PESSOA, INSIRA AS INFORMACOES PEDIDAS ABAIXO");
                    System.out.print("\nTitulos: ");
                    titulos = leitor.next();
                    nomeDto.setTitulos(titulos);

                    System.out.print("\nNome: ");
                    nomes = leitor.next();
                    nomeDto.setNomes(nomes);

                    System.out.print("\nSobrenomes: ");
                    sobrenomes = leitor.next();
                    nomeDto.setSobrenomes(sobrenomes);

                    System.out.print("\nSufixos: ");
                    sufixos = leitor.next();
                    nomeDto.setSufixos(sufixos);

                    System.out.print("\nPreferido: ");
                    preferido = leitor.nextInt();
                    nomeDto.setPreferido(preferido);

                    System.out.print("\nUso condicional: ");
                    usoCondicional = leitor.nextInt();
                    nomeDto.setUsoCondicional(usoCondicional);

                    System.out.print("\nUso: ");
                    uso = leitor.nextInt();
                    nomeDto.setUso(uso);

                    System.out.print("\nInicio do uso do nome: ");
                    inicioUso = leitor.next();
                    nomeDto.setinicioUso(inicioUso);

                    System.out.print("\nFim do uso do nome: ");
                    fimUso = leitor.next();
                    nomeDto.setfimUso(fimUso);

                    nomeDao.inserir(nomeDto);

                    // inserindo na tabela representação
                    RepresentacaoDto representacaoDto = new RepresentacaoDto();
                    RepresentacaoDao representacaoDao = new RepresentacaoDao();
                    String utilizacao, alternativa;

                    representacaoDto.setsurrogateKey(surrogateKey);

                    System.out.print("\nUtilizacao: ");
                    utilizacao = leitor.next();
                    representacaoDto.setUtilizacao(utilizacao);

                    System.out.print("\nAlternativa: ");
                    alternativa = leitor.next();
                    representacaoDto.setAlternativa(alternativa);

                    representacaoDao.inserir(representacaoDto);




                    break;
            }
        } while (opcao != 0);

    }
}
