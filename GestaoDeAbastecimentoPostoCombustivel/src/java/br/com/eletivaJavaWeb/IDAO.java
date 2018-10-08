package br.com.eletivaJavaWeb;

import java.sql.SQLException;
import java.util.List;

public interface IDAO {
    public void salvar(Abastecimento ab)throws SQLException ;
    public void excluir(int id) throws SQLException;
    public void atualizar(Abastecimento ab) throws SQLException;
    public Abastecimento buscarPorId(int id) throws SQLException;
    public List<Abastecimento> listarTodos() throws SQLException;
    public List<RelatorioDeAbastecimentosDTO> relatorio() throws SQLException;
}
