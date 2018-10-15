/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.solicitacao.data;

import br.com.fatecmogidascruzes.solicitacao.Solicitacao;
import br.com.fatecmogidascruzes.util.FonteConexoesBurra;
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
public class SolicitacaoDAO {

    FonteConexoesBurra fonteConexao = new FonteConexoesBurra();
    Connection conexao;

    public SolicitacaoDAO() throws SQLException, ClassNotFoundException {
        this.conexao = fonteConexao.getConexao();
    }

    public void salvar(Solicitacao solicitacao) throws SQLException {
        PreparedStatement sql = conexao.prepareStatement("INSERT INTO solicitacoes(ra_aluno, nome_aluno, tipo_documento, situacao, data_solicitacao, data_ultima_atualizacao) VALUES(?,?,?,?,?,?)");
        sql.setString(1, solicitacao.getRaAluno());
        sql.setString(2, solicitacao.getNomeAluno());
        sql.setString(3, solicitacao.getTipoDocumento());
        sql.setString(4, solicitacao.getSituacao());
        sql.setDate(5, new java.sql.Date(System.currentTimeMillis()));
        sql.setDate(6, new java.sql.Date(System.currentTimeMillis()));
        sql.executeUpdate();

        fonteConexao.devolverConexao(conexao);
    }

    public void atualizar(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
        PreparedStatement sql = conexao.prepareStatement("UPDATE solicitacoes SET ra_aluno=?, nome_aluno=?, tipo_documento=?, data_ultima_atualizacao=now() WHERE id=?");
        sql.setString(1, solicitacao.getRaAluno());
        sql.setString(2, solicitacao.getNomeAluno());
        sql.setString(3, solicitacao.getTipoDocumento());
        sql.setInt(4, solicitacao.getId());
        sql.executeUpdate();

        fonteConexao.devolverConexao(conexao);
    }

    public void excluir(int id) throws SQLException, ClassNotFoundException {      

        PreparedStatement sql = conexao.prepareStatement("DELETE FROM solicitacoes WHERE id=" + id);
        sql.executeUpdate();

        fonteConexao.devolverConexao(conexao);
    }

    public List<Solicitacao> filtrar(String filtro) throws SQLException, ClassNotFoundException {
        String filtroPesquisa = " WHERE nome_aluno like '%" + filtro + "%'";
        // Executar o SQL de pesquisa.
        PreparedStatement sql = conexao.prepareStatement("SELECT id, ra_aluno, nome_aluno, tipo_documento, situacao, data_ultima_atualizacao FROM solicitacoes" + filtroPesquisa);
        ResultSet resultado = sql.executeQuery();

        List<Solicitacao> solicitacoes = new ArrayList<>();
        while (resultado.next()) {
            Solicitacao solicitacao = new Solicitacao();
            solicitacao.setId(resultado.getInt("id"));
            solicitacao.setRaAluno(resultado.getString("ra_aluno"));
            solicitacao.setNomeAluno(resultado.getString("nome_aluno"));
            solicitacao.setTipoDocumento(resultado.getString("tipo_documento"));
            solicitacao.setSituacao(resultado.getString("situacao"));
            // TODO: dataUltimaAtualizacao
            solicitacoes.add(solicitacao);
        }

        fonteConexao.devolverConexao(conexao);
        
        return solicitacoes;
    }

    public List<Solicitacao> listarTodos() throws SQLException, ClassNotFoundException {
         // Executar o SQL de pesquisa.
        PreparedStatement sql = conexao.prepareStatement("SELECT id, ra_aluno, nome_aluno, tipo_documento, situacao, data_ultima_atualizacao FROM solicitacoes");
        ResultSet resultado = sql.executeQuery();

        List<Solicitacao> solicitacoes = new ArrayList<>();
        while (resultado.next()) {
            Solicitacao solicitacao = new Solicitacao();
            solicitacao.setId(resultado.getInt("id"));
            solicitacao.setRaAluno(resultado.getString("ra_aluno"));
            solicitacao.setNomeAluno(resultado.getString("nome_aluno"));
            solicitacao.setTipoDocumento(resultado.getString("tipo_documento"));
            solicitacao.setSituacao(resultado.getString("situacao"));
            solicitacoes.add(solicitacao);
        }

        fonteConexao.devolverConexao(conexao);
        
        return solicitacoes;
    }

    public Solicitacao consultarPorId(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement sql = conexao.prepareStatement("SELECT id, ra_aluno, nome_aluno, tipo_documento, situacao, data_ultima_atualizacao FROM solicitacoes WHERE id=" + id);
        ResultSet resultado = sql.executeQuery();

        Solicitacao solicitacao = null;
        if (resultado.next()) {
            solicitacao = new Solicitacao();
            solicitacao.setId(resultado.getInt("id"));
            solicitacao.setRaAluno(resultado.getString("ra_aluno"));
            solicitacao.setNomeAluno(resultado.getString("nome_aluno"));
            solicitacao.setTipoDocumento(resultado.getString("tipo_documento"));
            solicitacao.setSituacao(resultado.getString("situacao"));
            // TODO: dataUltimaAtualizacao
        }

        fonteConexao.devolverConexao(conexao);

        return solicitacao;

    }

}
