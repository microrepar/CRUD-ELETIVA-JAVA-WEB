<%@page import="br.com.fatecmogidascruzes.topicos.SolicitacaoDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<SolicitacaoDTO> solicitacoes = (List<SolicitacaoDTO>) request.getAttribute("solicitacoes");
    // Se nao tiver vindo da servlet, redireciona para a servlet.
    if (null == solicitacoes) {
        response.sendRedirect(request.getContextPath() + "/ServicoSolicitacao");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Solicitações de Documento</title>
        <style>
            .icone {
                width: 40px;
            }
        </style>
    </head>
    <body>
        <h1>Listagem de Solicitações de Documento</h1>
        <a href="inserir.jsp">NOVO</a>
        <form action="ServicoSolicitacao">
            <input type="text" name="filtrar" placeholder="Informe um filtro" /><input type="submit" name="acao" value="Pesquisar" />
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>Editar</th>
                    <th>RA</th>
                    <th>Nome do Aluno</th>
                    <th>Tipo de Documento</th>
                    <th>Situação</th>
                    <th>Data</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>
                <%
                    //ResultSet resultado = (ResultSet) request.getAttribute("solicitacoes");
                    //while (resultado.next()) {
                    for (SolicitacaoDTO solicitacao : solicitacoes) {
                %>
                <tr>
                    <td><a href="ServicoSolicitacao?acao=preAlteracao&id=<%= solicitacao.getId()%>"><img class="icone" src="lapis.svg" alt="Imagem de um lápis"/></a></td>
                    <td><%= solicitacao.getRaAluno()%></td>
                    <td><%= solicitacao.getNomeAluno()%></td>
                    <td><%= solicitacao.getTipoDocumento()%></td>
                    <td><%= solicitacao.getSituacao()%></td>
                    <td><%= solicitacao.getSituacao()%></td>
                    <td><a href="ServicoSolicitacao?acao=excluir&id=<%= solicitacao.getId()%>"><img class="icone" src="lata_lixo.svg" alt="Imagem de uma lata de lixo"/></a></td>
                </tr>
                <%
                    }

                    //resultado.getStatement().getConnection().close();
%>
            </tbody>
        </table>
    </body>
</html>
