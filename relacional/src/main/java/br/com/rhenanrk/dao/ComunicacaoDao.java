/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.ComunicacaoDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComunicacaoDao {
    public void inserir(ComunicacaoDto comunicacaoDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO COMUNICACAO VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, comunicacaoDto.getsurrogateKey());
            statement.setInt(2, comunicacaoDto.getMeio());
            statement.setString(3, comunicacaoDto.getDetalhe());
            statement.setInt(4, comunicacaoDto.getPreferencia());
            statement.setInt(5, comunicacaoDto.getUtilizacao());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ComunicacaoDto consultaComunicacao(String surrogatekey) {
        ComunicacaoDto comunicacaoDto = new ComunicacaoDto();
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM COMUNICACAO WHERE SURROGATEKEY = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, surrogatekey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                comunicacaoDto.setMeio(resultSet.getInt("meio"));
                comunicacaoDto.setDetalhe(resultSet.getString("detalhe"));
                comunicacaoDto.setPreferencia(resultSet.getInt("preferencia"));
                comunicacaoDto.setUtilizacao(resultSet.getInt("utilizacao"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return comunicacaoDto;
    }
}
