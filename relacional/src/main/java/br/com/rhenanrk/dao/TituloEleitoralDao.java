/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.TituloEleitoralDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsável por interagir com o banco de dados na tabela TITULOELEITORAL
 */
public class TituloEleitoralDao {

    /**
     * Método responsável por inserir o titulo eleitoral do indivíduo no banco de dados.
     *
     * @param tituloEleitoralDto
     */
    public void inserir(TituloEleitoralDto tituloEleitoralDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO TITULOELEITORAL VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, tituloEleitoralDto.getIdCod());
            statement.setString(2, tituloEleitoralDto.getSurrogateKey());
            statement.setInt(3, tituloEleitoralDto.getSecao());
            statement.setInt(4, tituloEleitoralDto.getZona());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método responsável por consultar o titulo eleitoral do indivíduo no banco de dados.
     *
     * @param surrogatekey
     * @param idCod
     * @return
     */
    public TituloEleitoralDto consultaTituloEleitoral(String surrogatekey, String idCod) {
        TituloEleitoralDto tituloEleitoralDto = new TituloEleitoralDto();
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM TITULOELEITORAL WHERE IDCOD = ? AND SURROGATEKEY = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, idCod);
            statement.setString(2, surrogatekey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tituloEleitoralDto.setSecao(resultSet.getInt("secao"));
                tituloEleitoralDto.setZona(resultSet.getInt("zona"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tituloEleitoralDto;
    }
}
