<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Editar Produto</title>
</head>
<body>
    <center>
		<h1>Editar Produto</h1>
		<form action="editar" method="POST">
            <input type="hidden" name="codigo" value="${produto.codigo}" />
            <label for="nome">Nome <input type="text" name="nome" id="nome" value="${produto.nome}" /></label><br />
            <label for="preco">Pre&ccedil;o  <input type="text" name="preco" id="preco" value="${produto.preco}" /></label><br />
            <label for="codigo_categoria">Categoria
                <select name="codigo_categoria" id="codigo_categoria">
                    <option value="">Selecione...</option>
                    <c:forEach var="categoria" items="${listaCategoria}">
                        <option value="${categoria.codigo}" ${categoria.codigo == produto.categoria.codigo ? " selected" : ""}>${categoria.nome}</option>
                    </c:forEach>
                </select>
            </label>
            <br />
			<input type="submit" value="Editar">
		</form>
		<a href="listar"> Voltar </a>
	</center>
</body>
</html>