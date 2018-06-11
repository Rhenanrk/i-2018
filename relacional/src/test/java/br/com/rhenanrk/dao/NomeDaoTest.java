/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.NomeDto;
import org.junit.Test;

import static org.junit.Assert.fail;


public class NomeDaoTest {
    NomeDto nomeDto = new NomeDto();
    NomeDao nomeDao = new NomeDao();

    @Test
    public void inserir() {
        nomeDto.setSurrogateKey("Teste");
        nomeDto.setTitulos("Teste");
        nomeDto.setNomes("Teste1 Teste2");
        nomeDto.setSobrenomes("Teste");
        nomeDto.setSufixos("Teste");
        nomeDto.setNomeCompleto("Teste");
        nomeDto.setPreferido(1);
        nomeDto.setUsoCondicional(1);
        nomeDto.setUso(1);
        nomeDto.setInicioUso("Teste");
        nomeDto.setFimUso("Teste");

        try {
            if (nomeDao.inserir(nomeDto))
                System.out.println("[Teste de insercao de nome: bem sucedido]");
            else
                fail("Erro ao inserir");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void atualizaNome() {
        nomeDto.setSurrogateKey("Teste");
        nomeDto.setTitulos("Teste");
        nomeDto.setNomes("Teste");
        nomeDto.setSobrenomes("Teste");
        nomeDto.setSufixos("Teste");
        nomeDto.setNomeCompleto("Teste");
        nomeDto.setPreferido(4);
        nomeDto.setUsoCondicional(4);
        nomeDto.setUso(4);
        nomeDto.setInicioUso("Teste");
        nomeDto.setFimUso("Teste");

        try {
            if (nomeDao.atualizaNome("Teste", nomeDto))
                System.out.println("[Teste de atualizacao de nome: bem sucedido]");
            else
                fail("Erro ao inserir");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
