/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.eletivaJava;

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
public class FichaPacienteDAO {

    FonteConexao fonteConexao = new FonteConexao();
    Connection conexao;

    public FichaPacienteDAO() throws ClassNotFoundException, SQLException {
        conexao = fonteConexao.getConnection();
    }

    public List<FichaPaciente> listarTodos() throws ClassNotFoundException, SQLException {
        // Executa o SQL de pesquisa
        PreparedStatement sql = conexao.prepareStatement("SELECT id, cpf, nome_paciente, especialidade, gravidade, desc_sintomas, data_hora FROM ficha");
        ResultSet resultado = sql.executeQuery();

        List<FichaPaciente> fichas = new ArrayList<>();
        while (resultado.next()) {
            FichaPaciente ficha = new FichaPaciente();
            ficha.setId(resultado.getInt("id"));
            ficha.setCpf(resultado.getString("cpf"));
            ficha.setNome(resultado.getString("nome_paciente"));
            ficha.setEspecialidade(resultado.getString("especialidade"));
            ficha.setGravidade(resultado.getString("gravidade"));
            ficha.setDescSintomas(resultado.getString("desc_sintomas"));
            ficha.setDataHora(resultado.getDate("data_hora"));
            fichas.add(ficha);
        }

        fonteConexao.devolverConexao(conexao);

        return fichas;
    }

    public void salvar(FichaPaciente ficha) throws ClassNotFoundException, SQLException {
        // Executa o SQL de inserção
        PreparedStatement sql = conexao.prepareStatement("INSERT INTO ficha(cpf, nome_paciente, especialidade, gravidade, desc_sintomas, data_hora) VALUES(?,?,?,?,?,?)");
        sql.setString(1, ficha.getCpf());
        sql.setString(2, ficha.getNome());
        sql.setString(3, ficha.getEspecialidade());
        sql.setString(4, ficha.getGravidade());
        sql.setString(5, ficha.getDescSintomas());
        sql.setDate(6, new java.sql.Date(new java.util.Date().getTime()));
        sql.executeUpdate();

        fonteConexao.devolverConexao(conexao);
    }

    void excluir(int id) throws SQLException {
        PreparedStatement sql = conexao.prepareStatement("DELETE FROM ficha WHERE id=" + id);
        sql.executeUpdate();
    }

    void atualizar(FichaPaciente ficha) throws SQLException {
        PreparedStatement sql = conexao.prepareStatement("UPDATE ficha SET cpf=?, nome_paciente=?, especialidade=?, gravidade=?, desc_sintomas=? WHERE id=?");
        sql.setString(1, ficha.getCpf());
        sql.setString(2, ficha.getNome());
        sql.setString(3, ficha.getEspecialidade());
        sql.setString(4, ficha.getGravidade());
        sql.setString(5, ficha.getDescSintomas());
        sql.setInt(6, ficha.getId());
        sql.executeUpdate();
    }

    FichaPaciente buscaPorId(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
