<%@page import="negocio.Vacina"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Vacinas Cadastradas</title>
	
	<% 	
		@SuppressWarnings("unchecked")
		List<Vacina> listaVacinas = (List<Vacina>) request.getAttribute("vacinas");
	%>
	
</head>	
<body>
	
	<h2> Relação de vacinas cadastradas </h2>
	
	<table border="1" >
		<tr>
			<th>Titulo</th>
			<th>Descricao</th>
			<th>Doses</th>
			<th>Periodicidade</th>
			<th>Intervalo</th>
		</tr>
		
		<% for(Vacina v : listaVacinas) { %>
		
		<tr>
			<td><%=v.getTitulo() %></td>
			<td><%=v.getDescricao() %></td>
			<td><%=v.getDoses() %></td>
			<td><%=v.getPeriocidade() %></td>
			<td><%=v.getIntervalo() %></td>
		</tr>
		<% }%>
	</table>
	
	<a href="index.jsp"> Menu principal</a>
	
</body>
</html>