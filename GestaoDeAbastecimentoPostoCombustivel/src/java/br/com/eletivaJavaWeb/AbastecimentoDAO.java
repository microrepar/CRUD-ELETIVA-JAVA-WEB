/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eletivaJavaWeb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silvio
 */
public class AbastecimentoDAO extends AbstractDAO {

    @Override
    public void salvar(Abastecimento ab) {
        openConnection();
        
        try {
            
            sql = conexao.prepareStatement("INSERT INTO abastecimento(codigoFuncionario, cpfCliente,"
                    + " tipoCombustivel, qtdCombustivel, valorTotal, tipoPagamento,"
                    + " dataHoraAbastecimento) VALUES(?,?,?,?,?,?,?)");
            sql.setString(1, ab.getCodigoFuncionario());
            sql.setString(2, ab.getCpfCliente());
            sql.setString(3, ab.getTipoCombustivel());
            sql.setDouble(4, ab.getQtdCombustivel());
            sql.setDouble(5, ab.getValorTotal());
            sql.setString(6, ab.getTipoPagamento());
            sql.setDate(7, new java.sql.Date(ab.getDataHoraAbastecimento().getTime()));
            sql.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                sql.close();
                FonteConexao.devolverConexao(conexao);
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void excluir(int id) {
        openConnection();

        try {
            sql = conexao.prepareStatement("DELETE FROM abastecimento WHERE id=" + id);
            sql.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sql.close();
                FonteConexao.devolverConexao(conexao);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Abastecimento ab) {
        openConnection();
        
        try {
            sql = conexao.prepareStatement("UPDATE abastecimento SET codigoFuncionario=?, cpfCliente=?,"
                    + " tipoCombustivel=?, qtdCombustivel=?, valorTotal=?, tipoPagamento=?"
                    + " WHERE id=?");
            sql.setString(1, ab.getCodigoFuncionario());
            sql.setString(2, ab.getCpfCliente());
            sql.setString(3, ab.getTipoCombustivel());
            sql.setDouble(4, ab.getQtdCombustivel());
            sql.setDouble(5, ab.getValorTotal());
            sql.setString(6, ab.getTipoPagamento());
            sql.setInt(7, ab.getId());
            sql.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                sql.close();
                FonteConexao.devolverConexao(conexao);
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Abastecimento buscarPorId(int id) {
        openConnection();
        Abastecimento ab = null;

        try {
            sql = conexao.prepareStatement("SELECT id, codigoFuncionario, cpfCliente,"
                    + " tipoCombustivel, qtdCombustivel, valorTotal, tipoPagamento,"
                    + " dataHoraAbastecimento FROM abastecimento WHERE id=" + id);
            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                ab = new Abastecimento();
                ab.setId(resultado.getInt("id"));
                ab.setCodigoFuncionario(resultado.getString("codigoFuncionario"));
                ab.setCpfCliente(resultado.getString("cpfCliente"));
                ab.setTipoCombustivel(resultado.getString("tipoCombustivel"));
                ab.setQtdCombustivel(resultado.getDouble("qtdCombustivel"));
                ab.setValorTotal(resultado.getDouble("valorTotal"));
                ab.setTipoPagamento(resultado.getString("tipoPagamento"));
                ab.setDataHoraAbastecimento(resultado.getDate("dataHoraAbastecimento"));
            }
            return ab;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sql.close();
                FonteConexao.devolverConexao(conexao);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ab;
    }

    @Override
    public List<Abastecimento> listarTodos() {
        openConnection();
        List<Abastecimento> abastecimentos = new ArrayList<>();

        try {
            sql = conexao.prepareStatement("SELECT id, codigoFuncionario, cpfCliente,"
                    + " tipoCombustivel, qtdCombustivel, valorTotal, tipoPagamento,"
                    + " dataHoraAbastecimento FROM abastecimento");
            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                Abastecimento ab = new Abastecimento();
                ab.setId(resultado.getInt("id"));
                ab.setCodigoFuncionario(resultado.getString("codigoFuncionario"));
                ab.setCpfCliente(resultado.getString("cpfCliente"));
                ab.setTipoCombustivel(resultado.getString("tipoCombustivel"));
                ab.setQtdCombustivel(resultado.getDouble("qtdCombustivel"));
                ab.setValorTotal(resultado.getDouble("valorTotal"));
                ab.setTipoPagamento(resultado.getString("tipoPagamento"));
                ab.setDataHoraAbastecimento(resultado.getDate("dataHoraAbastecimento"));
                abastecimentos.add(ab);
            }

            return abastecimentos;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sql.close();
                FonteConexao.devolverConexao(conexao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public List<RelatorioDeAbastecimentosDTO> relatorio() {
        openConnection();
        List<RelatorioDeAbastecimentosDTO> relatorioAbastecimentos = new ArrayList<>();
        try {
            sql = conexao.prepareStatement("SELECT codigoFuncionario, SUM(valorTotal) AS valor_total FROM abastecimento GROUP BY  codigoFuncionario");
            ResultSet resultado = sql.executeQuery();
            
            while(resultado.next()){
                RelatorioDeAbastecimentosDTO dto = new RelatorioDeAbastecimentosDTO();
                dto.setCodigoFuncionario(resultado.getString("codigoFuncionario"));
                dto.setValorTotalAbastecimento(resultado.getDouble("valor_total"));
                relatorioAbastecimentos.add(dto);
            }
            return relatorioAbastecimentos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
