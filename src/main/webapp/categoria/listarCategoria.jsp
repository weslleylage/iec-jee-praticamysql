<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Categorias</title>
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
		<h1>Categorias de Despesas</h1>
        <h2>
        	<a href="inserir">Inserir Nova Categoria</a>
        	&nbsp;&nbsp;&nbsp;       	        	
        </h2>
	</center>
    <div align="center">
        <table>
            <caption><h2>Lista de Categorias</h2></caption>
            <tr>
                <th>C&oacute;digo</th>
                <th>Nome</th>
                <th>A&ccedil;&otilde;es</th>
            </tr>
            <c:forEach var="categoria" items="${listaCategoria}">
                <tr>
                    <td><c:out value="${categoria.codigo}" /></td>
                    <td><c:out value="${categoria.nome}" /></td>                   
                    
                    <td>
                    	<a href="editar?id=<c:out value='${categoria.codigo}' />">Alterar</a>
                    		&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deletar?id=<c:out value='${categoria.codigo}' />">Deletar</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="${contextPath}/produto/listar?codigo_categoria=<c:out value='${categoria.codigo}' />">Listar Produtos</a>
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