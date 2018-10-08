<%-- 
    Document   : inserir
    Created on : 07/10/2018, 19:21:13
    Author     : Silvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Abastecimento</title>
    </head>

    <body>
        <h1>REGISTRAR ABASTECIMENTO</h1>
        <form action="ServletAbastecimento" method="post">
            <input type="text" name="id" id="id" hidden value="">
            <div>
                <label for="id_codigo_funcionario">Código do Funcionário:</label><br>
                <input type="text" name="codigo_funcionario" id="id_codigo_funcionario">
            </div>
            <div>
                <label for="id_cpf_cliente">CPF do Cliente:</label><br>
                <input type="text" name="cpf_cliente" id="id_cpf_cliente">
            </div><br>
            <div>
                <select name="tipo" id="id_tipo">
                    <option value="">Selecione um tipo de Combustível</option>
                    <option value="GASOLINA">Gasolina</option>
                    <option value="ALCOOL">Álcool</option>
                    <option value="DIESEL">Diesel</option>
                </select>
            </div><br>
            <div>
                <label for="id_qtd_combustivel">Quantidade de Combustível:</label><br>
                <input type="text" name="qtd_combustivel" id="id_qtd_combustivel">
            </div>

            <div>
                <label for="id_valor_total">Valor Total R$:</label><br>
                <input type="text" name="valor_total" id="id_valor_total">
            </div><br>
            <div>
                <select name="tipo_pagamento" id="id_tipo_pagamento">
                    <option value="">Selecione um Tipo de Pagamento:</option>
                    <option value="DINHEIRO">Dinheiro</option>
                    <option value="CARTAO_CREDITO">Cartão de Crédito</option>
                    <option value="CARTAO_DEBITO">Cartão de Débito</option>
                </select>
            </div><br>
            <input type="submit" name="acao" formaction="index.jsp"  value="CANCELAR">
            <input type="submit" name="acao" value="SALVAR">
        </form>
    </body>
</html>