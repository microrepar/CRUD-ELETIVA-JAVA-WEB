<%-- 
    Document   : confirmarExcluir
    Created on : 06/10/2018, 23:29:28
    Author     : Silvio
--%>

<%@page import="br.com.eletivaJavaWeb.HospedagemDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HospedagemDTO hospedagem = (HospedagemDTO) request.getAttribute("hospedagemDTO"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exclusão de Registro</title>
    </head>
    <h1>Deseja Realmente excluir o registro da Hospedagem <%= hospedagem.getNome() %> número <%= hospedagem.getNumeroSuite()%>?</h1>
        <form action="HospedagemServlet" method="post">
            <input type="text" hidden name="id" value="<%= hospedagem.getId() %>">
            <input type="submit" name="acao" formaction="index.jsp" value="NAO">
            <input type="submit" name="acao" value="SIM">
        </form>
    </body>
</html>