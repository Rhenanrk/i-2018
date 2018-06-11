/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.integracao;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;


public class ConexaoUtilTest {

    @Test
    public void testeConexao() {
        ConexaoUtil conexaoUtil = new ConexaoUtil();

        try {
            if (conexaoUtil.getConnection().isValid(15))
                System.out.println("[Teste de conexao: bem sucedido]");
            else
                fail("Erro ao conectar com o banco de dados");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
