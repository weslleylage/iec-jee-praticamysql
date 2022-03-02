<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Inserir Produto</title>
<style>
    label {
        padding: 5px;
    }
</style>
</head>
<body>
    <center>
		<h1>Inserir Produto</h1>
		<form action="inserir" method="POST">
            <label for="nome">Nome <input type="text" name="nome" id="nome" value="" /></label><br />
            <label for="preco">Pre&ccedil;o  <input type="text" name="preco" id="preco" value="" /></label><br />
            <label for="codigo_categoria">Categoria
                <select name="codigo_categoria" id="codigo_categoria">
                    <option value="">Selecione...</option>
                    <c:forEach var="categoria" items="${listaCategoria}">
                        <option value="${categoria.codigo}">${categoria.nome}</option>
                    </c:forEach>
                </select>
            </label>
            <br />
            <input type="submit" value="Inserir">
		</form>
		<a href="listar"> Voltar </a>
	</center>
</body>
</html>