/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.integracao;

import br.com.rhenanrk.dao.*;
import br.com.rhenanrk.dto.*;

import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int opcao;

        do {
            System.out.print("1 - Inserir nova pessoa\n" +
                    "Opcao: ");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1: // insere pessoa no banco de dados

                    // criando individuo
                    IndividuoDto individuoDto = new IndividuoDto();
                    IndividuoDao individuoDao = new IndividuoDao();
                    UUID uuid = UUID.randomUUID();
                    String myRandom = uuid.toString();
                    String surrogateKey = myRandom.substring(0, 10);
                    individuoDto.setsurrogateKey(surrogateKey);

                    // criando nome
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

                    // criando representação
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

                    // criando identificação
                    IdentificadorDto identificadorDto = new IdentificadorDto();
                    IdentificadorDao identificadorDao = new IdentificadorDao();
                    String designacao, dataEmissao, emissor;
                    int area, tipo;

                    uuid = UUID.randomUUID();
                    myRandom = uuid.toString();
                    String idCod = myRandom.substring(0, 10);

                    identificadorDto.setIdCod(idCod);
                    identificadorDto.setsurrogateKey(surrogateKey);

                    System.out.print("\nDesignacao: ");
                    designacao = leitor.next();
                    identificadorDto.setDesignacao(designacao);

                    System.out.print("\nArea: ");
                    area = leitor.nextInt();
                    identificadorDto.setArea(area);

                    System.out.print("\nEmissor: ");
                    emissor = leitor.next();
                    identificadorDto.setEmissor(emissor);

                    System.out.print("\nData de emissao: ");
                    dataEmissao = leitor.next();
                    identificadorDto.setDataEmissao(dataEmissao);

                    System.out.print("\nTipo: ");
                    tipo = leitor.nextInt();
                    identificadorDto.setTipo(tipo);

                    // criando ctps

                    CtpsDto ctpsDto = new CtpsDto();
                    CtpsDao ctpsDao = new CtpsDao();
                    String serie, estado;

                    ctpsDto.setIdCod(idCod);
                    ctpsDto.setsurrogateKey(surrogateKey);

                    System.out.print("\nSerie: ");
                    serie = leitor.next();
                    ctpsDto.setSerie(serie);

                    System.out.print("\nEstado: ");
                    estado = leitor.next();
                    ctpsDto.setEstado(estado);

                    // criando certidão
                    CertidaoDto certidaoDto = new CertidaoDto();
                    CertidaoDao certidaoDao = new CertidaoDao();
                    String nomeCartorio;
                    int tipoCertidao, livro, folha, termo;

                    certidaoDto.setIdCod(idCod);
                    certidaoDto.setSurrogateKey(surrogateKey);

                    System.out.print("\nTipo: ");
                    tipoCertidao = leitor.nextInt();
                    certidaoDto.setTipo(tipoCertidao);

                    System.out.print("\nNome do Cartorio: ");
                    nomeCartorio = leitor.next();
                    certidaoDto.setNomeCartorio(nomeCartorio);

                    System.out.print("\nLivro: ");
                    livro = leitor.nextInt();
                    certidaoDto.setLivro(livro);

                    System.out.print("\nFolha: ");
                    folha = leitor.nextInt();
                    certidaoDto.setFolha(folha);

                    System.out.print("\nTermo: ");
                    termo = leitor.nextInt();
                    certidaoDto.setTermo(termo);



                    // inserindo dados nas tabelas
                    individuoDao.inserir(individuoDto);
                    nomeDao.inserir(nomeDto);
                    representacaoDao.inserir(representacaoDto);
                    identificadorDao.inserir(identificadorDto);
                    ctpsDao.inserir(ctpsDto);
                    certidaoDao.inserir(certidaoDto);

                    break;
            }
        } while (opcao != 0);

    }
}
