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

    public RequisitoDAO() throws ClassNotFoundException, SQLException {
        conexao = fonteConexao.getConnection();
    }

    public List<Requisito> listarTodos() throws SQLException {
        // Executa o SQL de pesquisa
        PreparedStatement sql = conexao.prepareStatement("SELECT id, sigla_req, nome_req, descricao_req, escopo_req FROM requisito");
        ResultSet resultado = sql.executeQuery();

        List<Requisito> requisitos = new ArrayList<>();
        while (resultado.next()) {
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

    public void salvar(Requisito requisito) throws SQLException {
        // Executa o SQL de inserção
        PreparedStatement sql = conexao.prepareStatement("INSERT INTO requisito(sigla_req, nome_req, descricao_req, escopo_req, tipo_req) VALUE(?,?,?,?,?)");
        sql.setString(1, requisito.getSigla());
        sql.setString(2, requisito.getNome());
        sql.setString(3, requisito.getDescricao());
        sql.setString(4, requisito.getEscopo());
        sql.setString(5, requisito.getTipo());
        sql.execute();

        fonteConexao.devolverConexao(conexao);
    }

    public void excluir(long id) throws SQLException {
        PreparedStatement sql = conexao.prepareStatement("DELETE FROM requisito WHERE id=" + id);
        sql.executeUpdate();
    }

    public Requisito buscarPorId(long id) throws SQLException {
        PreparedStatement sql = conexao.prepareStatement("SELECT id, tipo_req, sigla_req, nome_req, descricao_req, escopo_req FROM requisito WHERE id=" + id);
        ResultSet resultado = sql.executeQuery();

        Requisito requisito = new Requisito();
        if (resultado.next()) {
            requisito.setId(resultado.getLong("id"));
            requisito.setTipo(resultado.getString("tipo_req"));
            requisito.setNome(resultado.getString("nome_req"));
            requisito.setSigla(resultado.getString("sigla_req"));
            requisito.setEscopo(resultado.getString("escopo_req"));
            requisito.setDescricao(resultado.getString("descricao_req"));
        }
        return requisito;
    }

    void atualizar(Requisito requisito) throws SQLException {
        PreparedStatement sql = conexao.prepareStatement("UPDATE requisito SET sigla_req=?, nome_req=?, escopo_req=?, descricao_req=?, tipo_req=? WHERE id=?");
        sql.setString(1, requisito.getSigla());
        sql.setString(2, requisito.getNome());
        sql.setString(3, requisito.getEscopo());
        sql.setString(4, requisito.getDescricao());
        sql.setString(5, requisito.getTipo());
        sql.setLong(6, requisito.getId());
        sql.executeUpdate();

        fonteConexao.devolverConexao(conexao);
    }

    public List<Requisito> filtrarPorNome(String filtro) throws SQLException {
        String filtroPesquisa = " WHERE nome_req like '%" + filtro + "%'";
        PreparedStatement sql = conexao.prepareStatement("SELECT id, sigla_req, nome_req, descricao_req, escopo_req FROM requisito " + filtroPesquisa);
        ResultSet resultado = sql.executeQuery();

        List<Requisito> requisitos = new ArrayList<>();
        while (resultado.next()) {
            Requisito requisito = new Requisito();
            requisito.setId(resultado.getLong("id"));
            requisito.setSigla(resultado.getString("sigla_req"));
            requisito.setNome(resultado.getString("nome_req"));
            requisito.setDescricao(resultado.getString("descricao_req"));
            requisito.setEscopo(resultado.getString("escopo_req"));
            requisitos.add(requisito);
        }
        return requisitos;
    }
}
