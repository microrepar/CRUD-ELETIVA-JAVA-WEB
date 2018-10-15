/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.eletivaJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author m.c.silva
 */
public class FonteConexao {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // Define o driver de conexão com o banco de dados
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Class.forName("org.postgresql.Driver");

        Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/prova_bd?useLegacyDatetimeCode=false&serverTimezone=America/New_York", "ficha_usuario", "abc12345");
//        Connection conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/prova_bd", "postgres", "123senha");
        return conexao;
    }

    public void devolverConexao(Connection conexao) throws SQLException {
        conexao.close();
    }
}
