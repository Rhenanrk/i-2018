/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.VinculoDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VinculoDao {
    public void inserir(VinculoDto vinculoDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO VINCULO VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, vinculoDto.getSurrogateKey());
            statement.setString(2, vinculoDto.getSurrogateKeyPessoaVinculada());
            statement.setString(3, vinculoDto.getRelacionamento());
            statement.setString(4, vinculoDto.getDataInicio());
            statement.setString(5, vinculoDto.getDataFim());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public VinculoDto consultaVinculo(String surrogatekey) {
        VinculoDto vinculoDto = new VinculoDto();
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM VINCULO WHERE SURROGATEKEY = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, surrogatekey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                vinculoDto.setSurrogateKeyPessoaVinculada(resultSet.getString("surrogateKeyPessoaVinculada"));
                vinculoDto.setRelacionamento(resultSet.getString("relacionamento"));
                vinculoDto.setDataInicio(resultSet.getString("dataInicio"));
                vinculoDto.setDataFim(resultSet.getString("dataFim"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vinculoDto;
    }
}
