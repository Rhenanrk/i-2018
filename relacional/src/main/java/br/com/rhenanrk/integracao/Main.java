/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.integracao;

import br.com.rhenanrk.dao.*;
import br.com.rhenanrk.dto.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        int opcao = 110;
        do {
            try {
                Scanner leitor = new Scanner(System.in);
                Scanner leitorNumerico = new Scanner(System.in);
                VerificaDadosDao verificaDadosDao = new VerificaDadosDao();


                System.out.print("1 - Inserir nova pessoa\n" +
                        "Opcao: ");
                opcao = leitorNumerico.nextInt();

                switch (opcao) {
                    case 1: // insere pessoa no banco de dados
                        criaIndividuo(leitor, leitorNumerico, verificaDadosDao);


                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Você digitou algo irregular, vamos começar de novo");
                continue;
            }
        } while (opcao != 0);

    }

    private static void criaIndividuo(Scanner leitor, Scanner leitorNumerico, VerificaDadosDao verificaDadosDao) {
        Boolean verificador;
        /*
        criando individuo
         */
        IndividuoDto individuoDto = new IndividuoDto();
        IndividuoDao individuoDao = new IndividuoDao();
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        String surrogateKey = myRandom.substring(0, 10);
        individuoDto.setsurrogateKey(surrogateKey);

//        /*
//        criando nome
//         */
//        NomeDto nomeDto = new NomeDto();
//        NomeDao nomeDao = new NomeDao();
//        String titulos, nomes, sobrenomes, sufixos, inicioUso, fimUso;
//        int preferido, usoCondicional, uso;
//
//        nomeDto.setSurrogateKey(surrogateKey);
//        System.out.println("CADASTRO DE PESSOA, INSIRA AS INFORMACOES REQUISITADAS ABAIXO");
//        System.out.println("\n<==== Cadastrando individuo ====> ");
//        System.out.println("Chave do novo individuo: " + surrogateKey);
//        System.out.print("Titulos: ");
//        titulos = leitor.nextLine();
//        nomeDto.setTitulos(titulos);
//
//        System.out.print("\nNome: ");
//        nomes = leitor.nextLine();
//        nomeDto.setNomes(nomes);
//
//        System.out.print("\nSobrenomes: ");
//        sobrenomes = leitor.nextLine();
//        nomeDto.setSobrenomes(sobrenomes);
//
//        System.out.print("\nSufixos: ");
//        sufixos = leitor.nextLine();
//        nomeDto.setSufixos(sufixos);
//
//        System.out.print("\nPreferido: ");
//        preferido = leitorNumerico.nextInt();
//        nomeDto.setPreferido(preferido);
//
//        System.out.print("\nUso condicional: ");
//        usoCondicional = leitorNumerico.nextInt();
//        nomeDto.setUsoCondicional(usoCondicional);
//
//        System.out.print("\nUso: ");
//        uso = leitorNumerico.nextInt();
//        nomeDto.setUso(uso);
//
//        System.out.print("\nInicio do uso do nome: ");
//        inicioUso = leitor.nextLine();
//        nomeDto.setinicioUso(inicioUso);
//
//        System.out.print("\nFim do uso do nome: ");
//        fimUso = leitor.nextLine();
//        nomeDto.setfimUso(fimUso);
//
//        /*
//        criando representação
//        perguntar se possui representação
//         */
//        System.out.println("\n<==== Cadastrando representacao do nome do individuo ====>");
//        RepresentacaoDto representacaoDto = new RepresentacaoDto();
//        RepresentacaoDao representacaoDao = new RepresentacaoDao();
//        String utilizacao, alternativa;
//
//        representacaoDto.setsurrogateKey(surrogateKey);
//
//        System.out.print("Utilizacao: ");
//        utilizacao = leitor.nextLine();
//        representacaoDto.setUtilizacao(utilizacao);
//
//        System.out.print("\nAlternativa: ");
//        alternativa = leitor.nextLine();
//        representacaoDto.setAlternativa(alternativa);
//
//        /*
//        criando comunicação
//         */
//        System.out.println("\n<==== Cadastrando comunicacao do individuo ====>");
//        ComunicacaoDto comunicacaoDto = new ComunicacaoDto();
//        ComunicacaoDao comunicacaoDao = new ComunicacaoDao();
//        int meio, preferencia, utilizacaoComunicacao;
//        String detalhe;
//
//        comunicacaoDto.setsurrogateKey(surrogateKey);
//
//        System.out.print("Meio de comunicacao: ");
//        meio = leitorNumerico.nextInt();
//        comunicacaoDto.setMeio(meio);
//
//        System.out.print("\nDetalhe do meio de comunicacao: ");
//        detalhe = leitor.nextLine();
//        comunicacaoDto.setDetalhe(detalhe);
//
//        System.out.print("\nPreferencia da comunicacao: ");
//        preferencia = leitorNumerico.nextInt();
//        comunicacaoDto.setPreferencia(preferencia);
//
//        System.out.print("\nUtilizacao: ");
//        utilizacaoComunicacao = leitorNumerico.nextInt();
//        comunicacaoDto.setUtilizacao(utilizacaoComunicacao);
//
//        /*
//        criando identificação
//         */
//        System.out.println("\n<==== Cadastrando identificador do individuo ====>");
//        IdentificadorDto identificadorDto = new IdentificadorDto();
//        IdentificadorDao identificadorDao = new IdentificadorDao();
//        String designacao, dataEmissao, emissor;
//        int area, tipo;
//
//        uuid = UUID.randomUUID();
//        myRandom = uuid.toString();
//        String idCod = myRandom.substring(0, 10);
//
//        identificadorDto.setIdCod(idCod);
//        identificadorDto.setsurrogateKey(surrogateKey);
//
//        System.out.print("Designacao: ");
//        designacao = leitor.nextLine();
//        identificadorDto.setDesignacao(designacao);
//
//        System.out.print("\nArea: ");
//        area = leitorNumerico.nextInt();
//        identificadorDto.setArea(area);
//
//        System.out.print("\nEmissor: ");
//        emissor = leitor.nextLine();
//        identificadorDto.setEmissor(emissor);
//
//        System.out.print("\nData de emissao: ");
//        dataEmissao = leitor.nextLine();
//        identificadorDto.setDataEmissao(dataEmissao);
//
//        System.out.print("\nTipo: ");
//        tipo = leitorNumerico.nextInt();
//        identificadorDto.setTipo(tipo);
//
//        /*
//        criando ctps
//        opcional: pergunta se deseja cadastrar
//         */
//        System.out.println("\n<==== Cadastrando CTPS do individuo ====>");
//        CtpsDto ctpsDto = new CtpsDto();
//        CtpsDao ctpsDao = new CtpsDao();
//        String serie, estado;
//
//        ctpsDto.setIdCod(idCod);
//        ctpsDto.setsurrogateKey(surrogateKey);
//
//        System.out.print("Serie: ");
//        serie = leitor.nextLine();
//        ctpsDto.setSerie(serie);
//
//        System.out.print("\nEstado: ");
//        estado = leitor.nextLine();
//        ctpsDto.setEstado(estado);
//
//        /*
//        criando certidão
//        opcional: pergunta se deseja cadastrar
//         */
//        System.out.println("\n<==== Cadastrando certidao do individuo ====>");
//        CertidaoDto certidaoDto = new CertidaoDto();
//        CertidaoDao certidaoDao = new CertidaoDao();
//        String nomeCartorio;
//        int tipoCertidao, livro, folha, termo;
//
//        certidaoDto.setIdCod(idCod);
//        certidaoDto.setSurrogateKey(surrogateKey);
//
//        System.out.print("Tipo: ");
//        tipoCertidao = leitorNumerico.nextInt();
//        certidaoDto.setTipo(tipoCertidao);
//
//        System.out.print("\nNome do Cartorio: ");
//        nomeCartorio = leitor.nextLine();
//        certidaoDto.setNomeCartorio(nomeCartorio);
//
//        System.out.print("\nLivro: ");
//        livro = leitorNumerico.nextInt();
//        certidaoDto.setLivro(livro);
//
//        System.out.print("\nFolha: ");
//        folha = leitorNumerico.nextInt();
//        certidaoDto.setFolha(folha);
//
//        System.out.print("\nTermo: ");
//        termo = leitorNumerico.nextInt();
//        certidaoDto.setTermo(termo);
//
//        /*
//        criando titulo eleitoral
//        opcional: pergunta se deseja cadastrar
//         */
//        System.out.println("\n<==== Cadastrando titulo eleitoral do individuo ====>");
//        TituloEleitoralDto tituloEleitoralDto = new TituloEleitoralDto();
//        TituloEleitoralDao tituloEleitoralDao = new TituloEleitoralDao();
//        int secao, zona;
//
//        tituloEleitoralDto.setIdCod(idCod);
//        tituloEleitoralDto.setSurrogateKey(surrogateKey);
//
//        System.out.print("Secao: ");
//        secao = leitorNumerico.nextInt();
//        tituloEleitoralDto.setSecao(secao);
//
//        System.out.print("\nZona: ");
//        zona = leitorNumerico.nextInt();
//        tituloEleitoralDto.setZona(zona);
//
//        /*
//        criando vinculo
//        perguntar se usuário possui vinculo com alguma pessoa
//        a pessoa ja deve estar cadastrada
//          */
//        System.out.println("\n<==== Cadastrando vinculo do individuo ====>");
//        VinculoDto vinculoDto = new VinculoDto();
//        VinculoDao vinculoDao = new VinculoDao();
//        String chave, dataInicio, dataFim;
//        int relacionamento;
//
//        System.out.print("Chave da pessoa com quem possui vinculo: ");
//        chave = leitor.nextLine();
//        vinculoDto.setSurrogateKeyPessoaVinculada(chave);
//
//        System.out.print("\nTipo de relacionamento: ");
//        relacionamento = leitorNumerico.nextInt();
//        vinculoDto.setRelacionamento(relacionamento);
//
//        System.out.print("\nData de inicio do relacionamento: ");
//        dataInicio = leitor.nextLine();
//        vinculoDto.setDataInicio(dataInicio);
//
//        System.out.print("\nData de fim do relacionamento: ");
//        dataFim = leitor.nextLine();
//        vinculoDto.setDataFim(dataFim);
//
//        /*
//        criando endereco
//         */
//        verificador = true;
//        System.out.println("\n<==== Cadastrando o endereco do individuo ====>");
//        EnderecoDto enderecoDto = new EnderecoDto();
//        EnderecoDao enderecoDao = new EnderecoDao();
//        int tipoEndereco;
//        String endereco, bairro, distrito, municipio, estadoEndereco, cep, caixaPostal;
//        String pais, dataInicioEndereco, acuraciaIncio, dataFimEndereco, acuraciaFim;
//
//        enderecoDto.setSurrogateKey(surrogateKey);
//
//
//        do {
//            try {
//               System.out.print("Tipo do endereco:\n" +
//                        "(1 - Comercial, 2 - Correio ou postal, 3 - Acomodacao temporaria)\n" +
//                        "(4 - Residencial, 5 - Sem endereco fixo, 6 - Desconhecido/nao declarado)\n " +
//                        "Opcao: ");
//                do {
//                    tipoEndereco = leitorNumerico.nextInt();
//                } while (tipoEndereco <= 0 || tipoEndereco > 6);
//                enderecoDto.setTipo(tipoEndereco);
//
//                System.out.print("\nEndereco: ");
//                endereco = leitor.nextLine();
//                enderecoDto.setEndereco(endereco);
//
//                System.out.print("\nBairro: ");
//                bairro = leitor.nextLine();
//                enderecoDto.setBairro(bairro);
//
//                System.out.print("\nDistrito: ");
//                distrito = leitor.nextLine();
//                enderecoDto.setDistrito(distrito);
//
//                do {
//                    System.out.print("\nMunicipio: ");
//                    municipio = leitor.nextLine();
//                    if (verificaDadosDao.verificaMunicipio(municipio) == null)
//                        System.out.println("Municipio nao existe ou nome inserido incorretamente. Tente novamente");
//                } while (verificaDadosDao.verificaMunicipio(municipio) == null);
//                enderecoDto.setMunicipio(municipio);
//
//                do {
//                    System.out.print("\nEstado: ");
//                    estadoEndereco = leitor.nextLine();
//                    if (verificaDadosDao.verificaEstado(estadoEndereco) == null)
//                        System.out.println("Estado nao existe ou nome inserido incorretamente. Tente novamente");
//                } while (verificaDadosDao.verificaEstado(estadoEndereco) == null);
//                enderecoDto.setEstado(estadoEndereco);
//
//                System.out.print("\nCEP: ");
//                cep = leitor.nextLine();
//                enderecoDto.setCep(cep);
//
//                System.out.print("\nCaixa postal: ");
//                caixaPostal = leitor.nextLine();
//                enderecoDto.setCaixaPostal(caixaPostal);
//
//                do {
//                    System.out.print("\nPais: ");
//                    pais = leitor.nextLine();
//                    if (verificaDadosDao.verificaPais(pais) == null)
//                        System.out.println("Pais nao existe ou nome inserido incorretamente. Tente novamente");
//                } while (verificaDadosDao.verificaPais(pais) == null);
//                enderecoDto.setPais(pais);
//
//                System.out.print("\nInicio do uso deste endereco: ");
//                dataInicioEndereco = leitor.nextLine();
//                enderecoDto.setDataInicio(dataInicioEndereco);
//
//                System.out.print("\nAcuracia da data de inicio de uso: ");
//                acuraciaIncio = leitor.nextLine();
//                enderecoDto.setAcuraciaInicio(acuraciaIncio);
//
//
//                System.out.print("\nFim de uso deste endereco: ");
//                dataFimEndereco = leitor.nextLine();
//                enderecoDto.setDataFim(dataFimEndereco);
//
//                System.out.print("\nAcuracia da data de fim de uso: ");
//                acuraciaFim = leitor.nextLine();
//                enderecoDto.setAcuraciaFim(acuraciaFim);
//            } catch (InputMismatchException e) {
//                System.out.println("Você digitou algo irregular, vamos começar de novo\n");
//                verificador = false;
//                leitorNumerico.next();
//            }
//        } while (!verificador);
//
//        /*
//        criando dado demografico
//         */
//        verificador = true;
//        System.out.println("\n<==== Cadastrando os dados demograficos do individuo ====>");
//        DadoDemograficoDto dadoDemograficoDto = new DadoDemograficoDto();
//        DadoDemograficoDao dadoDemograficoDao = new DadoDemograficoDao();
//        String dataNascimento, nascimentoAcuracia, dataObito, obritoAcuracia, sexo;
//        String nomeMae, nomePai, comentario, paisDado, estadoDado, municipioDado, dataEntradaPais;
//        int fonteNotificacaoObito, situacaoFamiliar, racaCor;
//        int nascimentoPluralidade, nascimentoOrdem, nascimentoSeguimento;
//
//        dadoDemograficoDto.setSurrogateKey(surrogateKey);
//
//        do {
//            try {
//                System.out.print("Data de nascimento: ");
//                dataNascimento = leitor.nextLine();
//                dadoDemograficoDto.setDataNascimento(dataNascimento);
//
//                do {
//                    System.out.print("\nAcuracia da data de nascimento:\n" +
//                            "(A - Acurado, E - Estimado, D - Desconhecido)\n" +
//                            "Opcao: ");
//                    nascimentoAcuracia = leitor.nextLine();
//                    if (!nascimentoAcuracia.equals("A".toLowerCase()) && !nascimentoAcuracia.equals("E".toLowerCase())
//                            && !nascimentoAcuracia.equals("D".toLowerCase()))
//                        System.out.println("Ha algo errado, tente novamente");
//                }
//                while (!nascimentoAcuracia.equals("A".toLowerCase()) && !nascimentoAcuracia.equals("E".toLowerCase())
//                        && !nascimentoAcuracia.equals("D".toLowerCase()));
//                dadoDemograficoDto.setNascimentoAcuracia(nascimentoAcuracia);
//
//                // questiona se o individuo a ser cadastrado possui dados de óbito
//                int opcao;
//                do {
//                    System.out.print("\nDefinir dados de obito?\n" +
//                            "(1 - Sim, 2 - Nao)\n" +
//                            "Opcao: ");
//                    opcao = leitorNumerico.nextInt();
//                } while (opcao <= 0 || opcao > 2);
//
//
//                if (opcao == 1) {
//                    System.out.print("\nData de obito: ");
//                    dataObito = leitor.nextLine();
//                    dadoDemograficoDto.setDataObito(dataObito);
//
//                    do {
//                        System.out.print("\nAcuracia da data de obito:\n" +
//                                "(A - Acurado, E - Estimado, D - Desconhecido)\n" +
//                                "Opcao: ");
//                        obritoAcuracia = leitor.nextLine();
//                        if (!obritoAcuracia.equals("A".toLowerCase()) && !obritoAcuracia.equals("E".toLowerCase())
//                                && !obritoAcuracia.equals("D".toLowerCase()))
//                            System.out.println("Ha algo errado, tente novamente");
//                    } while (!obritoAcuracia.equals("A".toLowerCase()) && !obritoAcuracia.equals("E".toLowerCase())
//                            && !obritoAcuracia.equals("D".toLowerCase()));
//                    dadoDemograficoDto.setObitoAcuracia(obritoAcuracia);
//
//                    do {
//                        System.out.print("\nFonte da notificacao do obito:\n" +
//                                "(1 - Cartório, Prestador de assistência à saúde, 3 - Parente, 4 - Outro, 5 - Desconhecido)\n" +
//                                "Opcao: ");
//                        fonteNotificacaoObito = leitorNumerico.nextInt();
//                        if (fonteNotificacaoObito <= 0 || fonteNotificacaoObito > 5)
//                            System.out.println("Ha algo errado, tente novamente");
//                    } while (fonteNotificacaoObito <= 0 || fonteNotificacaoObito > 5);
//                    dadoDemograficoDto.setFonteNotificacaoObito(fonteNotificacaoObito);
//                }
//
//                do {
//                    System.out.print("\nSexo:\n" +
//                            "(M - Masculino, F - Feminino, I - Intersexo ou indeterminado, N - Não declarado)\n" +
//                            "Opcao: ");
//                    sexo = leitor.nextLine();
//                    if (!sexo.equals("M".toLowerCase()) && !sexo.equals("F".toLowerCase()) && !sexo.equals("I")
//                            && sexo.equals("N"))
//                        System.out.println("Ha algo errado, tente novamente");
//                } while (!sexo.equals("M".toLowerCase()) && !sexo.equals("F".toLowerCase()) && !sexo.equals("I")
//                        && sexo.equals("N") || sexo.equals(""));
//                dadoDemograficoDto.setSexo(sexo);
//
//                System.out.print("\nNome da mae: ");
//                nomeMae = leitor.nextLine();
//                dadoDemograficoDto.setNomeMae(nomeMae);
//
//                System.out.print("\nNome do pai: ");
//                nomePai = leitor.nextLine();
//                dadoDemograficoDto.setNomePai(nomePai);
//
//                do {
//                    System.out.print("\nSituacao familiar:\n" +
//                            "(1 - Companheiro(a) e filho(s), 2 - Companheiro(a) com laços conjugais e sem filhos)\n" +
//                            "(3 - Companheiro(a), com filho(s) e/ou outro(s) familiar(es), 4 - Familiar(es) sem companheiro(a))\n" +
//                            "(5 - Outra(s) pessoa(s) sem laços consanguíneos e/ou laços conjugais, 6 - Vive só)\n" +
//                            "Opcao: ");
//                    situacaoFamiliar = leitorNumerico.nextInt();
//                    if (situacaoFamiliar <= 0 || situacaoFamiliar > 6)
//                        System.out.println("Ha algo errado, tente novamente");
//                } while (situacaoFamiliar <= 0 || situacaoFamiliar > 6);
//                dadoDemograficoDto.setSituacaoFamiliar(situacaoFamiliar);
//
//                do {
//                    System.out.print("\nRaca/Cor:\n" +
//                            "(1 - Branca, 2 - Preta, 3 - Parda, 4 - Amarela, 5 - Indígena)\n" +
//                            "Opcao: ");
//                    racaCor = leitorNumerico.nextInt();
//                    if (racaCor <= 0 || racaCor > 6)
//                        System.out.println("Ha algo errado, tente novamente");
//                } while (racaCor <= 0 || racaCor > 6);
//                dadoDemograficoDto.setRacaCor(racaCor);
//
//                System.out.println("\nComentario: ");
//                comentario = leitor.nextLine();
//                dadoDemograficoDto.setComentario(comentario);
//
//                do {
//                    System.out.print("\nNascimento pluralidade:\n" +
//                            "(1 - Unico, 2 - Gemeos, 3 - Trigemeos, 4 - Quadruplos, 5 - Quintuplos)\n" +
//                            "(6 - Sextuplus, 7 - Outros, 8 - Não declarado\n)" +
//                            "Opcao: ");
//                    nascimentoPluralidade = leitorNumerico.nextInt();
//                    if (nascimentoPluralidade <= 0 || nascimentoPluralidade > 8)
//                        System.out.println("Ha algo errado, tente novamente");
//                } while (nascimentoPluralidade <= 0 || nascimentoPluralidade > 8);
//                dadoDemograficoDto.setNascimentoPluralidade(nascimentoPluralidade);
//
//                do {
//                    System.out.print("\nNascimento ordem:\n" +
//                            "(1 - Unico ou primeiro, 2 - Segundo, 3 - Terceiro, 4 - Quarto, 5 - Quinto)\n" +
//                            "(6 - Sexto, 7 - Outros, 8 - Não declarado\n)" +
//                            "Opcao: ");
//                    nascimentoOrdem = leitorNumerico.nextInt();
//                    if (nascimentoOrdem <= 0 || nascimentoOrdem > 8)
//                        System.out.println("Ha algo errado, tente novamente");
//                } while (nascimentoOrdem <= 0 || nascimentoOrdem > 8);
//                dadoDemograficoDto.setNascimentoOrdem(nascimentoOrdem);
//
//                do {
//                    System.out.print("\nNascimento seguimento:\n" +
//                            "(1 - Data precisa de seguimento, 2 - Data nao precisa de seguimento)\n" +
//                            "Opcao: ");
//                    nascimentoSeguimento = leitorNumerico.nextInt();
//                    if (nascimentoSeguimento <= 0 || nascimentoSeguimento > 2)
//                        System.out.println("Ha algo errado, tente novamente");
//                } while (nascimentoSeguimento <= 0 || nascimentoSeguimento > 2);
//                dadoDemograficoDto.setNascimentoSeguimento(nascimentoSeguimento);
//
//                do {
//                    System.out.print("\nPais de nascimento: ");
//                    paisDado = leitor.nextLine();
//                    if (verificaDadosDao.verificaPais(paisDado) == null)
//                        System.out.println("Pais nao existe ou nome inserido incorretamente. Tente novamente");
//                } while (verificaDadosDao.verificaPais(paisDado) == null);
//                dadoDemograficoDto.setPais(paisDado);
//
//                // verifica se o individuo é brasileiro
//                if (paisDado.toLowerCase().equals("Brasil".toLowerCase())) {
//                    do {
//                        System.out.print("\nEstado de nascimento: ");
//                        estadoDado = leitor.nextLine();
//                        if (verificaDadosDao.verificaEstado(estadoDado) == null)
//                            System.out.println("Estado nao existe ou nome inserido incorretamente. Tente novamente");
//                    } while (verificaDadosDao.verificaEstado(estadoDado) == null);
//                    dadoDemograficoDto.setEstado(estadoDado);
//
//                    do {
//                        System.out.print("\nMunicipio de nascimento: ");
//                        municipioDado = leitor.nextLine();
//                        if (verificaDadosDao.verificaMunicipio(municipioDado) == null)
//                            System.out.println("Municipio nao existe ou nome inserido incorretamente. Tente novamente");
//                    } while (verificaDadosDao.verificaMunicipio(municipioDado) == null);
//                    dadoDemograficoDto.setMunicipio(municipioDado);
//
//                } else {
//                    System.out.print("\nData de entrada no Brasil: ");
//                    dataEntradaPais = leitor.nextLine();
//                    dadoDemograficoDto.setDataEntradaPais(dataEntradaPais);
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Você digitou algo irregular, vamos começar de novo\n");
//                verificador = false;
//                leitorNumerico.next();
//            }
//        } while (!verificador);

//
//        // inserindo dados nas tabelas
//        individuoDao.inserir(individuoDto);
//        nomeDao.inserir(nomeDto);
//        representacaoDao.inserir(representacaoDto);
//        comunicacaoDao.inserir(comunicacaoDto);
//        identificadorDao.inserir(identificadorDto);
//        ctpsDao.inserir(ctpsDto);
//        certidaoDao.inserir(certidaoDto);
//        tituloEleitoralDao.inserir(tituloEleitoralDto);
//        vinculoDao.inserir(vinculoDto);
//        enderecoDao.inserir(enderecoDto);
//        dadoDemograficoDao.inserir(dadoDemograficoDto);
    }
}
