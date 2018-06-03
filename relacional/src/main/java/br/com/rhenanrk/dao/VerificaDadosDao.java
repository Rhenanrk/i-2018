/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificaDadosDao {
    public String verificaPais(String pais) {
        String nome_pais = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM LISTAPAISES WHERE NOME = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pais);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                nome_pais = resultSet.getString("nome");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nome_pais;
    }

    public String verificaEstado(String estado) {
        String nome_estado = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM LISTAESTADOS WHERE NOME = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, estado);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                nome_estado = resultSet.getString("nome");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nome_estado;
    }

    public String verificaMunicipio(String municipio) {
        String nome_municipio = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM LISTAMUNICIPIOS WHERE NOME = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, municipio);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                nome_municipio = resultSet.getString("nome");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nome_municipio;
    }
}
