/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.IdentificadorDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdentificadorDao {
    public void inserir(IdentificadorDto identificadorDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO IDENTIFICADOR VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, identificadorDto.getsurrogateKey());
            statement.setString(2, identificadorDto.getIdCod());
            statement.setString(3, identificadorDto.getDesignacao());
            statement.setInt(4, identificadorDto.getArea());
            statement.setString(5, identificadorDto.getEmissor());
            statement.setString(6, identificadorDto.getDataEmissao());
            statement.setInt(7, identificadorDto.getTipo());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public IdentificadorDto consultaIdentificador(String surrogatekey) {
        IdentificadorDto identificadorDto = new IdentificadorDto();
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM IDENTIFICADOR WHERE SURROGATEKEY = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, surrogatekey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                identificadorDto.setIdCod(resultSet.getString("idCod"));
                identificadorDto.setDesignacao(resultSet.getString("designacao"));
                identificadorDto.setArea(resultSet.getInt("area"));
                identificadorDto.setEmissor(resultSet.getString("emissor"));
                identificadorDto.setDataEmissao(resultSet.getString("dataEmissao"));
                identificadorDto.setTipo(resultSet.getInt("tipo"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return identificadorDto;
    }
}
