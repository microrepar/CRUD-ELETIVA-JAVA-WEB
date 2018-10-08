package br.com.eletivajavaweb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractDAO implements IDAO {
    
    Connection conexao = null;
    PreparedStatement sql = null;
    
    protected void openConnection(){
        try {
            if(conexao == null || conexao.isClosed())
                conexao = FonteConexao.getConnection();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();            
        }
    }   
}
