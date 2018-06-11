/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.RepresentacaoDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe responsável por interagir com o banco de dados na tabela REPRESENTACAO
 */
public class RepresentacaoDao {

    /**
     * Método responsável por inserir a representação do indivíduo no banco de dados.
     *
     * @param representacaoDto
     */
    public void inserir(RepresentacaoDto representacaoDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO REPRESENTACAO VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, representacaoDto.getsurrogateKey());
            statement.setString(2, representacaoDto.getUtilizacao());
            statement.setString(3, representacaoDto.getAlternativa());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
