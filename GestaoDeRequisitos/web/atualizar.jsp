<%-- 
    Document   : atualizar
    Created on : 02/10/2018, 20:37:54
    Author     : Silvio
--%>

<%@page import="br.com.microrepar.RequisitoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% RequisitoDTO requisito = (RequisitoDTO) request.getAttribute("requisito"); %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Atualizar Requisito</title>
</head>

<body>
    <h1>ATUALIZAR REQUISITO</h1>

    <form action="ServicoRequisito" method="post">
        <input type="text" hidden name="id" value="<%= requisito.getId() %>">
        <div>
            <% if (requisito.getTipo().equals("FUNCIONAL")) {%>
            <input type="radio" checked="on" name="tipo" id="id_tipo" value="FUNCIONAL">Funcional
            <input type="radio" name="tipo" id="id_tipo" value="N_FUNCIONAL">Não Funcional
            <% } else {%>
            <input type="radio" name="tipo" id="id_tipo" value="FUNCIONAL">Funcional
            <input type="radio" checked="on" name="tipo" id="id_tipo" value="N_FUNCIONAL">Não Funcional
            <% } %>
        </div>
        <div>
            <label for="id_sigla">Sigla: </label><br>
            <input type="text" name="sigla" id="id_sigla" value="<%= requisito.getSigla() %>">
        </div>
        <div>
            <label for="id_nome">Nome: </label><br>
            <input type="text" name="nome" id="id_nome" value="<%= requisito.getNome()%>">
        </div>
        <div>
            <label for="id_descricao">Descrição: </label><br>
            <!-- <input type="text" name="descricao" id="id_descricao" value=""> -->
            <textarea name="descricao" id="id_descricao" cols="30" rows="10"><%= requisito.getDescricao()%></textarea>
        </div>
        <div>
            <select name="escopo">
                <option value="">Selecione</option>
                <% if(requisito.getEscopo().equals("USUARIO")){ %>
                <option selected="on" value="USUARIO">Usuário</option>
                <option value="SISTEMA">Sistema</option>
                <% }else{ %>
                <option value="USUARIO">Usuário</option>
                <option selected="on" value="SISTEMA">Sistema</option>
                <% } %>
            </select>
        </div>
        <br>
        <div>
            <input type="submit" value="CANCELAR" formaction="index.jsp">
            <input type="submit" name="acao" value="ATUALIZAR">
        </div>
</body>

</html>