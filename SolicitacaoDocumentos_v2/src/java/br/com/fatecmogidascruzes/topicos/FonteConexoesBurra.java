package br.com.fatecmogidascruzes.topicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta classe implementa uma fonte de conexoes burra (sera modificada no
 * futuro)
 */
public class FonteConexoesBurra {

    public Connection getConexao() throws SQLException, ClassNotFoundException {
        // Definir o driver de conexão com o banco.
        // Class.forName("org.postgresql.Driver");
        Class.forName("com.mysql.jdbc.Driver");
        // Abrir conexão com o banco.
        // Connection conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/solicitacao_doc_bd", "solicitacao_usuario", "abc12345");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/solicitacao_doc_bd?useLegacyDatetimeCode=false&serverTimezone=America/New_York", "solicitacao_usuario", "abc12345");
        return conexao;
    }

    public void devolverConexao(Connection conexao) throws SQLException {
        conexao.close();
    }

}
