package br.com.eletivaJavaWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FonteConexao {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/motel_bd?useLegacyDatetimeCode=false&serverTimezone=America/New_York";
        String user = "prova_usuario";
        String password = "abc12345";
        Class.forName(driver);
        Connection conexao = DriverManager.getConnection(url, user, password);
        
        
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //Class.forName("org.postgresql.Driver");
        //Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/motel_bd, ", "prova_usuario", "abc12345");
        //Connection conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:3306/motel_bd, ", "postgres", "abc12345");
        
        return conexao;
    }
    
    public void devolverConexao(Connection conexao) throws SQLException{
        conexao.close();
    }
}
