package br.com.eletivaJavaWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractDAO implements IDAO {
    
    protected FonteConexao fonteConexao = new FonteConexao();
    protected Connection conexao;
    protected PreparedStatement sql = null;
    
    protected void openConnection(){
        try {
            
            if(conexao == null || conexao.isClosed())
                conexao = FonteConexao.getConnection(); 
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
