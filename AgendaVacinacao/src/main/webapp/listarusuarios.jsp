<%@page import="negocio.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuários Cadastrados</title>

<%
	@SuppressWarnings("unchecked")
	List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("usuarios");

%>

</head>
<body>
	
	<h2>Relação de usuários cadastradas</h2>
	
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Data Nascimento</th>
			<th>Sexo</th>
			<th>Logradouro</th>
			<th>Numero</th>
			<th>Setor</th>
			<th>Cidade</th>
			<th>Estado</th>
		</tr>
		
		<% for(Usuario u : listaUsuarios) { %>		
		<tr>
			<td><%=u.getNome()%></td>
			<td><%=u.getDataNascimento()%></td>
			<td><%=u.getSexo()%></td>
			<td><%=u.getLougradouro()%></td>
			<td><%=u.getNumero()%></td>
			<td><%=u.getSetor()%></td>
			<td><%=u.getCidade()%></td>
			<td><%=u.getUf()%></td>
		</tr>
		<% } %>		
	</table>
	
	<a href="index.jsp"> Menu principal</a>
	

</body>
</html>