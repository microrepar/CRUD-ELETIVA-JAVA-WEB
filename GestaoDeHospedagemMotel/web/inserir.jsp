<%-- 
    Document   : inserir
    Created on : 06/10/2018, 23:29:40
    Author     : Silvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Hospedagem</title>
    </head>
    <body>
    <h1>NOVA HOSPEDAGEM</h1>

    <form action="HospedagemServlet" method="post">
        
        <div>
            <label for="id_numero">Número da Suite: </label><br>
            <input type="text" name="numero" id="id_numero">
        </div><br>
        <div>
            <select name="tipo">
                <option value="">Selecione o tipo da suite:</option>
                <option value="PE SUJO">Pé Sujo</option>
                <option value="SIMPLES">Simples</option>
                <option value="LUXO">Luxo</option>
                <option value="MASTER">Master</option>
                <option value="PRESIDENCIAL">Presidencial</option>
            </select>
        </div><br>
        <div>
            <label for="id_nome">Nome: </label><br>
            <input type="text" name="nome" id="id_nome">
        </div>
        <div>
            <label for="id_capacidade">Capacidade: </label><br>
            <input type="text" name="capacidade" id="id_capacidade">
        </div>
        <div>
            <label for="id_valor_h">Valor da Hospedagem: </label><br>
            <input type="text" placeholder="R$"  name="valor_h" id="id_valor_h">
        </div>
        <div>
            <label for="id_valor_a">Valor Adicional: </label><br>
            <input type="text" placeholder="R$" name="valor_a" id="id_valor_a">
        </div>
        <div>
            <label for="id_descricao">Descrição de Amenidades: </label><br>
            <!-- <input type="text" name="descricao" id="id_descricao"> -->
            <textarea name="descricao" id="id_descricao" cols="30" rows="10"></textarea>
        </div>
        <div>
            <input type="submit" value="CANCELAR" formaction="index.jsp">
            <input type="submit" name="acao" value="SALVAR">
        </div>
    </form>
</body>
</html>
