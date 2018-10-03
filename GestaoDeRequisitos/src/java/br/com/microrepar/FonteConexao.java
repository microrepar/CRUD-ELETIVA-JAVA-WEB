/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.microrepar;

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
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/requisito_bd?useLegacyDatetimeCode=false&serverTimezone=America/New_York", "requisito_usuario", "abc12345");
        
        return conexao;
    }
    
    public void devolverConexao(Connection conexao) throws SQLException{
        conexao.close();
    }
}
