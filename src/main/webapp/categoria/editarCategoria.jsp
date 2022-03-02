<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Editar Categoria</title>
</head>
<body>
    <center>
		<h1>Editar Categoria</h1>
		<form action="editar" method="POST">
            <input type="hidden" name="codigo" value="${categoria.codigo}" />
			Nome: <input type="text" name="nome" id="nome" value="${categoria.nome}">
			<input type="submit" value="Editar">
		</form>
		<a href="listar"> Voltar </a>
	</center>
</body>
</html>