<%-- 
    Document   : confirmarExclusao
    Created on : 07/10/2018, 19:21:59
    Author     : Silvio
--%>

<%@page import="br.com.eletivaJavaWeb.AbastecimentoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% AbastecimentoDTO abastecimento = (AbastecimentoDTO) request.getAttribute("abastecimentoDTO"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exclusão de Abastecimento</title>
    </head>
    <h1>Deseja realmente excluir o abastecimento de <%= abastecimento.getCodigoFuncionario()%> cliente cpf:<%= abastecimento.getCpfCliente()%>?</h1>
        <form action="ServletAbastecimento" method="post">
            <input type="text" hidden name="id" value="<%= abastecimento.getId() %>">
            <input type="submit" name="acao" formaction="index.jsp" value="NAO">
            <input type="submit" name="acao" value="SIM">
        </form>
    </body>
</html>