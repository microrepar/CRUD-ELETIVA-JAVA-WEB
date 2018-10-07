package br.com.eletivaJavaWeb;

import java.sql.SQLException;
import java.util.List;

public interface IDAO {
    public void salvar(Hospedagem suite) throws SQLException;
    public List<Hospedagem> listarTodos()throws SQLException;
    public Hospedagem buscarPorId(int id)throws SQLException;
    public void excluir(int id)throws SQLException;
    public void atualizar(Hospedagem suite)throws SQLException;
    public List<RelatorioHospedagemDTO> relatorio()throws SQLException;
}
