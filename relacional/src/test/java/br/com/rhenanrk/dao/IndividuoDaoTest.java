/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.IndividuoDto;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;


public class IndividuoDaoTest {

    public IndividuoDaoTest() {

    }

    @Test
    public void testeInserir() throws SQLException, ClassNotFoundException {
        IndividuoDao individuoDao = new IndividuoDao();
        IndividuoDto individuoDto = new IndividuoDto();

        String surrogateKey = "Teste";

        try {
            individuoDto.setsurrogateKey(surrogateKey);
            if (individuoDao.inserir(individuoDto))
                System.out.println("[Teste de insercao de individuo: bem sucedido]");
            else
                fail("Erro ao inserir");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
