/*Scripts de criação do banco de dados*/

/*Criando banco de dados */
CREATE DATABASE relacional;

/*Acessando banco de dados criado*/
USE relacional;

/*Criando tabela de indivíduo*/
CREATE TABLE individuo (
  surrogateKey VARCHAR(10) PRIMARY KEY
);

/*Criando tabela de nome*/
CREATE TABLE nome (
  surrogateKey   VARCHAR(10),
  titulos        VARCHAR(20),
  nomes          VARCHAR(30),
  sobrenomes     VARCHAR(30),
  sufixos        VARCHAR(20),
  nomeCompleto   VARCHAR(100),
  preferido      INT,
  usoCondicional INT,
  uso            INT,
  inicioUso      VARCHAR(12),
  fimUso         VARCHAR(12)
);

/*Criando tabela de representaçao*/
CREATE TABLE representacao (
  surrogateKey VARCHAR(10),
  utilizacao   VARCHAR(30),
  alternativa  VARCHAR(30)
);

/*Criando tabela de identificador*/
CREATE TABLE identificador (
  surrogateKey VARCHAR(10),
  idCod        VARCHAR(10),
  designacao   VARCHAR(25),
  area         INT,
  emissor      VARCHAR(25),
  dataEmissao  VARCHAR(12),
  tipo         INT
);

/*Criando tabela de titulo eleitoral*/
CREATE TABLE tituloEleitoral (
  idCod        VARCHAR(10),
  surrogateKey VARCHAR(10),
  secao        INT,
  zona         INT
);

/*Criando tabela de certidão*/
CREATE TABLE certidao (
  idCod        VARCHAR(10),
  surrogateKey VARCHAR(10),
  tipo         INT,
  nomeCartorio VARCHAR(30),
  livro        INT,
  folha        INT,
  termo        INT
);

/*Criando tabela de carteira de trabalho e previdencia social*/
CREATE TABLE ctps (
  idCod        VARCHAR(10),
  surrogateKey VARCHAR(10),
  serie        VARCHAR(10),
  estado       VARCHAR(20)
);

/*Criando tabela de dado demográfico*/
CREATE TABLE dadoDemografico (
  surrogateKey          VARCHAR(10),
  dataNascimento        VARCHAR(12),
  nascimentoAcuracia    VARCHAR(2),
  dataObito             VARCHAR(12),
  obitoAcuracia         VARCHAR(2),
  fonteNotificacaoObito INT,
  sexo                  VARCHAR(2),
  nomeMae               VARCHAR(40),
  nomePai               VARCHAR(40),
  situacaoFamiliar      INT,
  racaCor               INT,
  comentario            VARCHAR(100),
  nascimentoPluralidade INT,
  nascimentoOrdem       INT,
  nascimentoSeguINTe    INT,
  pais                  VARCHAR(20),
  estado                VARCHAR(20),
  municipio             VARCHAR(40),
  dataEntradaPais       VARCHAR(12)
);

/*Criando tabela de endereço*/
CREATE TABLE endereco (
  surrogateKey   VARCHAR(10),
  tipo           INT,
  endereco       VARCHAR(40),
  bairro         VARCHAR(30),
  distrito       VARCHAR(30),
  municipio      VARCHAR(30),
  estado         VARCHAR(20),
  cep            VARCHAR(10),
  caixaPostal    VARCHAR(15),
  pais           VARCHAR(30),
  dataInicio     VARCHAR(12),
  acuraciaInicio VARCHAR(2),
  dataFim        VARCHAR(12),
  acuraciaFim    VARCHAR(2)
);

/*Criando tabela de vínculo*/
CREATE TABLE vinculo (
  surrogateKey                VARCHAR(10),
  surrogateKeyPessoaVinculada VARCHAR(10),
  relacionamento              VARCHAR(30),
  dataInicio                  VARCHAR(12),
  dataFim                     VARCHAR(12)
);

/*Criando tabela de comunicação*/
CREATE TABLE comunicacao (
  surrogateKey VARCHAR(10),
  meio         INT,
  detalhe      VARCHAR(20),
  preferencia  INT,
  utilizacao   INT
);