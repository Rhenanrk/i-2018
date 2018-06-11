/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.IndividuoDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe responsável por interagir com o banco de dados na tabela INDIVIDUO
 */
public class IndividuoDao {

    /**
     * Método responsável por inserir a chave do indivíduo no banco de dados.
     *
     * @param individuoDTO
     * @return
     */
    public boolean inserir(IndividuoDto individuoDTO) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO INDIVIDUO VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, individuoDTO.getsurrogateKey());

            statement.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
