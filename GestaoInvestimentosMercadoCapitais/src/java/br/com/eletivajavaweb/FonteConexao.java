package br.com.eletivajavaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FonteConexao {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/investimento_bd?useLegacyDatetimeCode=false&serverTimezone=America/New_York";
        String user = "prova_usuario";
        String password = "abc12345";
        
        Class.forName(driver);
        
        Connection conexao = DriverManager.getConnection(url, user, password);
        return conexao;
    }
    
    public static void devolverConexao(Connection conexao)throws SQLException{
        conexao.close();
    }
    
}
