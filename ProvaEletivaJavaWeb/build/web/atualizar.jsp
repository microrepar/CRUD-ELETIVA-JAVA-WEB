<%-- 
    Document   : atualizar
    Created on : 05/10/2018, 17:41:47
    Author     : m.c.silva
--%>

<%@page import="br.com.fatec.eletivaJava.FichaPacienteDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    FichaPacienteDTO ficha = (FichaPacienteDTO) request.getAttribute("ficha");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Ficha</title>
    </head>
    <body>
        <h1>Atualizar Ficha</h1>
        <form action="FichaServlet" method="post">
            <input name="id" value="<%= ficha.getId()%>">
            <div>

                <label for="id_cpf">CPF: </label><br>
                <input type="text" name="cpf" id="id_cpf" value="<%= ficha.getCpf()%>" >
            </div>
            <div>
                <label for="id_nome">NOME: </label><br>
                <input type="text" name="nome" id="id_nome" value="<%= ficha.getNome()%>">
            </div><br>
            <div>
                <select name="especialidade">
                    <% if (ficha.getEspecialidade().equals("CLINICO GERAL")) { %>
                    <option value="">Selecione a Especialidade</option>
                    <option selected="on" value="CLINICO GERAL">Clínico Geral</option>
                    <option value="ORTOPEDIA">Ortopedia</option>
                    <option value="PEDIATRIA">Pediatria</option>
                    <% } else if (ficha.getEspecialidade().equals("ORTOPEDIA")) { %>
                    <option value="">Selecione a Especialidade</option>
                    <option value="CLINICO GERAL">Clínico Geral</option>
                    <option selected="on" value="ORTOPEDIA">Ortopedia</option>
                    <option value="PEDIATRIA">Pediatria</option>
                    <% } else { %>
                    <option value="">Selecione a Especialidade</option>
                    <option value="CLINICO GERAL">Clínico Geral</option>
                    <option value="ORTOPEDIA">Ortopedia</option>
                    <option selected="on" value="PEDIATRIA">Pediatria</option>
                    <% }%>
                </select>
            </div><br>
            <div>
                <label for="id_descricao">Descrição dos Sintomas: </label><br>
                <!-- <input type="text" name="descricao" id="id_descricao"> -->
                <textarea name="descricao" id="id_descricao" cols="30" rows="10"><%= ficha.getDescSintomas() %></textarea>
            </div>
            <div >
                <label for="id_gravidade">Gravidade</label><br>
                <% if (ficha.getGravidade().equals("BAIXA")) { %>
                <input type="radio" checked="on" name="gravidade" id="id_gravidade" value="BAIXA">Baixa
                <input type="radio" name="gravidade" id="id_gravidade" value="MEDIA">Média
                <input type="radio" name="gravidade" id="id_gravidade" value="ALTA">Alta
                <% } else if (ficha.getGravidade().equals("MEDIA")) { %>
                <input type="radio" name="gravidade" id="id_gravidade" value="BAIXA">Baixa
                <input type="radio" checked="on" name="gravidade" id="id_gravidade" value="MEDIA">Média
                <input type="radio" name="gravidade" id="id_gravidade" value="ALTA">Alta
                <% } else { %>
                <input type="radio" name="gravidade" id="id_gravidade" value="BAIXA">Baixa
                <input type="radio" name="gravidade" id="id_gravidade" value="MEDIA">Média
                <input type="radio" checked="on" name="gravidade" id="id_gravidade" value="ALTA">Alta
                <% } %>
            </div> <br>
            <div>
                <input type="submit" value="CANCELAR" formaction="index.jsp">
                <input type="submit" name="acao" value="ATUALIZAR">
            </div>
        </form>
    </body>
</html>
