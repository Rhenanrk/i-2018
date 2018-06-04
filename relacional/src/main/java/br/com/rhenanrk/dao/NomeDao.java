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
import java.sql.ResultSet;
import java.sql.SQLException;

public class NomeDao {
    public void inserir(NomeDto nomeDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO NOME VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, nomeDto.getSurrogateKey());
            statement.setString(2, nomeDto.getTitulos());
            statement.setString(3, nomeDto.getNomes());
            statement.setString(4, nomeDto.getSobrenomes());
            statement.setString(5, nomeDto.getSufixos());
            statement.setString(6, nomeDto.getNomeCompleto());
            statement.setInt(7, nomeDto.getPreferido());
            statement.setInt(8, nomeDto.getUsoCondicional());
            statement.setInt(9, nomeDto.getUso());
            statement.setString(10, nomeDto.getInicioUso());
            statement.setString(11, nomeDto.getFimUso());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String localizaIndividuo(String nomeCompleto) {
        String localizado = null;
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM NOME WHERE NOMECOMPLETO = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nomeCompleto);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nomeCompleto");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return localizado;
    }
}
