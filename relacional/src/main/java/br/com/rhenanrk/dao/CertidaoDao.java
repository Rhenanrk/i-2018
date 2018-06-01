/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.CertidaoDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CertidaoDao {
    public void inserir(CertidaoDto certidaoDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO CERTIDAO VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, certidaoDto.getIdCod());
            statement.setString(2, certidaoDto.getSurrogateKey());
            statement.setInt(3, certidaoDto.getTipo());
            statement.setString(4, certidaoDto.getNomeCartorio());
            statement.setInt(5, certidaoDto.getLivro());
            statement.setInt(6, certidaoDto.getFolha());
            statement.setInt(7, certidaoDto.getTermo());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
