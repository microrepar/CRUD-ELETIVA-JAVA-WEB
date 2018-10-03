<%-- 
    Document   : index
    Created on : 02/10/2018, 16:46:07
    Author     : m.c.silva
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.microrepar.RequisitoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<RequisitoDTO> requisitos = (List<RequisitoDTO>) request.getAttribute("requisitos");

    if (null == requisitos) {
        response.sendRedirect(request.getContextPath() + "/ServicoRequisito");
        return;
    }
%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Requisitos</title>
    </head>

    <body>
        <h1>Requisitos</h1>
        <form action="" method="get">
            <div>
                <input type="text" name="filtro" id="id_filtro" placeholder="Insira um filtro">
                <input type="submit" value="FILTRAR">
            </div>
        </form>

        <div>
            <a href="inserir.jsp">NOVO</a>
            <table border="1">
                <thead>
                    <tr>
                        <th>SIGLA</th>
                        <th>NOME</th>
                        <th>ESCOPO</th>
                        <th>ACÕES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (RequisitoDTO requisito : requisitos) {
                    %>
                    <tr>
                        <td><%= requisito.getSigla()%></td>
                        <td><%= requisito.getNome()%></td>
                        <td><%= requisito.getEscopo()%></td>
                        <td> <input type="submit" value="EXCLUIR"></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>

            </table>
        </div>
    </body>
</html>