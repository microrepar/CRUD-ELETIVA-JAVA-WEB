package br.com.fatecmogidascruzes.topicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta classe implementa solicitacoes de documentos.
 */
public class Solicitacao {

    private int id;
    private String raAluno, nomeAluno, tipoDocumento, situacao;
    private Date ultimaAtualizacao;
    private Date dataSolicitacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(String raAluno) {
        this.raAluno = raAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public void salvar() throws SQLException, ClassNotFoundException {
        FonteConexoesBurra fonteConexoes = new FonteConexoesBurra();
        Connection conexao = fonteConexoes.getConexao();

        PreparedStatement sql = conexao.prepareStatement("INSERT INTO solicitacoes(ra_aluno, nome_aluno, tipo_documento, situacao, data_solicitacao, data_ultima_atualizacao) VALUES(?,?,?,?,?,?)");
        sql.setString(1, raAluno);
        sql.setString(2, nomeAluno);
        sql.setString(3, tipoDocumento);
        sql.setString(4, situacao);
        sql.setDate(5, new java.sql.Date(System.currentTimeMillis()));
        sql.setDate(6, new java.sql.Date(System.currentTimeMillis()));
        sql.executeUpdate();

        fonteConexoes.devolverConexao(conexao);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        FonteConexoesBurra fonteConexoes = new FonteConexoesBurra();
        Connection conexao = fonteConexoes.getConexao();

        PreparedStatement sql = conexao.prepareStatement("DELETE FROM solicitacoes WHERE id=" + id);
        sql.executeUpdate();

        fonteConexoes.devolverConexao(conexao);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        FonteConexoesBurra fonteConexoes = new FonteConexoesBurra();
        Connection conexao = fonteConexoes.getConexao();

        PreparedStatement sql = conexao.prepareStatement("UPDATE solicitacoes SET ra_aluno=?, nome_aluno=?, tipo_documento=?, data_ultima_atualizacao=now() WHERE id=?");
        sql.setString(1, raAluno);
        sql.setString(2, nomeAluno);
        sql.setString(3, tipoDocumento);
        sql.setInt(4, id);
        sql.executeUpdate();

        fonteConexoes.devolverConexao(conexao);
    }

    public Solicitacao consultarPorId(int id) throws SQLException, ClassNotFoundException {
        FonteConexoesBurra fonteConexoes = new FonteConexoesBurra();
        Connection conexao = fonteConexoes.getConexao();

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

        fonteConexoes.devolverConexao(conexao);
        
        return solicitacao;
    }

    public List<Solicitacao> listarTodos() throws SQLException, ClassNotFoundException {
        FonteConexoesBurra fonteConexoes = new FonteConexoesBurra();
        Connection conexao = fonteConexoes.getConexao();

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

        fonteConexoes.devolverConexao(conexao);
        
        return solicitacoes;
    }

    public List<Solicitacao> filtrar(String filtro) throws SQLException, ClassNotFoundException {
        FonteConexoesBurra fonteConexoes = new FonteConexoesBurra();
        Connection conexao = fonteConexoes.getConexao();

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

        fonteConexoes.devolverConexao(conexao);
        
        return solicitacoes;
    }

}
