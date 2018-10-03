<%-- 
    Document   : inserir
    Created on : 02/10/2018, 20:36:38
    Author     : Silvio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Novo Requisito</title>
</head>

<body>
    <h1>NOVO REQUISITO</h1>

    <form action="ServicoRequisito" method="post">
        <div>

            <input type="radio" name="tipo" id="id_tipo" value="funcional">Funcional
            <input type="radio" name="tipo" id="id_tipo" value="nao_funcional">Não Funcional
        </div>
        <div>
            <label for="id_sigla">Sigla: </label><br>
            <input type="text" name="sigla" id="id_sigla">
        </div>
        <div>
            <label for="id_nome">Nome: </label><br>
            <input type="text" name="nome" id="id_nome">
        </div>
        <div>
            <label for="id_descricao">Descrição: </label><br>
            <input type="text" name="descricao" id="id_descricao">
        </div>
        <select name="escopo">
            <option value="">Selecione</option>
            <option value="usuario">Usuário</option>
            <option value="sistema">Sistema</option>
        </select>
        <div>
            <input type="submit" value="CANCELAR" formaction="index.jsp">
            <input type="submit" value="SALVAR">
        </div>
    </form>
</body>

</html>