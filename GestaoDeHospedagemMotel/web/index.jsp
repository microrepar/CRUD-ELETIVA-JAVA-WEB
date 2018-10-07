<%-- 
    Document   : index
    Created on : 06/10/2018, 22:01:16
    Author     : Silvio
--%>

<%@page import="br.com.eletivaJavaWeb.HospedagemDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<HospedagemDTO> dtos = (List<HospedagemDTO>) request.getAttribute("hospedagemsDTO");
    
    if (null == dtos) {
        response.sendRedirect(request.getContextPath() + "/HospedagemServlet");
        return;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão de Motel</title>
    </head>
    <body>
        <h1>Gestão de Motel</h1>
        <a href="inserir.jsp">NOVO</a>
        <a href="HospedagemServlet?acao=RELATORIO">RELATÓRIO</a>
        <table border="1">
            <thead >
                <tr>
                    <th>TIPO</th>
                    <th>NUMERO</th>
                    <th>NOME</th>
                    <th>CAPACIDADE</th>
                    <th>ENTRADA</th>
                    <th>SAIDA</th>
                    <th>VALOR_H</th>
                    <th>VALOR_A</th>
                    <th>ACÕES</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (HospedagemDTO hospedagem : dtos) {
                %>
                <tr>
                    <td><%= hospedagem.getTipo()%></td>
                    <td><%= hospedagem.getNumeroSuite()%></td>
                    <td><%= hospedagem.getNome() %></td>
                    <td><%= hospedagem.getCapacidade() %></td>
                    <td><%= hospedagem.getEntrada() %></td>
                    <td><%= hospedagem.getSaida() %></td>
                    <td><%= hospedagem.getValorHospedagem() %></td>
                    <td><%= hospedagem.getValorAdicionais() %></td>
                    <td>
                        <form action="HospedagemServlet" method="get">
                            <input type="text" hidden name="id" value="<%= hospedagem.getId() %>">
                            <input type="submit" name="acao" value="EDITAR">
                            <input type="submit" name="acao" value="EXCLUIR">
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
