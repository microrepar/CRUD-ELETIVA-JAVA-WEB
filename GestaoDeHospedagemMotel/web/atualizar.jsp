<%-- 
    Document   : inserir
    Created on : 06/10/2018, 23:29:40
    Author     : Silvio
--%>

<%@page import="br.com.eletivaJavaWeb.HospedagemDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<% HospedagemDTO hospedagem = (HospedagemDTO) request.getAttribute("hospedagemDTO"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Hospedagem</title>
    </head>
    <body>
    <h1>ATUALIZAR HOSPEDAGEM</h1>

    <form action="HospedagemServlet" method="post">
        <input hidden="on" type="text" name="id" id="id_hospedagem" value="<%= hospedagem.getId() %>">
        <div>
            <label for="id_numero">Número da Suite: </label><br>
            <input type="text" name="numero" id="id_numero" value="<%= hospedagem.getNumeroSuite() %>">
        </div><br>
        <div>
            <select name="tipo">
                <% if(hospedagem.getTipo().equals("PE SUJO")){ %>
                <option value="">Selecione o tipo da suite:</option>
                <option selected="on" value="PE SUJO">Pé Sujo</option>
                <option value="SIMPLES">Simples</option>
                <option value="LUXO">Luxo</option>
                <option value="MASTER">Master</option>
                <option value="PRESIDENCIAL">Presidencial</option>
                <% }else if(hospedagem.getTipo().equals("SIMPLES")){ %>
                <option value="">Selecione o tipo da suite:</option>
                <option value="PE SUJO">Pé Sujo</option>
                <option selected="on" value="SIMPLES">Simples</option>
                <option value="LUXO">Luxo</option>
                <option value="MASTER">Master</option>
                <option value="PRESIDENCIAL">Presidencial</option>
                <% }else if(hospedagem.getTipo().equals("LUXO")){ %>
                <option value="">Selecione o tipo da suite:</option>
                <option value="PE SUJO">Pé Sujo</option>
                <option value="SIMPLES">Simples</option>
                <option selected="on" value="LUXO">Luxo</option>
                <option value="MASTER">Master</option>
                <option value="PRESIDENCIAL">Presidencial</option>
                <% }else if(hospedagem.getTipo().equals("MASTER")){ %>
                <option value="">Selecione o tipo da suite:</option>
                <option value="PE SUJO">Pé Sujo</option>
                <option value="SIMPLES">Simples</option>
                <option value="LUXO">Luxo</option>
                <option selected="on" value="MASTER">Master</option>
                <option value="PRESIDENCIAL">Presidencial</option>
                <% }else { %>
                <option value="">Selecione o tipo da suite:</option>
                <option value="PE SUJO">Pé Sujo</option>
                <option value="SIMPLES">Simples</option>
                <option value="LUXO">Luxo</option>
                <option value="MASTER">Master</option>
                <option selected="on" value="PRESIDENCIAL">Presidencial</option>
                <% } %>
            </select>
        </div><br>
        <div>
            <label for="id_nome">Nome: </label><br>
            <input type="text" name="nome" id="id_nome" value="<%= hospedagem.getNome() %>">
        </div>
        <div>
            <label for="id_capacidade">Capacidade: </label><br>
            <input type="text" name="capacidade" id="id_capacidade" value="<%= hospedagem.getCapacidade() %>">
        </div>
        <div>
            <label for="id_valor_h">Valor da Hospedagem: </label><br>
            <input type="text" placeholder="R$"  name="valor_h" id="id_valor_h" value="<%= hospedagem.getValorHospedagem() %>">
        </div>
        <div>
            <label for="id_valor_a">Valor Adicional: </label><br>
            <input type="text" placeholder="R$" name="valor_a" id="id_valor_a" value="<%= hospedagem.getValorAdicionais() %>">
        </div>
        <div>
            <label for="id_descricao">Descrição de Amenidades: </label><br>
            <!-- <input type="text" name="descricao" id="id_descricao"> -->
            <textarea name="descricao" id="id_descricao" cols="30" rows="10"><%= hospedagem.getDescAmenidade() %></textarea>
        </div>
        <div>
            <input type="submit" value="CANCELAR" formaction="index.jsp">
            <input type="submit" name="acao" value="ATUALIZAR">
            <input type="submit" name="acao" value="FINALIZAR">
        </div>
    </form>
</body>
</html>
