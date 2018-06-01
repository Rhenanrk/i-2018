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
import java.sql.SQLException;

public class TituloEleitoralDao {
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
}
