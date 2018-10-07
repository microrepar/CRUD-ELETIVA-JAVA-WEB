<%-- 
    Document   : relatorio
    Created on : 07/10/2018, 07:37:18
    Author     : Silvio
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.eletivaJavaWeb.RelatorioHospedagemDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% List<RelatorioHospedagemDTO> relatorios = (List<RelatorioHospedagemDTO>) request.getAttribute("relatorioHospedagens"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Hospedagens</title>
    </head>
    <body>
        <h1>RELATÓRIO DE HOSPEDAGENS</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>TIPO DA SUITE</th>
                    <th>NUMERO DE HOSPEDAGENS</th>
                    <th>RECEITA TOTAL</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (RelatorioHospedagemDTO relatorio : relatorios) {
                %>
                <tr>
                    <td><%= relatorio.getTipo()%></td>
                    <td><%= relatorio.getNumHospedagens()%></td>
                    <td><%= relatorio.getReceitaTotal()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
        <form action="" method="get">
            <input type="submit" formaction="index.jsp" formmethod="GET" value="VOLTAR">
        </form>
    </body>
</html>
