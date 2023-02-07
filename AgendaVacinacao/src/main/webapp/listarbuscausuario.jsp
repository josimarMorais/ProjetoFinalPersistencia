<%@page import="negocio.Alergia"%>
<%@page import="negocio.Usuario"%>
<%@page import="java.util.List"%>
<jsp:include page="cabecalho.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<%
	@SuppressWarnings("unchecked")
	List<Usuario> listarUsuarios = (List<Usuario>) request.getAttribute("usuarios");

	@SuppressWarnings("unchecked")
	List<Alergia> listarAlergias = (List<Alergia>) request.getAttribute("alergias");
	

%>

</body>
	
	<div class="container">
		<div class="row py-3">
			<div class="col">
				<h4 class="my-1 py-2 text-sm-center">Resultado da busca</h4>
				
				<% if(listarUsuarios.isEmpty()) {%>
					<div class="container">
					<div class="row py-3">
						<div class="col">
							<h5 class="my-1 py-2 text-sm-center">nenhum Resultado encontrado!</h5>
						</div>
					</div>
				</div>
					
				<%} else {%>
				<table class="table">
					<tr>
						<th>Nome</th>
						<th>Data Nascimento</th>
						<th>Sexo</th>
						<th>Logradouro</th>
						<th>Numero</th>
						<th>Setor</th>
						<th>Cidade</th>
						<th>Estado</th>
						<th>Alergias</th>
					</tr>
					
					<% for (Usuario u : listarUsuarios) { %>
					
					<tr class="text-right">
						<td><%=u.getNome()%></td>
						<td><%=u.getDataNascimento()%></td>
						<td><%=u.getSexo()%></td>
						<td><%=u.getLougradouro()%></td>
						<td><%=u.getNumero()%></td>
						<td><%=u.getSetor()%></td>
						<td><%=u.getCidade()%></td>
						<td><%=u.getUf()%></td>
						<td>
							<%for (Alergia a : listarAlergias) { %>
							<span class="badge bg-warning"><%=a.getNome()%></span>
							<% } %>
						</td>
					</tr>
					<% } %>
				</table>	
			<% } %>	
			</div>
		</div>
	</div>
	

</html>