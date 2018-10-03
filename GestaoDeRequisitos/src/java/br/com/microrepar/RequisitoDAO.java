/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.microrepar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.c.silva
 */
public class RequisitoDAO {
    
    FonteConexao fonteConexao = new FonteConexao();
    Connection conexao;
    
    public RequisitoDAO() throws ClassNotFoundException, SQLException{
        conexao = fonteConexao.getConnection();
    }
    
    public List<Requisito> listarTodos() throws SQLException{
        // Executa o SQL de pesquisa
        PreparedStatement sql = conexao.prepareStatement("SELECT id, sigla_req, nome_req, descricao_req, escopo_req FROM requisito");
        ResultSet resultado = sql.executeQuery();
        
        List<Requisito> requisitos = new ArrayList<>();
        while(resultado.next()){
            Requisito requisito = new Requisito();
            requisito.setId(resultado.getLong("id"));
            requisito.setSigla(resultado.getString("sigla_req"));
            requisito.setNome(resultado.getString("nome_req"));
            requisito.setDescricao(resultado.getString("descricao_req"));
            requisito.setEscopo(resultado.getString("escopo_req")); 
            requisitos.add(requisito);
        }
        
        fonteConexao.devolverConexao(conexao);
        
        return requisitos;
    }
    
    public void salvar(Requisito requisito) throws SQLException{
        // Executa o SQL de inserção
        System.out.println("=>> ENTROU NO REQUISITO DAO");
        PreparedStatement sql = conexao.prepareStatement("INSERT INTO requisito(sigla_req, nome_req, descricao_req, escopo_req, tipo_req) VALUE(?,?,?,?,?)");
        sql.setString(1, requisito.getSigla());
        sql.setString(2, requisito.getNome());
        sql.setString(3, requisito.getDescricao());
        sql.setString(4, requisito.getEscopo());
        sql.setString(5, requisito.getTipo());
        sql.execute();
        
        fonteConexao.devolverConexao(conexao);
    }
    
    public void excluir(long id) throws SQLException{
        PreparedStatement sql = conexao.prepareStatement("DELETE FROM solicitacoes WHERE id=" + id);
        sql.executeUpdate();
    }
}
