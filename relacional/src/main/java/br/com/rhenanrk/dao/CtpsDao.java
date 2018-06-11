/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.CtpsDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsável por interagir com o banco de dados na tabela CTPS
 *
 */
public class CtpsDao {

    /**
     * Método responsável por inserir a CTPS do indivíduo no banco de dados.
     *
     * @param ctpsDto
     */
    public void inserir(CtpsDto ctpsDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO CTPS VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, ctpsDto.getIdCod());
            statement.setString(2, ctpsDto.getsurrogateKey());
            statement.setString(3, ctpsDto.getSerie());
            statement.setString(4, ctpsDto.getEstado());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método responsável por consultar a CTPS do indivíduo no banco de dados.
     * @param surrogatekey
     * @param idCod
     * @return
     */
    public CtpsDto consultaCtps(String surrogatekey, String idCod) {
        CtpsDto ctpsDto = new CtpsDto();
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM CTPS WHERE IDCOD = ? AND SURROGATEKEY = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, idCod);
            statement.setString(2, surrogatekey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ctpsDto.setSerie(resultSet.getString("serie"));
                ctpsDto.setEstado(resultSet.getString("estado"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ctpsDto;
    }
}
