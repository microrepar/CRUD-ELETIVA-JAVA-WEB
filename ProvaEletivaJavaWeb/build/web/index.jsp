<%-- 
    Document   : fichas
    Created on : 04/10/2018, 20:56:35
    Author     : FATEC
--%>

<%@page import="br.com.fatec.eletivaJava.FichaPacienteDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<FichaPacienteDTO> fichas = (List<FichaPacienteDTO>) request.getAttribute("fichas");

    if (null == fichas) {
        response.sendRedirect(request.getContextPath() + "/FichaServlet");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fichas dos Pacientes</title>
    </head>
    <body>
        <h1>Fichas dos Pacientes</h1>
        <div>
            <a href="">RELATÓRIO</a>
            <a href="inserir.jsp">NOVA FICHA</a>
        </div> <br>
        <table border="1">
            <thead>
                <tr>
                    <th>CPF</th>
                    <th>NOME</th>
                    <th>ESPECIALIDADE</th>
                    <th>GRAVIDADE</th>
                    <th>DATA/HORA</th>
                    <th>ACÕES</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (FichaPacienteDTO ficha : fichas) {
                %>
                <tr>
                    <td><%= ficha.getCpf() %></td>
                    <td><%= ficha.getNome()%></td>
                    <td><%= ficha.getEspecialidade()%></td>
                    <td><%= ficha.getGravidade()%></td>
                    <td><%= ficha.getDataHora()%></td>
                    <td>
                        <form action="FichaServlet" method="post">
                            <input type="text" hidden  name="id" value="<%= ficha.getId() %>">
                            <input type="submit" name="acao" value="EXCLUIR">
                            <input type="submit" name="acao" value="EDITAR">
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
