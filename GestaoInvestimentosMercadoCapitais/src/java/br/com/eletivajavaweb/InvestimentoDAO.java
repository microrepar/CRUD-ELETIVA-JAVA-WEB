package br.com.eletivajavaweb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO extends AbstractDAO {

    @Override
    public void salvar(Investimento inv) throws SQLException {
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
                + " codigoEmpresaCorretora, qtdAcoes, dataHoraCompra, dataHoraVenda,"
                + " precoAcaoCompra, precoAcaoVenda  FROM investimento");
        
        ResultSet resultado = sql.executeQuery();
        
        List<Investimento> investimentos = new ArrayList<>();
        while(resultado.next()){
            Investimento inv = new Investimento();
            inv.setId(resultado.getInt("id"));
            inv.setCodigoInvestidor(resultado.getString("codigoInvestidor"));
            inv.setNomeInvestidor(resultado.getString("nomeInvestidor"));
            inv.setCodigoEmpresaCorretora(resultado.getString("codigoEmpresaCorretora"));
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
