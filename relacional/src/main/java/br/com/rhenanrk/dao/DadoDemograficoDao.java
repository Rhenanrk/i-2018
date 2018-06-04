/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dao;

import br.com.rhenanrk.dto.DadoDemograficoDto;
import br.com.rhenanrk.integracao.ConexaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DadoDemograficoDao {
    public void inserir(DadoDemograficoDto dadoDemograficoDto) {
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "INSERT INTO DADODEMOGRAFICO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, dadoDemograficoDto.getSurrogateKey());
            statement.setString(2, dadoDemograficoDto.getDataNascimento());
            statement.setString(3, dadoDemograficoDto.getNascimentoAcuracia());
            statement.setString(4, dadoDemograficoDto.getDataObito());
            statement.setString(5, dadoDemograficoDto.getObitoAcuracia());
            statement.setInt(6, dadoDemograficoDto.getFonteNotificacaoObito());
            statement.setString(7, dadoDemograficoDto.getSexo());
            statement.setString(8, dadoDemograficoDto.getNomeMae());
            statement.setString(9, dadoDemograficoDto.getNomePai());
            statement.setInt(10, dadoDemograficoDto.getSituacaoFamiliar());
            statement.setInt(11, dadoDemograficoDto.getRacaCor());
            statement.setString(12, dadoDemograficoDto.getComentario());
            statement.setInt(13, dadoDemograficoDto.getNascimentoPluralidade());
            statement.setInt(14, dadoDemograficoDto.getNascimentoOrdem());
            statement.setInt(15, dadoDemograficoDto.getNascimentoSeguimento());
            statement.setString(16, dadoDemograficoDto.getPais());
            statement.setString(17, dadoDemograficoDto.getEstado());
            statement.setString(18, dadoDemograficoDto.getMunicipio());
            statement.setString(19, dadoDemograficoDto.getDataEntradaPais());

            statement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
