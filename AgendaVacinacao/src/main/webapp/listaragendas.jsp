<%@page import="negocio.Agenda"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Agendas Cadastradas</title>
	<%
	@SuppressWarnings("unchecked")
	List<Agenda> listaAgendas = (List<Agenda>) request.getAttribute("agendas");
	%>
	
</head>
<body>
	
	<h2>Relação de agendas cadastradas</h2>
	
	<table border="1">
		<tr>
			<th>Data</th>
			<th>hora</th>
			<th>Situacao</th>
			<th>Data Situacao</th>
			<th>Observações</th>
		</tr>
		
		<% for(Agenda a : listaAgendas) { %>		
		<tr>
			<td><%=a.getData()%></td>
			<td><%=a.getHora() %></td>
			<td><%=a.getSituacao() %></td>
			<td><%=a.getDataSituacao() %></td>
			<td><%=a.getObservacao() %></td>
		</tr>
		<% } %>		
	</table>
	
	<a href="index.jsp"> Menu principal</a>
	
</body>
</html>