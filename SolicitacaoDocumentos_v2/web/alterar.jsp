<%@page import="br.com.fatecmogidascruzes.solicitacao.dto.SolicitacaoDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Solicitação</title>
    </head>
    <body>
        <h1>Alterar Solicitação</h1>
        <form action="ServicoSolicitacao">
            <%
                SolicitacaoDTO solicitacaoDTO = (SolicitacaoDTO) request.getAttribute("solicitacao");
            %>
            <input type="hidden" name="id" placeholder="Qual é o id do aluno?" value="<%= solicitacaoDTO.getId() %>" /><br />
            <input type="text" name="ra_aluno" placeholder="Qual é o RA do aluno?" value="<%= solicitacaoDTO.getRaAluno()%>" /><br />
            <input type="text" name="nome_aluno" placeholder="Qual é o nome do aluno?" value="<%= solicitacaoDTO.getNomeAluno()  %>" /><br />
            <input type="text" name="tipo_documento" placeholder="Qual é o tipo de documento?" value="<%= solicitacaoDTO.getTipoDocumento() %>" /><br />
            <input type="submit" name="acao" value="alterar" />
        </form>
    </body>
</html>
