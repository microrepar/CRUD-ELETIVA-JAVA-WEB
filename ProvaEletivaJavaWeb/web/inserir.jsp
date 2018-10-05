<%-- 
    Document   : inserir
    Created on : 04/10/2018, 21:30:09
    Author     : FATEC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Ficha</title>
    </head>
    <body>
        <h1>Nova Ficha</h1>
        <form action="FichaServlet" method="post">
            <div>
                <label for="id_cpf">CPF: </label><br>
                <input type="text" name="cpf" id="id_cpf">
            </div>
            <div>
                <label for="id_nome">NOME: </label><br>
                <input type="text" name="nome" id="id_nome">
            </div><br>
            <div>
                <select name="especialidade">
                    <option value="">Selecione a Especialidade</option>
                    <option value="CLINICO GERAL">Clínico Geral</option>
                    <option value="ORTOPEDIA">Ortopedia</option>
                    <option value="PEDIATRIA">Pediatria</option>
                </select>
            </div><br>
            <div>
                <label for="id_descricao">Descrição dos Sintomas: </label><br>
                <!-- <input type="text" name="descricao" id="id_descricao"> -->
                <textarea name="descricao" id="id_descricao" cols="30" rows="10"></textarea>
            </div>
            <div >
                <label for="id_gravidade">Gravidade</label><br>
                <input type="radio" checked="on" name="gravidade" id="id_gravidade" value="BAIXA">Baixa
                <input type="radio" name="gravidade" id="id_gravidade" value="MEDIA">Média
                <input type="radio" name="gravidade" id="id_gravidade" value="ALTA">Alta
            </div> <br>
            <div>
                <input type="submit" value="CANCELAR" formaction="index.jsp">
                <input type="submit" name="acao" value="SALVAR">
            </div>
        </form>
    </body>
</html>
