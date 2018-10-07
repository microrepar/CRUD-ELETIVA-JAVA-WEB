package br.com.eletivaJavaWeb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silvio
 */
public class HospedagemDAO extends AbstractDAO {

    @Override
    public List<Hospedagem> listarTodos() {
        openConnection();

        List<Hospedagem> hospedagens = new ArrayList<>();
        try {
            sql = conexao.prepareStatement("SELECT id, tipo_suite, numero_suite,"
                    + " nome_suite, capacidade_suite, descAmenidade_suite, "
                    + "entrada_suite, saida_suite, valorHospedagem_suite, valorAdicionais_suite  FROM suite ");
            ResultSet resultado = sql.executeQuery();
            while (resultado.next()) {
                Hospedagem hospedagem = new Hospedagem();
                hospedagem.setId(resultado.getInt("id"));
                hospedagem.setTipo(resultado.getString("tipo_suite"));
                hospedagem.setNumeroSuite(resultado.getInt("numero_suite"));
                hospedagem.setNome(resultado.getString("nome_suite"));
                hospedagem.setCapacidade(resultado.getInt("capacidade_suite"));
                hospedagem.setDescAmenidade(resultado.getString("descAmenidade_suite"));
                hospedagem.setEntrada(resultado.getDate("entrada_suite"));
                hospedagem.setSaida(resultado.getDate("saida_suite"));
                hospedagem.setValorHospedagem(resultado.getDouble("valorHospedagem_suite"));
                hospedagem.setValorAdicionais(resultado.getDouble("valorAdicionais_suite"));
                hospedagens.add(hospedagem);
            }
            return hospedagens;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sql.close();
                fonteConexao.devolverConexao(conexao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Hospedagem buscarPorId(int id) {
        openConnection();
        Hospedagem hospedagem = null;

        try {
            sql = conexao.prepareStatement("SELECT id, tipo_suite, numero_suite,"
                    + " nome_suite, capacidade_suite, descAmenidade_suite,"
                    + " entrada_suite, saida_suite, valorHospedagem_suite,"
                    + " valorAdicionais_suite  FROM suite WHERE id=" + id);
            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                hospedagem = new Hospedagem();
                hospedagem.setId(resultado.getInt("id"));
                hospedagem.setTipo(resultado.getString("tipo_suite"));
                hospedagem.setNumeroSuite(resultado.getInt("numero_suite"));
                hospedagem.setNome(resultado.getString("nome_suite"));
                hospedagem.setCapacidade(resultado.getInt("capacidade_suite"));
                hospedagem.setDescAmenidade(resultado.getString("descAmenidade_suite"));
                hospedagem.setEntrada(resultado.getDate("entrada_suite"));
                hospedagem.setSaida(resultado.getDate("saida_suite"));
                hospedagem.setValorHospedagem(resultado.getDouble("valorHospedagem_suite"));
                hospedagem.setValorAdicionais(resultado.getDouble("valorAdicionais_suite"));
            }
            return hospedagem;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sql.close();
                fonteConexao.devolverConexao(conexao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return hospedagem;
    }

    @Override
    public void excluir(int id) {
        openConnection();
        try {
            sql = conexao.prepareStatement("DELETE FROM suite WHERE id=" + id);
            sql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sql.close();
                fonteConexao.devolverConexao(conexao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void atualizar(Hospedagem h) {
        openConnection();
        
        try {
            sql = conexao.prepareStatement("UPDATE suite SET tipo_suite=?,"
                    + " numero_suite=?, nome_suite=?, capacidade_suite=?,"
                    + " descAmenidade_suite=?, valorHospedagem_suite=?,"
                    + " valorAdicionais_suite=? WHERE id=?");
            sql.setString(1,h.getTipo() );    
            sql.setInt(2, h.getNumeroSuite());
            sql.setString(3, h.getNome());
            sql.setInt(4, h.getCapacidade());
            sql.setString(5, h.getDescAmenidade());
            sql.setDouble(6, h.getValorHospedagem());
            sql.setDouble(7, h.getValorAdicionais());
            sql.setInt(8, h.getId());
            sql.executeUpdate();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sql.close();
                fonteConexao.devolverConexao(conexao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<RelatorioHospedagemDTO> relatorio() {
        openConnection();
        List<RelatorioHospedagemDTO> relatorioHospedagens = null;

        try {
            sql = conexao.prepareStatement("SELECT tipo_suite ,COUNT(tipo_suite) AS quantidade ,"
                    + " (SUM(valorHospedagem_suite)) AS hospedagem,"
                    + " SUM(valorAdicionais_suite) AS adicionais"
                    + "  FROM motel_bd.suite GROUP BY tipo_suite");
            ResultSet resultado = sql.executeQuery();
            
            relatorioHospedagens = new ArrayList<>();
            while (resultado.next()) {
                RelatorioHospedagemDTO relHospedagem = new RelatorioHospedagemDTO();
                relHospedagem.setTipo(resultado.getString("tipo_suite"));
                relHospedagem.setNumHospedagens(resultado.getInt("quantidade"));
                relHospedagem.setReceitaTotal(resultado.getDouble("hospedagem")+
                        resultado.getDouble("adicionais"));
                relatorioHospedagens.add(relHospedagem);
            }
            return relatorioHospedagens;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sql.close();
                fonteConexao.devolverConexao(conexao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return relatorioHospedagens;
    }

    @Override
    public void salvar(Hospedagem hospedagem) {
        openConnection();

        try {
            sql = conexao.prepareStatement("INSERT INTO suite(tipo_suite, numero_suite,"
                    + " nome_suite, capacidade_suite, descAmenidade_suite, entrada_suite,"
                    + " valorHospedagem_suite, valorAdicionais_suite)"
                    + " VALUES(?,?,?,?,?,?,?,?)");
            sql.setString(1, hospedagem.getTipo());
            sql.setInt(2, hospedagem.getNumeroSuite());
            sql.setString(3, hospedagem.getNome());
            sql.setInt(4, hospedagem.getCapacidade());
            sql.setString(5, hospedagem.getDescAmenidade());
            sql.setDate(6, new java.sql.Date(hospedagem.getEntrada().getTime()));
            sql.setDouble(7, hospedagem.getValorHospedagem());
            sql.setDouble(8, hospedagem.getValorAdicionais());
            sql.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                sql.close();
                fonteConexao.devolverConexao(conexao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    void finalizar(Hospedagem h) {
        openConnection();
        
        try {
            sql = conexao.prepareStatement("UPDATE suite SET tipo_suite=?,"
                    + " numero_suite=?, nome_suite=?, capacidade_suite=?,"
                    + " descAmenidade_suite=?, valorHospedagem_suite=?,"
                    + " valorAdicionais_suite=?, saida_suite=? WHERE id=?");
            sql.setString(1,h.getTipo() );    
            sql.setInt(2, h.getNumeroSuite());
            sql.setString(3, h.getNome());
            sql.setInt(4, h.getCapacidade());
            sql.setString(5, h.getDescAmenidade());
            sql.setDouble(6, h.getValorHospedagem());
            sql.setDouble(7, h.getValorAdicionais());
            sql.setDate(8, new java.sql.Date(h.getSaida().getTime()));
            sql.setInt(9, h.getId());
            
            sql.executeUpdate();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sql.close();
                fonteConexao.devolverConexao(conexao);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
