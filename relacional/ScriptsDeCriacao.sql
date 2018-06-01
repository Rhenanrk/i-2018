/*Scripts de criação do banco de dados*/

/*Criando banco de dados */
CREATE DATABASE relacional;

/*Acessando banco de dados criado*/
USE relacional;   

/*Criando tabela de indivíduo*/
create table individuo (
surrogateKey varchar (10) primary key);

/*Criando tabela de nome*/
create table nome (
surrogateKey varchar (10),
titulos varchar (20),
nomes varchar (30),
sobrenomes varchar (30),
sufixos varchar (20),
preferido int,
usoCondicional int,
uso int,
inicioUso varchar (12),
fimUso varchar (12));

/*Criando tabela de representaçao*/
create table representacao (
surrogateKey varchar (10),
utilizacao varchar (30),
alternativa varchar (30));

/*Criando tabela de identificador*/
create table identificador (
surrogateKey varchar (10),
idCod varchar (10),
designacao varchar (25),
area int,
emissor varchar (25),
dataEmissao varchar (12),
tipo int);

/*Criando tabela de titulo eleitoral*/
create table tituloEleitoral (
idCod varchar (10),
surrogateKey varchar (10),
secao int,
zona int);

/*Criando tabela de certidão*/
create table certidao (
idCod varchar (10),
surrogateKey varchar (10),
tipo int,
nomeCartorio varchar (30),
livro int,
folha int,
termo int);

/*Criando tabela de carteira de trabalho e previdencia social*/
create table ctps (
idCod varchar (10),
surrogateKey varchar (10),
serie varchar (10),
estado varchar (20));

/*Criando tabela de dado demográfico*/
create table dadoDemografico (
surrogateKey varchar (10),
dataNascimento varchar (12),
nascimentoAcuracia varchar (2),
dataObito varchar (12),
obitoAcuracia varchar (2),
fonteNotificacaoObito int,
sexo varchar (2),
nomeMae varchar (40),
nomePai varchar (40),
situacaoFamiliar int,
racaCor int,
comentario varchar (100),
nascimentoPluralidade int,
nascimentoOrdem int,
nascimentoSeguinte int,
pais varchar (20),
estado varchar (20),
municipio varchar (40),
dataEntradaPais varchar (12));

/*Criando tabela de endereço*/
create table endereco (
surrogateKey varchar (10),
tipo int,
endereco varchar (40),
bairro varchar (30),
distrito varchar (30),
municipio varchar (30),
estado varchar (20),
cep varchar (10),
caixaPostal varchar (15),
pais varchar (30),
dataInicio varchar (12),
acuraciaInicio varchar (2),
dataFim varchar (12),
acuraciaFim varchar (2));

/*Criando tabela de vínculo*/
create table vinculo ( 
surrogateKey varchar (10),
idCod varchar (10),
nomePessoa varchar (40),
relacionamento int,
dataInicio varchar (12),
dataFim varchar (12));

/*Criando tabela de comunicação*/
create table comunicacao (
surrogateKey varchar (10),
meio int,
detalhe varchar (20),
preferencia int,
utilizacao int);