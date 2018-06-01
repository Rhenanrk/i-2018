/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.EnderecoDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDao {
    public void inserir(EnderecoDto enderecoDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO ENDERECO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, enderecoDto.getSurrogateKey());
            statement.setInt(2, enderecoDto.getTipo());
            statement.setString(3, enderecoDto.getEndereco());
            statement.setString(4, enderecoDto.getBairro());
            statement.setString(5, enderecoDto.getDistrito());
            statement.setString(6, enderecoDto.getMunicipio());
            statement.setString(7, enderecoDto.getEstado());
            statement.setString(8, enderecoDto.getCep());
            statement.setString(9, enderecoDto.getCaixaPostal());
            statement.setString(10, enderecoDto.getPais());
            statement.setString(11, enderecoDto.getDataInicio());
            statement.setString(12, enderecoDto.getAcuraciaInicio());
            statement.setString(13, enderecoDto.getDataFim());
            statement.setString(14, enderecoDto.getAcuraciaFim());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
