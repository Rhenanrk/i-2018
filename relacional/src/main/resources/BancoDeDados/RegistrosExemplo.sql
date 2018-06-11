/*
* Sr. Fernando Pereira: SurrogateKey: we2fg88-s
* id de identificador: as4ff45-a
* Nascido e residente em Porto Alegre
* Casado com Maria Luisa
*/
INSERT INTO individuo
VALUES ('we2fg88-s');

INSERT INTO nome
VALUES ('we2fg88-s', 'Sr.', 'Fernando', 'Pereira', '', 'Fernando Pereira', 2, 1, 4, '10/10/1997', 'presente');

INSERT INTO COMUNICACAO
VALUES ('we2fg88-s', 2, '(51) 988822-3221', 1, 2);

INSERT INTO identificador
VALUES ('as4ff45-a', 'we2fg88-s', '12899963-7', 4, 'SSP', '20/08/2009', 2);

INSERT INTO ctps
VALUES ('as4ff45-a', 'we2fg88-s', '1200', 'Rio Grande do Sul');

INSERT INTO certidao
VALUES ('as4ff45-a', 'we2fg88-s', 1, 'Cartorio Nova Venesa', 308, 12, 2);

INSERT INTO tituloeleitoral
VALUES ('as4ff45-a', 'we2fg88-s', 12, 2);

INSERT INTO vinculo
VALUES ('we2fg88-s', 'ssa26ka-s', 'Cônjuge/companheiro(a)', 2015, 'presente');

INSERT INTO endereco
VALUES
  ('we2fg88-s', 4, 'Rua das Palmeiras', 'Jardim Primavera', '', 'Porto Alegre', 'Rio Grande do Sul', '75.445-877', '',
                'Brasil', 2015, 'e', 'presente', 'a');

INSERT INTO dadodemografico
VALUES
  ('we2fg88-s', '22/08/1978', 'a', '', '', 0, 'M', 'Maria Joaquina', 'Lionel Messi', 2, 1, 'Boa saude', 1, 1, 2,
   'Brasil', 'Rio Grande do Sul', 'Porto Alegre', '');


/*
* Maria Luisa: SurrogateKey: ssa26ka-s
* id de identificador: asswdd5-a
* Nascida em Salvador e residente em Porto Alegre
* Casada com Sr. Fernando Pereira
*/
INSERT INTO individuo
VALUES ('ssa26ka-s');

INSERT INTO nome
VALUES ('ssa26ka-s', '', 'Maria', 'Luisa', '', 'Maria Luisa', 1, 3, 2, '22/08/1979', 'presente');

INSERT INTO COMUNICACAO
VALUES ('ssa26ka-s', 1, '(51) 3345-4456', 3, 4);

INSERT INTO identificador
VALUES ('ssa26ka-s', 'asswdd5-a', '2334114', 4, 'SSP', '02/12/2015', 2);

INSERT INTO ctps
VALUES ('asswdd5-a', 'ssa26ka-s', '233', 'Rio Grande do Sul');

INSERT INTO certidao
VALUES ('asswdd5-a', 'ssa26ka-s', 2, 'Cartorio São joão', 68, 2, 14);

INSERT INTO tituloeleitoral
VALUES ('asswdd5-a', 'ssa26ka-s', 32, 7);

INSERT INTO vinculo
VALUES ('ssa26ka-s', 'we2fg88-s', 'Cônjuge/companheiro(a)', 2015, 'presente');

INSERT INTO endereco
VALUES ('ssa26ka-s', 4, 'Rua das Missoes', 'Campina Verde', '', 'Porto Alegre', 'Rio Grande do Sul', '55.412-937', '',
                     'Brasil', 2015, 'e', 'presente', 'a');

INSERT INTO dadodemografico
VALUES
  ('ssa26ka-s', '22/08/1979', 'a', '', '', 0, 'M', 'Livia dos Santos', 'Michael Hernandes', 1, 3, '', 1, 1, 2, 'Brasil',
   'Salvador', 'Bahia', '');




