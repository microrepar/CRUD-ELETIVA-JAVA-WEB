<%-- 
    Document   : index
    Created on : 08/10/2018, 15:59:10
    Author     : m.c.silva
--%>

<%@page import="br.com.eletivajavaweb.InvestimentoDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<InvestimentoDTO> investimentos = (List<InvestimentoDTO>) request.getAttribute("investimentosDTO");
    
    if (null == investimentos) {
        response.sendRedirect(request.getContextPath() + "/Servlet");
        return;
    }
%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Investimentos</title>
    </head>

    <body>
        <h1>Investimentos</h1>
        <a href="inserir.jsp">NOVO</a><span> </span>
        <a href="Servlet?acao=RELATORIO">RELATÓRIO</a>
        <table border="1">
            <thead>
                <tr>
                    <th>COD. INVESTIDOR</th>
                    <th>NOME INVESTIDOR</th>
                    <th>COD EMPR. CORRETORA</th>
                    <th>QTD. AÇÕES</th>
                    <th>DT/HR COMPRA</th>
                    <th>PREÇO COMPRA</th>
                    <th>DT/HR VENDA</th>
                    <th>PREÇO VENDA</th>
                    <th>AÇÕES</th>
                </tr>
            </thead>
            <tbody>
                <%                
                    for (InvestimentoDTO investimento : investimentos) {
                %>
                <tr>
                    <td><%= investimento.getCodigoInvestidor() %></td>
                    <td><%= investimento.getNomeInvestidor() %></td>
                    <td><%= investimento.getCodigoEmpresaCorretora() %></td>
                    <td><%= investimento.getQtdAcoes() %></td>
                    <td><%= investimento.getDataHoraCompra() %></td>
                    <td><%= investimento.getPrecoAcaoCompra() %></td>
                    <td><%= investimento.getDataHoraVenda() %></td>
                    <td><%= investimento.getPrecoAcaoVenda() %></td>
                    <td>
                        <form action="Servlet" method="get">
                            <input type="text" name="id" value="<%= investimento %>" hidden>
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