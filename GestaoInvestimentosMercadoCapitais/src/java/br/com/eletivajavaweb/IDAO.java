package br.com.eletivajavaweb;

import java.sql.SQLException;
import java.util.List;

public interface IDAO {

    public void salvar(Investimento inv) throws SQLException;

    public void atualizar(Investimento inv) throws SQLException;

    public void excluir(int id) throws SQLException;

    public Investimento buscarPorId(int id) throws SQLException;

    public List<Investimento> listarTodos() throws SQLException;

    public List<RelatorioInvestimentosDTO> relatorio()throws SQLException;
}
