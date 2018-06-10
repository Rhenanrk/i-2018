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
import java.sql.ResultSet;
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

    public void atualizaEndereco(String surrogateKey, EnderecoDto enderecoDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "UPDATE ENDERECO SET tipo = ?, endereco = ?, bairro = ?, distrito = ?, municipio = ?, " +
                    "estado = ?, cep = ?, caixaPostal = ?, pais = ?, dataInicio = ?, acuraciaInicio = ?, dataFim = ?, " +
                    "acuraciaFim = ? WHERE SURROGATEKEY = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, enderecoDto.getTipo());
            statement.setString(2, enderecoDto.getEndereco());
            statement.setString(3, enderecoDto.getBairro());
            statement.setString(4, enderecoDto.getDistrito());
            statement.setString(5, enderecoDto.getMunicipio());
            statement.setString(6, enderecoDto.getEstado());
            statement.setString(7, enderecoDto.getCep());
            statement.setString(8, enderecoDto.getCaixaPostal());
            statement.setString(9, enderecoDto.getPais());
            statement.setString(10, enderecoDto.getDataInicio());
            statement.setString(11, enderecoDto.getAcuraciaInicio());
            statement.setString(12, enderecoDto.getDataFim());
            statement.setString(13, enderecoDto.getAcuraciaFim());
            statement.setString(14, surrogateKey);

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public EnderecoDto consultaEndereco(String surrogatekey) {
        EnderecoDto enderecoDto = new EnderecoDto();
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM ENDERECO WHERE SURROGATEKEY = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, surrogatekey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                enderecoDto.setTipo(resultSet.getInt("tipo"));
                enderecoDto.setEndereco(resultSet.getString("endereco"));
                enderecoDto.setBairro(resultSet.getString("bairro"));
                enderecoDto.setDistrito(resultSet.getString("distrito"));
                enderecoDto.setMunicipio(resultSet.getString("municipio"));
                enderecoDto.setEstado(resultSet.getString("estado"));
                enderecoDto.setCep(resultSet.getString("cep"));
                enderecoDto.setCaixaPostal(resultSet.getString("caixaPostal"));
                enderecoDto.setPais(resultSet.getString("pais"));
                enderecoDto.setDataInicio(resultSet.getString("dataInicio"));
                enderecoDto.setAcuraciaInicio(resultSet.getString("acuraciaInicio"));
                enderecoDto.setDataFim(resultSet.getString("dataFim"));
                enderecoDto.setAcuraciaFim(resultSet.getString("acuraciaFim"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return enderecoDto;
    }
}
