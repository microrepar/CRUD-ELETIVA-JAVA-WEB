package br.com.eletivajavaweb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO extends AbstractDAO {

    @Override
    public void salvar(Investimento inv) throws SQLException {
        openConnection();
        
        sql = conexao.prepareStatement("INSERT INTO investimento(codigoInvestidor,"
                + " nomeInvestidor, codigoCorretora, qtdAcoes, dataHoraCompra,"
                + " dataHoraVenda, precoAcaoCompra, precoAcaoVenda) "
                + "VALUES(?,?,?,?,?,?,?,?)");
        sql.setString(1, inv.getCodigoInvestidor());
        sql.setString(2, inv.getNomeInvestidor());
        sql.setString(3, inv.getCodigoInvestidor());
        sql.setInt(4, inv.getQtdAcoes());
        sql.setDate(5, new java.sql.Date(inv.getDataHoraCompra().getTime()));
        sql.setDate(6, new java.sql.Date(inv.getDataHoraVenda().getTime()));
        sql.setDouble(7, inv.getPrecoAcaoCompra());
        sql.setDouble(8, inv.getPrecoAcaoVenda());
        sql.executeUpdate();
        
        FonteConexao.devolverConexao(conexao);
    }

    @Override
    public void atualizar(Investimento inv) throws SQLException {
    }

    @Override
    public void excluir(int id) throws SQLException {
    }

    @Override
    public Investimento buscarPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Investimento> listarTodos() throws SQLException {
        openConnection();
        
        sql = conexao.prepareStatement("SELECT id, codigoInvestidor, nomeInvestidor,"
                + " codigoCorretora, qtdAcoes, dataHoraCompra, dataHoraVenda,"
                + " precoAcaoCompra, precoAcaoVenda  FROM investimento");
        
        ResultSet resultado = sql.executeQuery();
        
        List<Investimento> investimentos = new ArrayList<>();
        while(resultado.next()){
            Investimento inv = new Investimento();
            inv.setId(resultado.getInt("id"));
            inv.setCodigoInvestidor(resultado.getString("codigoInvestidor"));
            inv.setNomeInvestidor(resultado.getString("nomeInvestidor"));
            inv.setCodigoEmpresaCorretora(resultado.getString("codigoCorretora"));
            inv.setQtdAcoes(resultado.getInt("qtdAcoes"));
            inv.setDataHoraCompra(resultado.getDate("dataHoraCompra"));
            inv.setDataHoraVenda(resultado.getDate("dataHoraVenda"));
            inv.setPrecoAcaoCompra(resultado.getDouble("precoAcaoCompra"));
            inv.setPrecoAcaoVenda(resultado.getDouble("precoAcaoVenda"));
            investimentos.add(inv);
        }        
        
        FonteConexao.devolverConexao(conexao);
        
        return investimentos;
    }

    @Override
    public List<RelatorioInvestimentosDTO> relatorio() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
