<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Inserir Categoria</title>
</head>
<body>
    <center>
		<h1>Inserir Categoria</h1>
		<form action="inserir" method="POST">
			Nome: <input type="text" name="nome" id="nome">
			<input type="submit" value="Inserir">
		</form>
		<a href="listar"> Voltar </a>
	</center>
</body>
</html>