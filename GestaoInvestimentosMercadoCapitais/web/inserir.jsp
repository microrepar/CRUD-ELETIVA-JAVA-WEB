<%-- 
    Document   : inserir
    Created on : 08/10/2018, 21:16:46
    Author     : Silvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Novo Investimento</title>
</head>

<body>
    <h1>NOVO INVESTIMENTO</h1>
    <form action="Servlet" method="post">
        <input type="text" hidden name="id" value="" id="">
        <div>
            <label for="id_codigo_investidor">Código do Investidor:</label><br>
            <input type="text" name="codigo_investidor" id="id_codigo_investidor">
        </div>
        <div>
            <label for="id_nome_investidor">Nome do Investidor:</label><br>
            <input type="text" name="nome_investidor" id="id_nome_investidor">
        </div>
        <div>
            <label for="id_codigo_corretora">Código da Corretora:</label><br>
            <input type="text" name="codigo_corretora" id="id_codigo_corretora">
        </div>
        <div>
            <label for="id_qtd_acoes">Quantidade de Ações:</label><br>
            <input type="text" name="qtd_acoes" id="id_qtd_acoes" >
        </div>
        <div>
            <label for="id_data_compra">Data da Compra:</label><br>
            <input type="date" name="data_compra" id="id_data_compra">
            <label for="id_hora_compra">Hora da Compra:</label>
            <input type="time" name="hora_compra" id="id_hora_compra">
        </div>
        <div>
            <label for="id_preco_compra">Preço da Compra:</label><br>
            <input type="text" name="preco_compra" id="id_preco_compra">
        </div>
        <div>
            <label for="id_data_venda">Data da Venda:</label><br>
            <input type="date" name="data_venda" id="id_data_venda">
            <label for="id_hora_venda">Hora da Venda:</label>
            <input type="time" name="hora_venda" id="id_hora_venda">
        </div>
        <div>
            <label for="id_preco_venda">Preço da Venda:</label><br>
            <input type="text" name="preco_venda" id="id_preco_venda">
        </div><br>
        <div>
            <input type="submit" formaction="index.jsp" name="acao" value="CANCELAR">
            <input type="submit" name="acao" value="SALVAR">
        </div>
    </form>
</body>

</html>