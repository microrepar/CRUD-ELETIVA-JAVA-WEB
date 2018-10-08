package br.com.eletivaJavaWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FonteConexao {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        
        private String driver = "com.mysql.cj.jdbc.Driver";
        private String url = "jdbc:mysql://127.0.0.1:3306/posto_bd?useLegacyDatetimeCode=false&serverTimezone=America/New_York";
        private String user = "prova_usuario";
        private String password = "abc12345";
        
        //String driver = "org.postgresql.Driver";
        //String url = "jdbc:mysql://127.0.0.1:3306/posto_bd";
        //String user = "postgres";
        //String password = "abc12345";
        
        Class.forName(driver);
        Connection conexao = DriverManager.getConnection(url, user, password);
        
        return conexao;
    }
    
    public static void devolverConexao(Connection conexao) throws SQLException{
        conexao.close();
    }    
}
