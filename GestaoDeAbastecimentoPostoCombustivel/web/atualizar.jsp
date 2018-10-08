<%-- 
    Document   : atualizar
    Created on : 07/10/2018, 19:21:40
    Author     : Silvio
--%>

<%@page import="br.com.eletivaJavaWeb.AbastecimentoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% AbastecimentoDTO abastecimento = (AbastecimentoDTO) request.getAttribute("abastecimentoDTO");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Abastecimento</title>
    </head>
    <body>
        <h1>ATUALIZAR REGISTRO DE ABASTECIMENTO</h1>
        <form action="ServletAbastecimento" method="post">
            <input type="text" name="id" id="id" hidden value="<%= abastecimento.getId()%>">
            <div>
                <label for="id_codigo_funcionario">Código do Funcionário:</label><br>
                <input type="text" name="codigo_funcionario" id="id_codigo_funcionario" value="<%= abastecimento.getCodigoFuncionario()%>">
            </div>
            <div>
                <label for="id_cpf_cliente">CPF do Cliente:</label><br>
                <input type="text" name="cpf_cliente" id="id_cpf_cliente" value="<%= abastecimento.getCpfCliente()%>">
            </div><br>
            <div>
                <select name="tipo" id="id_tipo">
                    <% if (null == abastecimento.getTipoCombustivel()) {%>
                    <option value="">Selecione um tipo de Combustível</option>
                    <option value="GASOLINA">Gasolina</option>
                    <option value="ALCOOL">Álcool</option>
                    <option value="DIESEL">Diesel</option>
                    <%}else if (abastecimento.getTipoCombustivel().equals("GASOLINA")) {%>
                    <option value="">Selecione um tipo de Combustível</option>
                    <option selected="on" value="GASOLINA">Gasolina</option>
                    <option value="ALCOOL">Álcool</option>
                    <option value="DIESEL">Diesel</option>
                    <%} else if (abastecimento.getTipoCombustivel().equals("ALCOOL")) {%>
                    <option value="">Selecione um tipo de Combustível</option>
                    <option value="GASOLINA">Gasolina</option>
                    <option selected="on" value="ALCOOL">Álcool</option>
                    <option value="DIESEL">Diesel</option>
                    <%} else {%>
                    <option value="">Selecione um tipo de Combustível</option>
                    <option value="GASOLINA">Gasolina</option>
                    <option value="ALCOOL">Álcool</option>
                    <option selected="on" value="DIESEL">Diesel</option>
                    <% }%>
                </select>
            </div><br>
            <div>
                <label for="id_qtd_combustivel">Quantidade de Combustível:</label><br>
                <input type="text" name="qtd_combustivel" id="id_qtd_combustivel" value="<%= abastecimento.getQtdCombustivel()%>">
            </div>
            <div>
                <label for="id_valor_total">Valor Total R$:</label><br>
                <input type="text" name="valor_total" id="id_valor_total" value="<%= abastecimento.getValorTotal()%>">
            </div><br>
            <div>
                <select name="tipo_pagamento" id="id_tipo_pagamento">
                    <% if(null == abastecimento.getTipoPagamento()){ %>
                    <option value="">Selecione um Tipo de Pagamento:</option>
                    <option value="DINHEIRO">Dinheiro</option>
                    <option value="CARTAO_CREDITO">Cartão de Crédito</option>
                    <option value="CARTAO_DEBITO">Cartão de Débito</option>
                    <% }else if(abastecimento.getTipoPagamento().equals("DINHEIRO")){ %>
                    <option value="">Selecione um Tipo de Pagamento:</option>
                    <option selected="on" value="DINHEIRO">Dinheiro</option>
                    <option value="CARTAO_CREDITO">Cartão de Crédito</option>
                    <option value="CARTAO_DEBITO">Cartão de Débito</option>
                    <% } else if(abastecimento.getTipoPagamento().equals("CARTAO_CREDITO")){ %>
                    <option value="">Selecione um Tipo de Pagamento:</option>
                    <option value="DINHEIRO">Dinheiro</option>
                    <option selected="on" value="CARTAO_CREDITO">Cartão de Crédito</option>
                    <option value="CARTAO_DEBITO">Cartão de Débito</option>
                    <% }else { %>
                    <option value="">Selecione um Tipo de Pagamento:</option>
                    <option value="DINHEIRO">Dinheiro</option>
                    <option value="CARTAO_CREDITO">Cartão de Crédito</option>
                    <option selected="on" value="CARTAO_DEBITO">Cartão de Débito</option>
                    <% }%>
                </select>
            </div><br>
            <input type="submit" name="acao" formaction="index.jsp" value="CANCELAR">
            <input type="submit" name="acao" value="ATUALIZAR">
        </form>
    </body>
</html>
