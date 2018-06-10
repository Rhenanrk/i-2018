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

    public DadoDemograficoDto consultaDadoDemografico(String surrogatekey) {
        DadoDemograficoDto dadoDemograficoDto = new DadoDemograficoDto();
        try {
            Connection connection = ConexaoUtil.getInstance().getConnection();
            String sql = "SELECT * FROM DADODEMOGRAFICO WHERE SURROGATEKEY = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, surrogatekey);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                dadoDemograficoDto.setDataNascimento(resultSet.getString("dataNascimento"));
                dadoDemograficoDto.setNascimentoAcuracia(resultSet.getString("nascimentoAcuracia"));
                dadoDemograficoDto.setDataObito(resultSet.getString("dataObito"));
                dadoDemograficoDto.setObitoAcuracia(resultSet.getString("obitoAcuracia"));
                dadoDemograficoDto.setFonteNotificacaoObito(resultSet.getInt("fonteNotificacaoObito"));
                dadoDemograficoDto.setSexo(resultSet.getString("sexo"));
                dadoDemograficoDto.setNomeMae(resultSet.getString("nomeMae"));
                dadoDemograficoDto.setNomePai(resultSet.getString("nomePai"));
                dadoDemograficoDto.setSituacaoFamiliar(resultSet.getInt("situacaoFamiliar"));
                dadoDemograficoDto.setRacaCor(resultSet.getInt("racaCor"));
                dadoDemograficoDto.setComentario(resultSet.getString("comentario"));
                dadoDemograficoDto.setNascimentoPluralidade(resultSet.getInt("nascimentoPluralidade"));
                dadoDemograficoDto.setNascimentoOrdem(resultSet.getInt("nascimentoOrdem"));
                dadoDemograficoDto.setNascimentoSeguimento(resultSet.getInt("nascimentoSeguinte"));
                dadoDemograficoDto.setPais(resultSet.getString("pais"));
                dadoDemograficoDto.setEstado(resultSet.getString("estado"));
                dadoDemograficoDto.setMunicipio(resultSet.getString("municipio"));
                dadoDemograficoDto.setDataEntradaPais(resultSet.getString("dataEntradaPais"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dadoDemograficoDto;
    }
}
