/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.integracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por realizar a conexão com o banco de dados
 */
public class ConexaoUtil {
    String serverName = "localhost"; // caminho do servidor
    String myDataBase = "relacional"; // nome do banco de dados
    String url = "jdbc:mysql://" + serverName + "/" + myDataBase + "?autoReconnect=true&useSSL=false"; // construção da URL
    String username = "root"; // usuário do banco de dados
    String password = "12345"; // senha do banco de dados

    private static ConexaoUtil conexaoUtil;

    /**
     * Método responsável por testar se ja existe alguma conexão ao banco
     * @return conexaoUtil
     */
    public static ConexaoUtil getInstance() {
        if (conexaoUtil == null) {
            conexaoUtil = new ConexaoUtil();
        }
        return conexaoUtil;
    }

    /**
     * Método responsável por realizar a conexão;
     *
     * @return DriverManager.getConnection(url, username, password)
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(url, username, password);
    }
}
