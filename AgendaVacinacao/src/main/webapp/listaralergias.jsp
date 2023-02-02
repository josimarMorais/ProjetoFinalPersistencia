<%@page import="negocio.Alergia"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<title>Alergias Cadastradas</title>
	
	<%
		@SuppressWarnings("unchecked")
		List<Alergia> listarAlergias = (List<Alergia>) request.getAttribute("alergias");
	%>
	
</head>
<body>
	
	<h2> Relação de alergias cadastradas </h2>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
		</tr>
		
		<% for (Alergia alergia : listarAlergias) { %>
		
		<tr>
			<td><%= alergia.getId()%></td>
			<td><%= alergia.getNome()%></td>
		</tr>
		<% } %>
	</table>

	<a href="index.jsp"> Menu Inicial</a>
		
</body>
</html>