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
import java.sql.SQLException;

public class VinculoDao {
    public void inserir(VinculoDto vinculoDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO TITULOELEITORAL VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, vinculoDto.getSurrogateKey());
            statement.setString(2, vinculoDto.getIdCod());
            statement.setString(3, vinculoDto.getNomePessoa());
            statement.setInt(4, vinculoDto.getRelacionamento());
            statement.setString(5, vinculoDto.getDataInicio());
            statement.setString(6, vinculoDto.getDataFim());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
