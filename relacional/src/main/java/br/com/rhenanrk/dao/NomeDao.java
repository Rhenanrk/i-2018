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
    public boolean inserir(NomeDto nomeDto) {
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
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizaNome(String surrogateKey, NomeDto nomeDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "UPDATE NOME SET titulos = ?, nomes = ?, sobrenomes = ?, sufixos = ?, nomeCompleto = ?, " +
                    "preferido = ?, usoCondicional = ?, uso = ?, inicioUso = ?, fimUso = ? WHERE SURROGATEKEY = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, nomeDto.getTitulos());
            statement.setString(2, nomeDto.getNomes());
            statement.setString(3, nomeDto.getSobrenomes());
            statement.setString(4, nomeDto.getSufixos());
            statement.setString(5, nomeDto.getNomeCompleto());
            statement.setInt(6, nomeDto.getPreferido());
            statement.setInt(7, nomeDto.getUsoCondicional());
            statement.setInt(8, nomeDto.getUso());
            statement.setString(9, nomeDto.getInicioUso());
            statement.setString(10, nomeDto.getFimUso());
            statement.setString(11, surrogateKey);

            statement.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public NomeDto consultaNome(String surrogatekey) {
        NomeDto nomeDto = new NomeDto();
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM NOME WHERE SURROGATEKEY = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, surrogatekey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                nomeDto.setNomeCompleto(resultSet.getString("nomeCompleto"));
                nomeDto.setPreferido(resultSet.getInt("preferido"));
                nomeDto.setUsoCondicional(resultSet.getInt("usoCondicional"));
                nomeDto.setUso(resultSet.getInt("uso"));
                nomeDto.setInicioUso(resultSet.getString("inicioUso"));
                nomeDto.setFimUso(resultSet.getString("fimUso"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nomeDto;
    }
}
