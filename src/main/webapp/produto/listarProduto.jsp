<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Produtos</title>
<style>
    table, th, td {
        border: 0.5px solid black;
        border-collapse: collapse;
        padding: 10px;
    }
</style>
</head>
<body>
	<center>
		<h1>Produtos Cadastrados</h1>
        <h2>
        	<a href="inserir">Inserir Novo Produto</a>
        	&nbsp;&nbsp;&nbsp;
        </h2>
        <form action="listar" method="POST">
            <label for="nome">Nome <input type="text" name="nome" id="nome" value="" /></label>&nbsp;&nbsp;&nbsp;<input type="submit" value="Pesquisar" /><br />
        </form>
	</center>
    <div align="center">
        <table>
            <caption><h2>Lista de produtos</h2></caption>
            <tr>
                <th>C&oacute;digo</th>
                <th>Nome</th>
                <th>Pre&ccedil;o</th>
                <th>Categoria</th>
                <th>A&ccedil;&otilde;es</th>
            </tr>
            <c:forEach var="produto" items="${listaProduto}">
                <tr>
                    <td><c:out value="${produto.codigo}" /></td>
                    <td><c:out value="${produto.nome}" /></td>
                    <td><c:out value="${produto.preco}" /></td>
                    <td><c:out value="${produto.categoria.nome}" /></td>
                    <td>
                    	<a href="editar?id=<c:out value='${produto.codigo}' />">Alterar</a>
                    		&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deletar?id=<c:out value='${produto.codigo}' />">Deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </br>
        </br>
        <a href="${contextPath}"> Ir para o inicio </a>
    </div>
</body>

</html>