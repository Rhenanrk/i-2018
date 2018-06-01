/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.NomeDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NomeDao {

    public void inserir(NomeDto nomeDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();

            String sql = "INSERT INTO NOME VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nomeDto.getSurrogateKey());
            statement.setString(2, nomeDto.getTitulos());
            statement.setString(3, nomeDto.getNomes());
            statement.setString(4, nomeDto.getSobrenomes());
            statement.setString(5, nomeDto.getSufixos());
            statement.setInt(6, nomeDto.getPreferido());
            statement.setInt(7, nomeDto.getUsoCondicional());
            statement.setInt(8, nomeDto.getUso());
            statement.setString(9, nomeDto.getinicioUso());
            statement.setString(10, nomeDto.getfimUso());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
