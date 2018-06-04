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

    public String verificaSurrogateKey(String surrogateKey) {
        String SurrogateKey = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM INDIVIDUO WHERE SURROGATEKEY = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, surrogateKey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                SurrogateKey = resultSet.getString("surrogateKey");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return SurrogateKey;
    }

    public String verificaOrgaoEmissor(String orgaoEmissor) {
        String nome_orgaoEmissor = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM IDENTIFICADORES WHERE DESCRICAO = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orgaoEmissor);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                nome_orgaoEmissor = resultSet.getString("descricao");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nome_orgaoEmissor;
    }

    public String verificaRelacionamento(String relacionamento) {
        String tipo_relacionamento = null;

        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM RELACIONAMENTOTIPO WHERE DESCRICAO = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, relacionamento);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tipo_relacionamento = resultSet.getString("descricao");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tipo_relacionamento;
    }

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

    public boolean localizaIndividuo(String nomeCompleto, String nomeMae, String dataNascimento, String sexo) {
        boolean localizador = true;
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM NOME, DADODEMOGRAFICO WHERE NOME.NOMECOMPLETO = ? AND DADODEMOGRAFICO.NOMEMAE = ?" +
                    "AND DADODEMOGRAFICO.DATANASCIMENTO = ? AND DADODEMOGRAFICO.SEXO = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nomeCompleto);
            statement.setString(2, nomeMae);
            statement.setString(3, dataNascimento);
            statement.setString(4, sexo);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                localizador = true;
            } else
                localizador = false;

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return localizador;
    }
}
