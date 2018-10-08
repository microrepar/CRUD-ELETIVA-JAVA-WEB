<%-- 
    Document   : relatorio
    Created on : 07/10/2018, 19:22:14
    Author     : Silvio
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.eletivaJavaWeb.RelatorioDeAbastecimentosDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<RelatorioDeAbastecimentosDTO> relatorioAbastecimentos = (List<RelatorioDeAbastecimentosDTO>) request.getAttribute("relatorioAbastecimentosDTO");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório</title>
    </head>
    <body>
        <h1>RELATÓRIO DE ABASTECIMENTOS</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>COD. FUNCIONÁRIO</th>
                    <th>TOTAL DE VENDAS</th>
                </tr>
            </thead>
            <tbody>
                <% for (RelatorioDeAbastecimentosDTO relatorio : relatorioAbastecimentos) { %>
                <tr>
                    <td><%= relatorio.getCodigoFuncionario() %></td>
                    <td><%= relatorio.getValorTotalAbastecimento() %></td>
                </tr>
                <% }%>
            </tbody>
        </table>
            <br>
        <form action="index.jsp" method="get">
            <input type="submit" value="VOLTAR">
        </form>
    </body>
</html>
