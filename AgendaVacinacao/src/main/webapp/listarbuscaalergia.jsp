<%@page import="negocio.Alergia"%>
<%@page import="java.util.List"%>
<jsp:include page="cabecalho.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<%
		@SuppressWarnings("unchecked")
		List<Alergia> listarAlergias = (List<Alergia>) request.getAttribute("alergias");
	%>

</head>
<body>
		<div class="container">
		<div class="row py-3">
			<div class="col">
				<h4 class="my-1 py-2 text-sm-center">Resultado da busca</h4>
				
				<% if(listarAlergias.isEmpty()) {%>
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
					</tr>
					
					<% for (Alergia alergia : listarAlergias) { %>
					
					<tr class="text-right">
						<td><%= alergia.getNome()%></td>
					<% } %>
				<%}%>
				</table>		
			</div>
		</div>
	</div>
</body>
</html>