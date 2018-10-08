<%-- 
    Document   : index
    Created on : 07/10/2018, 16:32:26
    Author     : Silvio
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.eletivaJavaWeb.AbastecimentoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<AbastecimentoDTO> abastecimentos = (List<AbastecimentoDTO>) request.getAttribute("abastecimentosDTO");

    if (null == abastecimentos) {
        response.sendRedirect(request.getContextPath() + "/ServletAbastecimento");
        return;
    }
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abastecimentos</title>
    </head>
    <body>
        <h1>ABASTECIMENTOS</h1>
        <div>
            <a href="inserir.jsp">NOVO</a>
            <a href="ServletAbastecimento?acao=RELATORIO">RELATÓRIO</a>
        </div>
        <table border="1">
            <thead>
                <tr>
                    <th>CÓDIGO FUNCIONÁRIO</th>
                    <th>CPF CLIENTE</th>
                    <th>TIPO</th>
                    <th>QTD</th>
                    <th>VALOR TOTAL</th>
                    <th>PAGAMENTO</th>
                    <th>DT/HR ABAST</th>
                    <th>AÇÕES</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (AbastecimentoDTO abastecimento : abastecimentos) {
                %>
                <tr>
                    <td><%= abastecimento.getCodigoFuncionario()%></td>
                    <td><%= abastecimento.getCpfCliente()%></td>
                    <td><%= abastecimento.getTipoCombustivel()%></td>
                    <td><%= abastecimento.getQtdCombustivel()%></td>
                    <td><%= abastecimento.getValorTotal()%></td>
                    <td><%= abastecimento.getTipoPagamento()%></td>
                    <td><%= abastecimento.getDataHoraAbastecimento()%></td>
                    <td>
                        <form action="ServletAbastecimento" method="get">
                            <input type="text" hidden name="id" id="id" value="<%= abastecimento.getId()%>">
                            <input type="submit" name="acao" value="EDITAR">
                            <input type="submit" name="acao" value="EXCLUIR">
                        </form>
                    </td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
