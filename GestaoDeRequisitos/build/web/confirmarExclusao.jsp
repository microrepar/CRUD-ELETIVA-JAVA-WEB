<%-- 
    Document   : confirmarExclusao
    Created on : 02/10/2018, 20:37:12
    Author     : Silvio
--%>

<%@page import="br.com.microrepar.RequisitoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% RequisitoDTO requisito = (RequisitoDTO) request.getAttribute("requisito"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
            <h1>Deseja Realmente excluir o <%= requisito.getSigla() %>?</h1>
        <form action="ServicoRequisito" method="post">
            <input type="text" hidden name="id" value="<%= requisito.getId() %>">
            <input type="submit" name="acao" formaction="index.jsp" value="NAO">
            <input type="submit" name="acao" value="SIM">
        </form>
    </body>
</html>
