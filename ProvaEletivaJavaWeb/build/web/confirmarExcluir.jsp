<%-- 
    Document   : confirmarExclusao
    Created on : 02/10/2018, 20:37:12
    Author     : Silvio
--%>

<%@page import="br.com.fatec.eletivaJava.FichaPacienteDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% FichaPacienteDTO ficha = (FichaPacienteDTO) request.getAttribute("ficha"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir</title>
    </head>
            <h1>Deseja Realmente excluir a ficha do paciente <%= ficha.getNome() %>?</h1>
        <form action="FichaServlet" method="post">
            <input type="text" hidden name="id" value="<%= ficha.getId() %>">
            <input type="submit" name="acao" formaction="index.jsp" value="NAO">
            <input type="submit" name="acao" value="SIM">
        </form>
    </body>
</html>