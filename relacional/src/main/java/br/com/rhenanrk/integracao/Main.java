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

/**
 * Classe principal da aplicação.
 * A partir daqui, todas as operações são executadas.
 */
public class Main {

    /**
     * Método principal do programa.
     * O usuário deve escolher entre 1 -inserir um novo usuário (as informações do novo usuário serão requisitadas,
     * 2- localizar um usuário, onde será requisitado alguns parametros de identificação (nome, nome da mãe, data de
     * nascimento e sexo, 3 - atualizar um usuário, onde serão pedidos os dados de identificação anteriores e por seguinte
     * os novos dados do usuário e por fim 4 - consultar um usuário, onde será requisitado os dados de identificacao
     * do indivíduo e seus dados serão exibidos.
     *
     * @param args
     */
    public static void main(String[] args) {
        int opcao = 9;
        do {
            try {
                Scanner leitor = new Scanner(System.in);
                Scanner leitorNumerico = new Scanner(System.in);
                VerificaDadosDao verificaDadosDao = new VerificaDadosDao();

                System.out.print("\n1 - Inserir nova pessoa\n" +
                        "2 - Localizar pessoa\n" +
                        "3 - Atualizar pessoa\n" + // não implementado
                        "4 - Consultar pessoa\n" + // não implementado
                        "0 - Sair\n" +
                        "Opcao: ");
                opcao = leitorNumerico.nextInt();

                switch (opcao) {
                    case 1: // insere pessoa no banco de dados
                        criaIndividuo(leitor, leitorNumerico, verificaDadosDao);
                        break;
                    case 2:
                        localizaPessoa(leitor, verificaDadosDao);
                        break;
                    case 3:
                        atualizaDados(leitor, leitorNumerico, verificaDadosDao);
                        break;
                    case 4:
                        consultaPessoa(leitor, verificaDadosDao);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nVocê digitou algo irregular, vamos começar de novo");
            }
        } while (opcao != 0);
    }

    /**
     * Método responsável por criar um novo indivíduo. Seus dados serão requisitados e, se tudo ocorrer bem, serão
     * gravados no banco de dados.
     *
     * @param leitor
     * @param leitorNumerico
     * @param verificaDadosDao
     */
    private static void criaIndividuo(Scanner leitor, Scanner leitorNumerico, VerificaDadosDao verificaDadosDao) {
        // Verifica se individuo ja existe
        String nome, nomeMae, dataNascimento, sexo;
        System.out.print("Informe o nome completo do individuo: ");
        nome = leitor.nextLine();
        System.out.print("Informe o nome da mae do individuo: ");
        nomeMae = leitor.nextLine();
        System.out.print("Informe a data de nascimento do individuo: ");
        dataNascimento = leitor.nextLine();
        System.out.print("Informe o sexo do individuo: \n" +
                "(M - Masculino, F - Feminino, I - Intersexo ou indeterminado, N - Não declarado)\n" +
                "Opcao: ");
        sexo = leitor.nextLine();

        if (verificaDadosDao.localizaIndividuo(nome, nomeMae, dataNascimento, sexo)) {
            System.out.println("\nEsta pessoa ja se encontra cadastrada na base de dados\n" +
                    "Deseja atualizar os dados?\n" +
                    "(1 - Sim, 2 - Nao)\n" +
                    "Opcao: ");
            int opcao = leitorNumerico.nextInt();
            if (opcao == 1)
                System.out.println("Executar atualizacao");
        } else
            try {
            /*
            Criando instancias
             */
                IndividuoDto individuoDto = new IndividuoDto();
                IndividuoDao individuoDao = new IndividuoDao();

                NomeDto nomeDto = new NomeDto();
                NomeDao nomeDao = new NomeDao();

                RepresentacaoDto representacaoDto = new RepresentacaoDto();
                RepresentacaoDao representacaoDao = new RepresentacaoDao();

                ComunicacaoDto comunicacaoDto = new ComunicacaoDto();
                ComunicacaoDao comunicacaoDao = new ComunicacaoDao();

                IdentificadorDto identificadorDto = new IdentificadorDto();
                IdentificadorDao identificadorDao = new IdentificadorDao();

                CtpsDto ctpsDto = new CtpsDto();
                CtpsDao ctpsDao = new CtpsDao();

                CertidaoDto certidaoDto = new CertidaoDto();
                CertidaoDao certidaoDao = new CertidaoDao();

                TituloEleitoralDto tituloEleitoralDto = new TituloEleitoralDto();
                TituloEleitoralDao tituloEleitoralDao = new TituloEleitoralDao();

                VinculoDto vinculoDto = new VinculoDto();
                VinculoDao vinculoDao = new VinculoDao();

                EnderecoDto enderecoDto = new EnderecoDto();
                EnderecoDao enderecoDao = new EnderecoDao();

                DadoDemograficoDto dadoDemograficoDto = new DadoDemograficoDto();
                DadoDemograficoDao dadoDemograficoDao = new DadoDemograficoDao();
        /*
        criando individuo
         */
                boolean verificador;

                UUID uuid = UUID.randomUUID();
                String myRandom = uuid.toString();
                String surrogateKey = myRandom.substring(0, 10);
                individuoDto.setsurrogateKey(surrogateKey);

                System.out.println("\nCADASTRO DE PESSOA, INSIRA AS INFORMACOES REQUISITADAS ABAIXO");
                System.out.println("<==== Cadastrando individuo ====> ");
                System.out.println("<==== Chave do novo individuo: " + surrogateKey + " ====>\n");


        /*
        criando nome
         */
                boolean novoNome;
                do {
                    novoNome = true;

                    nomeDto.setSurrogateKey(surrogateKey);
                    leNome(leitor, leitorNumerico, nomeDto);

                    // questiona se deseja criar outro nome para o mesmo individuo. Chave é mantida
                    System.out.print("\nDeseja inserir outro nome para este mesmo individuo?\n" +
                            "(1 - Sim, 2 - Nao)\n" +
                            "Opcao: ");
                    int opcao = leitorNumerico.nextInt();
                    if (opcao == 1)
                        novoNome = false;
                } while (!novoNome);


        /*
        criando representação
        pergunta se possui representação
         */
                System.out.print("\nDeseja criar representacao para o nome: " +
                        "(1 - Sim, 2 - Nao)\n" +
                        "Opcao: ");
                int opcao = leitorNumerico.nextInt();
                if (opcao == 1) {
                    System.out.println("\n<==== Cadastrando representacao do nome do individuo ====>");
                    String utilizacao, alternativa;

                    representacaoDto.setsurrogateKey(surrogateKey);

                    System.out.print("Utilizacao: ");
                    utilizacao = leitor.nextLine();
                    representacaoDto.setUtilizacao(utilizacao);

                    System.out.print("\nAlternativa: ");
                    alternativa = leitor.nextLine();
                    representacaoDto.setAlternativa(alternativa);
                }

        /*
        criando comunicação
         */
                System.out.println("\n<==== Cadastrando comunicacao do individuo ====>");
                int meio, preferencia, utilizacaoComunicacao;
                String detalhe;

                comunicacaoDto.setsurrogateKey(surrogateKey);

                do {
                    verificador = true;
                    try {
                        do {
                            System.out.print("Meio de comunicacao:\n" +
                                    "(1 - Telefone, 2 - Celular, 3 - Fax, 4 - Pager, 5 - Email, 6 - URL)\n" +
                                    "(7 - Outro)\n" +
                                    "Opcao: ");
                            meio = leitorNumerico.nextInt();
                            if (meio <= 0 || meio > 7)
                                System.out.println("Ha algo errado, tente novamente");
                        } while (meio <= 0 || meio > 7);
                        comunicacaoDto.setMeio(meio);

                        System.out.print("\nDetalhe do meio de comunicacao: ");
                        detalhe = leitor.nextLine();
                        comunicacaoDto.setDetalhe(detalhe);

                        do {
                            System.out.print("\nPreferencia da comunicacao:\n" +
                                    "(1 - Horario comercial, 2 - Durante o dia, 3 - Finais de semana)\n" +
                                    "(4 - Qualquer hora, 5 - Periodo noturno)\n" +
                                    "Opcao: ");
                            preferencia = leitorNumerico.nextInt();
                            if (preferencia <= 0 || preferencia > 5)
                                System.out.println("Ha algo errado, tente novamente");
                        } while (preferencia <= 0 || preferencia > 5);
                        comunicacaoDto.setPreferencia(preferencia);

                        do {
                            System.out.print("\nUtilizacao:\n" +
                                    "(1 - Comercial, 2 - Pessoal, 3 - Comercial ou pessoal)\n" +
                                    "Opcao: ");
                            utilizacaoComunicacao = leitorNumerico.nextInt();
                            if (utilizacaoComunicacao <= 0 || utilizacaoComunicacao > 3)
                                System.out.println("Ha algo errado, tente novamente");
                        } while (utilizacaoComunicacao <= 0 || utilizacaoComunicacao > 3);
                        comunicacaoDto.setUtilizacao(utilizacaoComunicacao);

                    } catch (InputMismatchException e) {
                        System.out.println("\nVocê digitou algo irregular, vamos começar de novo\n");
                        verificador = false;
                        leitorNumerico.next();
                    }
                } while (!verificador);

                int tipoIdentificador = 0;
        /*
        criando identificação
         */
                System.out.println("\n<==== Cadastrando identificador do individuo ====>");
                String designacao, dataEmissao, emissor;
                int area;

                uuid = UUID.randomUUID();
                myRandom = uuid.toString();
                String idCod = myRandom.substring(0, 10);

                identificadorDto.setIdCod(idCod);
                identificadorDto.setsurrogateKey(surrogateKey);

                do {
                    verificador = true;
                    try {
                        System.out.print("Designacao: ");
                        designacao = leitor.nextLine();
                        identificadorDto.setDesignacao(designacao);

                        do {
                            System.out.print("\nArea:\n" +
                                    "(1 - Identificador local, 2 - Identificador de área, região ou distrito)\n" +
                                    "(3 - Identificador de estado,província ou território, 4 - Identificador nacional)\n" +
                                    "Opcao: ");
                            area = leitorNumerico.nextInt();
                            if (area <= 0 || area > 4)
                                System.out.println("Ha algo errado, tente novamente");
                        } while (area <= 0 || area > 4);
                        identificadorDto.setArea(area);

                        do {
                            System.out.print("\nEmissor: ");
                            emissor = leitor.nextLine();
                            if (verificaDadosDao.verificaOrgaoEmissor(emissor) == null)
                                System.out.println("Orgao emissor nao existe ou nome inserido incorretamente. Tente novamente");
                        } while (verificaDadosDao.verificaOrgaoEmissor(emissor) == null);
                        identificadorDto.setEmissor(emissor);

                        System.out.print("\nData de emissao: ");
                        dataEmissao = leitor.nextLine();
                        identificadorDto.setDataEmissao(dataEmissao);

                        System.out.print("\nTipo:\n" +
                                "(1 - CTPS, 2 - Certidao, 3 - Titulo Eleitoral, 4 - Outro identificador)\n" +
                                "Opcao: ");
                        tipoIdentificador = leitorNumerico.nextInt();
                        identificadorDto.setTipo(tipoIdentificador);

                    } catch (InputMismatchException e) {
                        System.out.println("\nVocê digitou algo irregular, vamos começar de novo\n");
                        verificador = false;
                        leitorNumerico.next();
                    }
                } while (!verificador);

            /*
            verifica de o tipo do identificador é CTPS
            criando ctps
            opcional: pergunta se deseja cadastrar
             */
                if (tipoIdentificador == 1) {
                    System.out.println("\n<==== Cadastrando CTPS do individuo ====>");
                    String serie, estado;

                    ctpsDto.setIdCod(idCod);
                    ctpsDto.setsurrogateKey(surrogateKey);

                    do {
                        verificador = true;
                        try {
                            System.out.print("Serie: ");
                            serie = leitor.nextLine();
                            ctpsDto.setSerie(serie);

                            do {
                                System.out.print("\nEstado emissor: ");
                                estado = leitor.nextLine();
                                if (verificaDadosDao.verificaEstado(estado) == null)
                                    System.out.println("Estado nao existe ou nome inserido incorretamente. Tente novamente");
                            } while (verificaDadosDao.verificaEstado(estado) == null);
                            ctpsDto.setEstado(estado);

                        } catch (InputMismatchException e) {
                            System.out.println("\nVocê digitou algo irregular, vamos começar de novo\n");
                            verificador = false;
                            leitorNumerico.next();
                        }
                    } while (!verificador);
                }

            /*
            verifica de o tipo do identificador é certidão
            criando certidão
            opcional: pergunta se deseja cadastrar
             */
                if (tipoIdentificador == 2) {
                    System.out.println("\n<==== Cadastrando certidao do individuo ====>");
                    String nomeCartorio;
                    int tipoCertidao, livro, folha, termo;

                    certidaoDto.setIdCod(idCod);
                    certidaoDto.setSurrogateKey(surrogateKey);

                    do {
                        verificador = true;
                        try {
                            System.out.print("Tipo da certidao:\n" +
                                    "(1 - Nascimento, 2 - Casamento, 3 - Divorcio)\n" +
                                    "Opcao: ");
                            tipoCertidao = leitorNumerico.nextInt();
                            certidaoDto.setTipo(tipoCertidao);

                            System.out.print("\nNome do Cartorio: ");
                            nomeCartorio = leitor.nextLine();
                            certidaoDto.setNomeCartorio(nomeCartorio);

                            System.out.print("\nLivro: ");
                            livro = leitorNumerico.nextInt();
                            certidaoDto.setLivro(livro);

                            System.out.print("\nFolha: ");
                            folha = leitorNumerico.nextInt();
                            certidaoDto.setFolha(folha);

                            System.out.print("\nTermo: ");
                            termo = leitorNumerico.nextInt();
                            certidaoDto.setTermo(termo);

                        } catch (InputMismatchException e) {
                            System.out.println("\nVocê digitou algo irregular, vamos começar de novo\n");
                            verificador = false;
                            leitorNumerico.next();
                        }
                    } while (!verificador);
                }

            /*
            verifica se o tipo do identificador é titulo eleitoral
            criando titulo eleitoral
            opcional: pergunta se deseja cadastrar
             */
                if (tipoIdentificador == 3) {
                    System.out.println("\n<==== Cadastrando titulo eleitoral do individuo ====>");
                    int secao, zona;

                    tituloEleitoralDto.setIdCod(idCod);
                    tituloEleitoralDto.setSurrogateKey(surrogateKey);

                    do {
                        verificador = true;
                        try {
                            System.out.print("Secao: ");
                            secao = leitorNumerico.nextInt();
                            tituloEleitoralDto.setSecao(secao);

                            System.out.print("\nZona: ");
                            zona = leitorNumerico.nextInt();
                            tituloEleitoralDto.setZona(zona);

                        } catch (InputMismatchException e) {
                            System.out.println("\nVocê digitou algo irregular, vamos começar de novo\n");
                            verificador = false;
                            leitorNumerico.next();
                        }
                    } while (!verificador);
                }

        /*
        criando vinculo
        pergunta se usuário possui vinculo com alguma pessoa
        a pessoa ja deve estar cadastrada
          */
                String chave = "";
                do {
                    System.out.print("\nDeseja adicionar algum vinculo?\n" +
                            "(1 - Sim, 2 - Nao)\n" +
                            "Opcao: ");
                    opcao = leitorNumerico.nextInt();

                    if (opcao == 1) {
                        System.out.print("Chave da pessoa com quem possui vinculo: ");
                        chave = leitor.nextLine();
                        if (verificaDadosDao.verificaSurrogateKey(chave) == null)
                            System.out.println("Pessoa nao existe ou nome inserido incorretamente. Tente novamente\n");
                        vinculoDto.setSurrogateKeyPessoaVinculada(chave);
                    }
                } while (verificaDadosDao.verificaSurrogateKey(chave) == null && opcao == 1);


                if (opcao == 1) {
                    System.out.println("\n<==== Cadastrando vinculo do individuo ====>");
                    String dataInicio, dataFim, relacionamento;
                    vinculoDto.setSurrogateKey(surrogateKey);

                    do {
                        verificador = true;
                        try {
                            do {
                                System.out.print("\nTipo de relacionamento: ");
                                relacionamento = leitor.nextLine();
                                if (verificaDadosDao.verificaRelacionamento(relacionamento) == null)
                                    System.out.println("Relacionamento nao existe ou tipo inserido incorretamente. Tente novamente");
                            } while (verificaDadosDao.verificaRelacionamento(relacionamento) == null);
                            vinculoDto.setRelacionamento(relacionamento);

                            System.out.print("\nData de inicio do relacionamento: ");
                            dataInicio = leitor.nextLine();
                            vinculoDto.setDataInicio(dataInicio);

                            System.out.print("\nData de fim do relacionamento: ");
                            dataFim = leitor.nextLine();
                            vinculoDto.setDataFim(dataFim);

                        } catch (InputMismatchException e) {
                            System.out.println("\nVocê digitou algo irregular, vamos começar de novo\n");
                            verificador = false;
                            leitorNumerico.next();
                        }
                    } while (!verificador);
                }

        /*
        criando endereco
         */
                System.out.println("\n<==== Cadastrando o endereco do individuo ====>");

                enderecoDto.setSurrogateKey(surrogateKey);
                leEndereco(leitor, leitorNumerico, verificaDadosDao, enderecoDto);

        /*
        criando dado demografico
         */
                System.out.println("\n<==== Cadastrando os dados demograficos do individuo ====>");

                dadoDemograficoDto.setSurrogateKey(surrogateKey);
                leDadoDemografico(leitor, leitorNumerico, verificaDadosDao, dadoDemograficoDto);

        /*
        Inserindo tabelas no banco de dados
         */
                individuoDao.inserir(individuoDto);
                identificadorDao.inserir(identificadorDto);
                nomeDao.inserir(nomeDto);
                representacaoDao.inserir(representacaoDto);
                comunicacaoDao.inserir(comunicacaoDto);
                ctpsDao.inserir(ctpsDto);
                certidaoDao.inserir(certidaoDto);
                tituloEleitoralDao.inserir(tituloEleitoralDto);
                vinculoDao.inserir(vinculoDto);
                enderecoDao.inserir(enderecoDto);
                dadoDemograficoDao.inserir(dadoDemograficoDto);

            } catch (Exception e) {
                System.out.println("Algo de errado ocorreu!");
            }
    }

    /**
     * Método responsável por localizar um indivíduo no banco de dados.
     *
     * @param leitor
     * @param verificaDadosDao
     */
    private static void localizaPessoa(Scanner leitor, VerificaDadosDao verificaDadosDao) {
        String nome, nomeMae, dataNascimento, sexo;
        System.out.print("Informe o nome completo do individuo: ");
        nome = leitor.nextLine();
        System.out.print("Informe o nome da mae do individuo: ");
        nomeMae = leitor.nextLine();
        System.out.print("Informe a data de nascimento do individuo: ");
        dataNascimento = leitor.nextLine();
        System.out.print("Informe o sexo do individuo: \n" +
                "(M - Masculino, F - Feminino, I - Intersexo ou indeterminado, N - Não declarado)\n" +
                "Opcao: ");
        sexo = leitor.nextLine();

        if (verificaDadosDao.localizaIndividuo(nome, nomeMae, dataNascimento, sexo))
            System.out.println("Pessoa localizada com sucesso!");
        else
            System.out.println("Pessoa nao localizada na base de dados!");
    }

    /**
     * Método responsável por atualizar um indivíduo no banco de dados.
     *
     * @param leitor
     * @param leitorNumerico
     * @param verificaDadosDao
     */
    private static void atualizaDados(Scanner leitor, Scanner leitorNumerico, VerificaDadosDao verificaDadosDao) {
        System.out.print("O que deseja atualizar:\n" +
                "(1 - Nome, 2 - Endereco, 3 - Dado Demografico)\n" +
                "Opcao: ");
        int opcao = leitorNumerico.nextInt();
        String surrogateKey;

        switch (opcao) {
            case 1:
                NomeDto nomeDto = new NomeDto();
                NomeDao nomeDao = new NomeDao();

                System.out.print("\nInforme a chave do usuario que deseja atualizar: ");
                surrogateKey = leitor.nextLine();

                leNome(leitor, leitorNumerico, nomeDto);
                nomeDao.atualizaNome(surrogateKey, nomeDto);
                break;

            case 2:
                EnderecoDto enderecoDto = new EnderecoDto();
                EnderecoDao enderecoDao = new EnderecoDao();

                System.out.print("\nInforme a chave do usuario que deseja atualizar: ");
                surrogateKey = leitor.nextLine();

                leEndereco(leitor, leitorNumerico, verificaDadosDao, enderecoDto);
                enderecoDao.atualizaEndereco(surrogateKey, enderecoDto);
                break;

            case 3:
                DadoDemograficoDto dadoDemograficoDto = new DadoDemograficoDto();
                DadoDemograficoDao dadoDemograficoDao = new DadoDemograficoDao();

                System.out.print("\nInforme a chave do usuario que deseja atualizar: ");
                surrogateKey = leitor.nextLine();

                leDadoDemografico(leitor, leitorNumerico, verificaDadosDao, dadoDemograficoDto);
                dadoDemograficoDao.atualizadaDados(surrogateKey, dadoDemograficoDto);
                break;
        }
    }

    /**
     * Método responsável por consultar os dados de um indivíduo no banco de dados.
     *
     * @param leitor
     * @param verificaDadosDao
     */
    private static void consultaPessoa(Scanner leitor, VerificaDadosDao verificaDadosDao) {
        String nome, nomeMae, dataNascimento, sexo;
        System.out.print("Informe o nome completo do individuo: ");
        nome = leitor.nextLine();
        System.out.print("Informe o nome da mae do individuo: ");
        nomeMae = leitor.nextLine();
        System.out.print("Informe a data de nascimento do individuo: ");
        dataNascimento = leitor.nextLine();
        System.out.print("Informe o sexo do individuo: \n" +
                "(M - Masculino, F - Feminino, I - Intersexo ou indeterminado, N - Não declarado)\n" +
                "Opcao: ");
        sexo = leitor.nextLine();

        if (verificaDadosDao.localizaIndividuo(nome, nomeMae, dataNascimento, sexo)) {
            NomeDao nomeDao = new NomeDao();
            NomeDto nomeDto;
            nomeDto = nomeDao.consultaNome(verificaDadosDao.retornaSurrogateKey(nome,
                    nomeMae, dataNascimento, sexo));
            System.out.println("\n<==== Dados de nome ====>");
            System.out.println("Nome completo: " + nomeDto.getNomeCompleto());
            System.out.println("Preferido: " + nomeDto.getPreferido());
            System.out.println("Uso condicional: " + nomeDto.getUsoCondicional());
            System.out.println("Uso: " + nomeDto.getUso());
            System.out.println("Inicio do uso deste nome: " + nomeDto.getInicioUso());
            System.out.println("Fim do uso deste nome: " + nomeDto.getFimUso());

            IdentificadorDao identificadorDao = new IdentificadorDao();
            IdentificadorDto identificadorDto;
            identificadorDto = identificadorDao.consultaIdentificador(verificaDadosDao.retornaSurrogateKey(nome,
                    nomeMae, dataNascimento, sexo));
            System.out.println("\n<==== Dados de identificacao ====>");
            System.out.println("Designacao: " + identificadorDto.getDesignacao());
            System.out.println("Area: " + identificadorDto.getArea());
            System.out.println("Emissor: " + identificadorDto.getEmissor());
            System.out.println("Data de emissao: " + identificadorDto.getDataEmissao());
            System.out.println("Tipo de identificador: " + identificadorDto.getTipo());

            // (1 - CTPS, 2 - Certidao, 3 - Titulo Eleitoral, 4 - Outro identificador)
            switch (identificadorDto.getTipo()) {
                case 1:
                    CtpsDao ctpsDao = new CtpsDao();
                    CtpsDto ctpsDto;
                    ctpsDto = ctpsDao.consultaCtps(verificaDadosDao.retornaSurrogateKey(nome,
                            nomeMae, dataNascimento, sexo), identificadorDto.getIdCod());
                    System.out.println("\n<==== Dados de carteira de trabalho e previdencia social ====>");
                    System.out.println("Serie: " + ctpsDto.getSerie());
                    System.out.println("Estado: " + ctpsDto.getEstado());
                    break;

                case 2:
                    CertidaoDao certidaoDao = new CertidaoDao();
                    CertidaoDto certidaoDto;
                    certidaoDto = certidaoDao.consultaCertidao(verificaDadosDao.retornaSurrogateKey(nome,
                            nomeMae, dataNascimento, sexo), identificadorDto.getIdCod());
                    System.out.println("\n<==== Dados de certidao ====>");
                    System.out.println("Tipo de certidao: " + certidaoDto.getTipo());
                    System.out.println("Nome do cartorio: " + certidaoDto.getNomeCartorio());
                    System.out.println("Livro: " + certidaoDto.getLivro());
                    System.out.println("Folha: " + certidaoDto.getFolha());
                    System.out.println("Termo: " + certidaoDto.getTermo());
                    break;

                case 3:
                    TituloEleitoralDao tituloEleitoralDao = new TituloEleitoralDao();
                    TituloEleitoralDto tituloEleitoralDto;
                    tituloEleitoralDto = tituloEleitoralDao.consultaTituloEleitoral(verificaDadosDao.retornaSurrogateKey(nome,
                            nomeMae, dataNascimento, sexo), identificadorDto.getIdCod());
                    System.out.println("\n<==== Dados de titulo eleitoral ====>");
                    System.out.println("Secao: " + tituloEleitoralDto.getSecao());
                    System.out.println("Zona: " + tituloEleitoralDto.getZona());
                    break;
            }

            DadoDemograficoDao dadoDemograficoDao = new DadoDemograficoDao();
            DadoDemograficoDto dadoDemograficoDto;
            dadoDemograficoDto = dadoDemograficoDao.consultaDadoDemografico(verificaDadosDao.retornaSurrogateKey(nome,
                    nomeMae, dataNascimento, sexo));
            System.out.println("\n<==== Dados demograficos ====>");
            System.out.println("Data de nascimento: " + dadoDemograficoDto.getDataNascimento());
            System.out.println("Acuracia da data de nascimento: " + dadoDemograficoDto.getNascimentoAcuracia());
            System.out.println("Data de obito: " + dadoDemograficoDto.getDataObito());
            System.out.println("Acuracia da data de obito: " + dadoDemograficoDto.getObitoAcuracia());
            System.out.println("Fonte da notificacao do obito: " + dadoDemograficoDto.getFonteNotificacaoObito());
            System.out.println("Sexo: " + dadoDemograficoDto.getSexo());
            System.out.println("Nome da mae: " + dadoDemograficoDto.getNomeMae());
            System.out.println("Nome do pai: " + dadoDemograficoDto.getNomePai());
            System.out.println("Situacao familiar: " + dadoDemograficoDto.getSituacaoFamiliar());
            System.out.println("Raca/cor: " + dadoDemograficoDto.getRacaCor());
            System.out.println("Comentario: " + dadoDemograficoDto.getComentario());
            System.out.println("Nascimento pluralidade: " + dadoDemograficoDto.getNascimentoPluralidade());
            System.out.println("Nascimento ordem: " + dadoDemograficoDto.getNascimentoOrdem());
            System.out.println("Nascimento seguimento: " + dadoDemograficoDto.getNascimentoSeguimento());
            System.out.println("Pais de nascimento: " + dadoDemograficoDto.getPais());
            System.out.println("Estado de nascimento: " + dadoDemograficoDto.getEstado());
            System.out.println("Municipio de nascimento: " + dadoDemograficoDto.getMunicipio());
            System.out.println("Data de entrada no Brasil: " + dadoDemograficoDto.getDataEntradaPais());

            ComunicacaoDao comunicacaoDao = new ComunicacaoDao();
            ComunicacaoDto comunicacaoDto;
            comunicacaoDto = comunicacaoDao.consultaComunicacao(verificaDadosDao.retornaSurrogateKey(nome,
                    nomeMae, dataNascimento, sexo));
            System.out.println("\n<==== Dados de comunicacao ====>");
            System.out.println("Meio de comunicacao: " + comunicacaoDto.getMeio());
            System.out.println("Detalhe do meio: " + comunicacaoDto.getDetalhe());
            System.out.println("Preferencia da comunicação: " + comunicacaoDto.getPreferencia());
            System.out.println("Utilizacao deste meio de comunicacao: " + comunicacaoDto.getUtilizacao());

            VinculoDao vinculoDao = new VinculoDao();
            VinculoDto vinculoDto;
            vinculoDto = vinculoDao.consultaVinculo(verificaDadosDao.retornaSurrogateKey(nome,
                    nomeMae, dataNascimento, sexo));
            System.out.println("\n<==== Dados de vinculo ====>");
            System.out.println("Chave da pessoa vinculada: " + vinculoDto.getSurrogateKeyPessoaVinculada());
            System.out.println("Tipo de relacionamento: " + vinculoDto.getRelacionamento());
            System.out.println("Data de inicio do relacionamento: " + vinculoDto.getDataInicio());
            System.out.println("Data de fim do relacionamento: " + vinculoDto.getDataFim());

            EnderecoDao enderecoDao = new EnderecoDao();
            EnderecoDto enderecoDto;
            enderecoDto = enderecoDao.consultaEndereco(verificaDadosDao.retornaSurrogateKey(nome,
                    nomeMae, dataNascimento, sexo));
            System.out.println("\n<==== Dados de endereco ====>");
            System.out.println("Tipo de endereco: " + enderecoDto.getTipo());
            System.out.println("Endereco: " + enderecoDto.getEndereco());
            System.out.println("Bairro: " + enderecoDto.getBairro());
            System.out.println("Distrito: " + enderecoDto.getDistrito());
            System.out.println("Municipio: " + enderecoDto.getMunicipio());
            System.out.println("Estado: " + enderecoDto.getEstado());
            System.out.println("CEP: " + enderecoDto.getCep());
            System.out.println("Caixa postal: " + enderecoDto.getCaixaPostal());
            System.out.println("Pais: " + enderecoDto.getPais());
            System.out.println("Data de inicio de residencia no pais: " + enderecoDto.getDataInicio());
            System.out.println("Acuracia da data de inicio: " + enderecoDto.getAcuraciaInicio());
            System.out.println("Data de saida do pais: " + enderecoDto.getDataFim());
            System.out.println("Acuracia da data de saida do pais: " + enderecoDto.getAcuraciaFim());

        } else
            System.out.println("Pessoa nao localizada na base de dados!");
    }

    /**
     * Método responsável por ler os dados de nome de um individuo.
     *
     * @param leitor
     * @param leitorNumerico
     * @param nomeDto
     */
    private static void leNome(Scanner leitor, Scanner leitorNumerico, NomeDto nomeDto) {
        boolean verificador;
        String titulos = "", sufixos = "";
        String nomes;
        String sobrenomes;
        int preferido;
        int usoCondicional;
        int uso;
        String inicioUso;
        String fimUso;
        do {
            verificador = true;
            try {
                System.out.print("Possui titulo:\n" +
                        "(1 - Sim, 2 - Nao)\n" +
                        "Opcao: ");
                int opcao = leitorNumerico.nextInt();
                if (opcao == 1) {
                    System.out.print("Titulos: ");
                    titulos = leitor.nextLine() + " ";
                    nomeDto.setTitulos(titulos);
                }

                System.out.print("\nNome: ");
                nomes = leitor.nextLine() + " ";
                nomeDto.setNomes(nomes);

                System.out.print("\nSobrenomes: ");
                sobrenomes = leitor.nextLine();
                nomeDto.setSobrenomes(sobrenomes);

                System.out.print("\nPossui sufixo:\n" +
                        "(1 - Sim, 2 - Nao)\n" +
                        "Opcao: ");
                opcao = leitorNumerico.nextInt();
                if (opcao == 1) {
                    System.out.print("\nSufixos: ");
                    sufixos = " " + leitor.nextLine();
                    nomeDto.setSufixos(sufixos);
                }

                nomeDto.setNomeCompleto(titulos + nomes + sobrenomes + sufixos);

                do {
                    System.out.print("\nPreferido:\n" +
                            "(1 - Este é o nome preferido. Deve ser usado, exceto se um uso específico, " +
                            "comentado adiante, indicar o uso de outro nome)\n" +
                            "(2 - Este não é o nome preferido)\n" +
                            "Opcao: ");
                    preferido = leitorNumerico.nextInt();
                    if (preferido <= 0 || preferido > 2)
                        System.out.println("Ha algo errado, tente novamente");
                } while (preferido <= 0 || preferido > 2);
                nomeDto.setPreferido(preferido);

                do {
                    System.out.print("\nCondicao de uso:\n" +
                            "(1 - Informação não confiável, 2 - Nome com erro de digitação, 3 - Nome para não ser usado)\n" +
                            "(4 - Vínculo do nome proibido por lei, 5 - Requisito de privacidade/segurança especial)\n" +
                            "(6 - Nome temporário, 7 - Nao se aplica)\n" +
                            "Opcao: ");
                    usoCondicional = leitorNumerico.nextInt();
                    if (usoCondicional <= 0 || usoCondicional > 7)
                        System.out.println("Ha algo errado, tente novamente");
                } while (usoCondicional <= 0 || usoCondicional > 7);
                nomeDto.setUsoCondicional(usoCondicional);


                do {
                    System.out.print("\nUso:\n" +
                            "(1 - Relatório, 2 - Nome de recém-nascido, 3 - Nome profissional ou comercial)\n" +
                            "(4 - Nome de solteiro, nome de nascimento ou nome original, 5 - Nome registrado (nome legal))\n" +
                            "(6 - Outro nome (alias))\n" +
                            "Opcao: ");
                    uso = leitorNumerico.nextInt();
                    if (uso <= 0 || uso > 6)
                        System.out.println("Ha algo errado, tente novamente");
                } while (uso <= 0 || uso > 6);
                nomeDto.setUso(uso);

                System.out.print("\nInicio do uso do nome: ");
                inicioUso = leitor.nextLine();
                nomeDto.setInicioUso(inicioUso);

                System.out.print("\nFim do uso do nome: ");
                fimUso = leitor.nextLine();
                nomeDto.setFimUso(fimUso);
            } catch (InputMismatchException e) {
                System.out.println("\nVocê digitou algo irregular, vamos começar de novo\n");
                verificador = false;
                leitorNumerico.next();
            }
        } while (!verificador);
    }

    /**
     * Método responsável por ler os dados de endereço de um individuo.
     *
     * @param leitor
     * @param leitorNumerico
     * @param verificaDadosDao
     * @param enderecoDto
     */
    private static void leEndereco(Scanner leitor, Scanner leitorNumerico, VerificaDadosDao verificaDadosDao, EnderecoDto enderecoDto) {
        boolean verificador;
        int tipoEndereco;
        String endereco;
        String bairro;
        String distrito;
        String municipio;
        String estadoEndereco;
        String cep;
        String caixaPostal;
        String pais;
        String dataInicioEndereco;
        String acuraciaIncio;
        String dataFimEndereco;
        String acuraciaFim;
        do {
            verificador = true;
            try {
                System.out.print("Tipo do endereco:\n" +
                        "(1 - Comercial, 2 - Correio ou postal, 3 - Acomodacao temporaria)\n" +
                        "(4 - Residencial, 5 - Sem endereco fixo, 6 - Desconhecido/nao declarado)\n" +
                        "Opcao: ");
                do {
                    tipoEndereco = leitorNumerico.nextInt();
                } while (tipoEndereco <= 0 || tipoEndereco > 6);
                enderecoDto.setTipo(tipoEndereco);

                System.out.print("\nEndereco: ");
                endereco = leitor.nextLine();
                enderecoDto.setEndereco(endereco);

                System.out.print("\nBairro: ");
                bairro = leitor.nextLine();
                enderecoDto.setBairro(bairro);

                System.out.print("\nDistrito: ");
                distrito = leitor.nextLine();
                enderecoDto.setDistrito(distrito);

                do {
                    System.out.print("\nMunicipio: ");
                    municipio = leitor.nextLine();
                    if (verificaDadosDao.verificaMunicipio(municipio) == null)
                        System.out.println("Municipio nao existe ou nome inserido incorretamente. Tente novamente");
                } while (verificaDadosDao.verificaMunicipio(municipio) == null);
                enderecoDto.setMunicipio(municipio);

                do {
                    System.out.print("\nEstado: ");
                    estadoEndereco = leitor.nextLine();
                    if (verificaDadosDao.verificaEstado(estadoEndereco) == null)
                        System.out.println("Estado nao existe ou nome inserido incorretamente. Tente novamente");
                } while (verificaDadosDao.verificaEstado(estadoEndereco) == null);
                enderecoDto.setEstado(estadoEndereco);

                System.out.print("\nCEP: ");
                cep = leitor.nextLine();
                enderecoDto.setCep(cep);

                System.out.print("\nCaixa postal: ");
                caixaPostal = leitor.nextLine();
                enderecoDto.setCaixaPostal(caixaPostal);

                do {
                    System.out.print("\nPais: ");
                    pais = leitor.nextLine();
                    if (verificaDadosDao.verificaPais(pais) == null)
                        System.out.println("Pais nao existe ou nome inserido incorretamente. Tente novamente");
                } while (verificaDadosDao.verificaPais(pais) == null);
                enderecoDto.setPais(pais);

                System.out.print("\nInicio do uso deste endereco: ");
                dataInicioEndereco = leitor.nextLine();
                enderecoDto.setDataInicio(dataInicioEndereco);

                do {
                    System.out.print("\nAcuracia da data de inicio de uso do endereco:\n" +
                            "(A - Acurado, E - Estimado, D - Desconhecido)\n" +
                            "Opcao: ");
                    acuraciaIncio = leitor.nextLine();
                    if (!acuraciaIncio.equals("A".toLowerCase()) && !acuraciaIncio.equals("E".toLowerCase())
                            && !acuraciaIncio.equals("D".toLowerCase()))
                        System.out.println("Ha algo errado, tente novamente");
                }
                while (!acuraciaIncio.equals("A".toLowerCase()) && !acuraciaIncio.equals("E".toLowerCase())
                        && !acuraciaIncio.equals("D".toLowerCase()));
                enderecoDto.setAcuraciaInicio(acuraciaIncio);

                System.out.print("\nFim de uso deste endereco: ");
                dataFimEndereco = leitor.nextLine();
                enderecoDto.setDataFim(dataFimEndereco);

                do {
                    System.out.print("\nAcuracia da data de fim de uso do endereco:\n" +
                            "(A - Acurado, E - Estimado, D - Desconhecido)\n" +
                            "Opcao: ");
                    acuraciaFim = leitor.nextLine();
                    if (!acuraciaFim.equals("A".toLowerCase()) && !acuraciaFim.equals("E".toLowerCase())
                            && !acuraciaFim.equals("D".toLowerCase()))
                        System.out.println("Ha algo errado, tente novamente");
                }
                while (!acuraciaFim.equals("A".toLowerCase()) && !acuraciaFim.equals("E".toLowerCase())
                        && !acuraciaFim.equals("D".toLowerCase()));
                enderecoDto.setAcuraciaFim(acuraciaFim);

            } catch (InputMismatchException e) {
                System.out.println("\nVocê digitou algo irregular, vamos começar de novo\n");
                verificador = false;
                leitorNumerico.next();
            }
        } while (!verificador);
    }

    /**
     * Método responsável por ler os dados demográficos de um individuo.
     *
     * @param leitor
     * @param leitorNumerico
     * @param verificaDadosDao
     * @param dadoDemograficoDto
     */
    private static void leDadoDemografico(Scanner leitor, Scanner leitorNumerico, VerificaDadosDao verificaDadosDao, DadoDemograficoDto dadoDemograficoDto) {
        boolean verificador;
        String dataNascimento;
        String nascimentoAcuracia;
        int opcao;
        String dataObito;
        String obritoAcuracia;
        int fonteNotificacaoObito;
        String sexo;
        String nomeMae;
        String nomePai;
        int situacaoFamiliar;
        int racaCor;
        String comentario;
        int nascimentoPluralidade;
        int nascimentoOrdem;
        int nascimentoSeguimento;
        String paisDado;
        String estadoDado;
        String municipioDado;
        String dataEntradaPais;
        do {
            verificador = true;
            try {
                System.out.print("Data de nascimento: ");
                dataNascimento = leitor.nextLine();
                dadoDemograficoDto.setDataNascimento(dataNascimento);

                do {
                    System.out.print("\nAcuracia da data de nascimento:\n" +
                            "(A - Acurado, E - Estimado, D - Desconhecido)\n" +
                            "Opcao: ");
                    nascimentoAcuracia = leitor.nextLine();
                    if (!nascimentoAcuracia.equals("A".toLowerCase()) && !nascimentoAcuracia.equals("E".toLowerCase())
                            && !nascimentoAcuracia.equals("D".toLowerCase()))
                        System.out.println("Ha algo errado, tente novamente");
                }
                while (!nascimentoAcuracia.equals("A".toLowerCase()) && !nascimentoAcuracia.equals("E".toLowerCase())
                        && !nascimentoAcuracia.equals("D".toLowerCase()));
                dadoDemograficoDto.setNascimentoAcuracia(nascimentoAcuracia);

                // questiona se o individuo a ser cadastrado possui dados de óbito
                do {
                    System.out.print("\nDefinir dados de obito?\n" +
                            "(1 - Sim, 2 - Nao)\n" +
                            "Opcao: ");
                    opcao = leitorNumerico.nextInt();
                } while (opcao <= 0 || opcao > 2);


                if (opcao == 1) {
                    System.out.print("\nData de obito: ");
                    dataObito = leitor.nextLine();
                    dadoDemograficoDto.setDataObito(dataObito);

                    do {
                        System.out.print("\nAcuracia da data de obito:\n" +
                                "(A - Acurado, E - Estimado, D - Desconhecido)\n" +
                                "Opcao: ");
                        obritoAcuracia = leitor.nextLine();
                        if (!obritoAcuracia.equals("A".toLowerCase()) && !obritoAcuracia.equals("E".toLowerCase())
                                && !obritoAcuracia.equals("D".toLowerCase()))
                            System.out.println("Ha algo errado, tente novamente");
                    }
                    while (!obritoAcuracia.equals("A".toLowerCase()) && !obritoAcuracia.equals("E".toLowerCase())
                            && !obritoAcuracia.equals("D".toLowerCase()));
                    dadoDemograficoDto.setObitoAcuracia(obritoAcuracia);

                    do {
                        System.out.print("\nFonte da notificacao do obito:\n" +
                                "(1 - Cartório, Prestador de assistência à saúde, 3 - Parente, 4 - Outro, 5 - Desconhecido)\n" +
                                "Opcao: ");
                        fonteNotificacaoObito = leitorNumerico.nextInt();
                        if (fonteNotificacaoObito <= 0 || fonteNotificacaoObito > 5)
                            System.out.println("Ha algo errado, tente novamente");
                    } while (fonteNotificacaoObito <= 0 || fonteNotificacaoObito > 5);
                    dadoDemograficoDto.setFonteNotificacaoObito(fonteNotificacaoObito);
                }

                do {
                    System.out.print("\nSexo:\n" +
                            "(M - Masculino, F - Feminino, I - Intersexo ou indeterminado, N - Não declarado)\n" +
                            "Opcao: ");
                    sexo = leitor.nextLine();
                    if (!sexo.equals("M".toLowerCase()) && !sexo.equals("F".toLowerCase()) && !sexo.equals("I")
                            && sexo.equals("N"))
                        System.out.println("Ha algo errado, tente novamente");
                } while (!sexo.equals("M".toLowerCase()) && !sexo.equals("F".toLowerCase()) && !sexo.equals("I")
                        && sexo.equals("N") || sexo.equals(""));
                dadoDemograficoDto.setSexo(sexo);

                System.out.print("\nNome da mae: ");
                nomeMae = leitor.nextLine();
                dadoDemograficoDto.setNomeMae(nomeMae);

                System.out.print("\nNome do pai: ");
                nomePai = leitor.nextLine();
                dadoDemograficoDto.setNomePai(nomePai);

                do {
                    System.out.print("\nSituacao familiar:\n" +
                            "(1 - Companheiro(a) e filho(s), 2 - Companheiro(a) com laços conjugais e sem filhos)\n" +
                            "(3 - Companheiro(a), com filho(s) e/ou outro(s) familiar(es), 4 - Familiar(es) sem companheiro(a))\n" +
                            "(5 - Outra(s) pessoa(s) sem laços consanguíneos e/ou laços conjugais, 6 - Vive só)\n" +
                            "Opcao: ");
                    situacaoFamiliar = leitorNumerico.nextInt();
                    if (situacaoFamiliar <= 0 || situacaoFamiliar > 6)
                        System.out.println("Ha algo errado, tente novamente");
                } while (situacaoFamiliar <= 0 || situacaoFamiliar > 6);
                dadoDemograficoDto.setSituacaoFamiliar(situacaoFamiliar);

                do {
                    System.out.print("\nRaca/Cor:\n" +
                            "(1 - Branca, 2 - Preta, 3 - Parda, 4 - Amarela, 5 - Indígena)\n" +
                            "Opcao: ");
                    racaCor = leitorNumerico.nextInt();
                    if (racaCor <= 0 || racaCor > 6)
                        System.out.println("Ha algo errado, tente novamente");
                } while (racaCor <= 0 || racaCor > 6);
                dadoDemograficoDto.setRacaCor(racaCor);

                System.out.println("\nComentario: ");
                comentario = leitor.nextLine();
                dadoDemograficoDto.setComentario(comentario);

                do {
                    System.out.print("\nNascimento pluralidade:\n" +
                            "(1 - Unico, 2 - Gemeos, 3 - Trigemeos, 4 - Quadruplos, 5 - Quintuplos)\n" +
                            "(6 - Sextuplus, 7 - Outros, 8 - Não declarado\n)" +
                            "Opcao: ");
                    nascimentoPluralidade = leitorNumerico.nextInt();
                    if (nascimentoPluralidade <= 0 || nascimentoPluralidade > 8)
                        System.out.println("Ha algo errado, tente novamente");
                } while (nascimentoPluralidade <= 0 || nascimentoPluralidade > 8);
                dadoDemograficoDto.setNascimentoPluralidade(nascimentoPluralidade);

                do {
                    System.out.print("\nNascimento ordem:\n" +
                            "(1 - Unico ou primeiro, 2 - Segundo, 3 - Terceiro, 4 - Quarto, 5 - Quinto)\n" +
                            "(6 - Sexto, 7 - Outros, 8 - Não declarado)\n" +
                            "Opcao: ");
                    nascimentoOrdem = leitorNumerico.nextInt();
                    if (nascimentoOrdem <= 0 || nascimentoOrdem > 8)
                        System.out.println("Ha algo errado, tente novamente");
                } while (nascimentoOrdem <= 0 || nascimentoOrdem > 8);
                dadoDemograficoDto.setNascimentoOrdem(nascimentoOrdem);

                do {
                    System.out.print("\nNascimento seguimento:\n" +
                            "(1 - Data precisa de seguimento, 2 - Data nao precisa de seguimento)\n" +
                            "Opcao: ");
                    nascimentoSeguimento = leitorNumerico.nextInt();
                    if (nascimentoSeguimento <= 0 || nascimentoSeguimento > 2)
                        System.out.println("Ha algo errado, tente novamente");
                } while (nascimentoSeguimento <= 0 || nascimentoSeguimento > 2);
                dadoDemograficoDto.setNascimentoSeguimento(nascimentoSeguimento);

                do {
                    System.out.print("\nPais de nascimento: ");
                    paisDado = leitor.nextLine();
                    if (verificaDadosDao.verificaPais(paisDado) == null)
                        System.out.println("Pais nao existe ou nome inserido incorretamente. Tente novamente");
                } while (verificaDadosDao.verificaPais(paisDado) == null);
                dadoDemograficoDto.setPais(paisDado);

                // verifica se o individuo é brasileiro
                if (paisDado.toLowerCase().equals("Brasil".toLowerCase())) {
                    do {
                        System.out.print("\nEstado de nascimento: ");
                        estadoDado = leitor.nextLine();
                        if (verificaDadosDao.verificaEstado(estadoDado) == null)
                            System.out.println("Estado nao existe ou nome inserido incorretamente. Tente novamente");
                    } while (verificaDadosDao.verificaEstado(estadoDado) == null);
                    dadoDemograficoDto.setEstado(estadoDado);

                    do {
                        System.out.print("\nMunicipio de nascimento: ");
                        municipioDado = leitor.nextLine();
                        if (verificaDadosDao.verificaMunicipio(municipioDado) == null)
                            System.out.println("Municipio nao existe ou nome inserido incorretamente. Tente novamente");
                    } while (verificaDadosDao.verificaMunicipio(municipioDado) == null);
                    dadoDemograficoDto.setMunicipio(municipioDado);

                } else {
                    System.out.print("\nData de entrada no Brasil: ");
                    dataEntradaPais = leitor.nextLine();
                    dadoDemograficoDto.setDataEntradaPais(dataEntradaPais);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nVocê digitou algo irregular, vamos começar de novo\n");
                verificador = false;
                leitorNumerico.next();
            }
        } while (!verificador);
    }


}
