<%-- 
    Document   : relatorio
    Created on : 06/10/2018, 12:35:17
    Author     : Silvio
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.fatec.eletivaJava.RelatorioGravidadeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% List<RelatorioGravidadeDTO> gravidades = (List<RelatorioGravidadeDTO>) request.getAttribute("relatorios"); %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório</title>
    </head>

    <body>
        <h1>Relatório</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>GRAVIDADE</th>
                    <th>TOTAL</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (RelatorioGravidadeDTO gravidade : gravidades) {
                %>
                <tr>
                    <td><%= gravidade.getGravidade()%></td>
                    <td><%= gravidade.getTotal()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <div>
            <form action="">
                <input type="submit" formaction="index.jsp" value="VOLTAR">
            </form>
        </div>
    </body>

</html>