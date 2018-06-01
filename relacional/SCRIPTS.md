# Scripts de criação do banco de dados

* Criando banco de dados     

CREATE DATABASE pessoa     
     
* Acessando banco de dados criado      

USE pessoa    

* Criando tabelas    

CREATE TABLE individuo ( surrogate_key INT not null PRIMARY KEY)    

CREATE TABLE endereco (    
surrogate_key INT PRIMARY KEY,    
bairro VARCHAR (30),     
distrito VARCHAR (30),    
codigo_municipio INT,     
estado VARCHAR (20),    
cep VARCHAR (14),    
caixa_postal VARCHAR (20),    
pais VARCHAR (20),     
tipo VARCHAR (20));    

CREATE TABLE dado_demografico (     
sexo VARCHAR (10),     
nome_da_mae VARCHAR (40),     
nome_do_pai VARCHAR (40),     
situacao_familiar VARCHAR (10),     
cor VARCHAR (10),     
comentario VARCHAR (60),     
fonte_notificacao_obito VARCHAR (20),     
nascimento_pluralidade VARCHAR (20),    
nascimento_ordem VARCHAR (20),     
nascimento_seguimento VARCHAR (20) );    
    
CREATE TABLE data_real (     
data_real VARCHAR (10),     
acuracia VARCHAR (10));    
    
CREATE TABLE nacionalidade (     
municipio VARCHAR (30),     
estado VARCHAR (20),     
pais VARCHAR (30),     
data_entrada_pais VARCHAR (10));    
    
CREATE TABLE linha_de_endereco (     
ordem VARCHAR (10),     
linha VARCHAR (10));    
    
CREATE TABLE vinculo (     
relacionamento VARCHAR (10),     
data_inicio VARCHAR (10),     
data_fim VARCHAR (10));    
    
CREATE TABLE identificador (     
surrogae_key INT PRIMARY KEY,     
designacao VARCHAR (20),     
area VARCHAR (20),     
emissor VARCHAR (10),     
data_real VARCHAR (10),     
tipo VARCHAR (10));    
    
CREATE TABLE ctps (     
serie VARCHAR (10),     
estado VARCHAR (20));    
    
CREATE TABLE certidao (     
tipo VARCHAR (10),     
cartorio VARCHAR (30),     
livro VARCHAR (20),     
folha VARCHAR (4),     
termo VARCHAR (10));    
    
CREATE TABLE titulo_eleitoral (    
secao VARCHAR (4),    
zona VARCHAR (3));    
    
CREATE TABLE utilizacao (    
uso VARCHAR (20),    
data_inicio VARCHAR (10),    
data_fim VARCHAR (10));    
    
CREATE TABLE nome (    
surrogate_key INT PRIMARY KEY,    
titulos VARCHAR (30),    
nomes VARCHAR (30),    
sobrenomes VARCHAR (30),    
sulfixos VARCHAR (10),    
preferido VARCHAR (15),    
uso_condicional VARCHAR (10));    
    
CREATE TABLE representacao (    
utilizacao VARCHAR (20),    
alternativo VARCHAR (20));    
    
CREATE TABLE comunicacao (    
meio VARCHAR (20),    
preferencia VARCHAR (20),    
detalhe VARCHAR (20),    
uso VARCHAR (15));    
    