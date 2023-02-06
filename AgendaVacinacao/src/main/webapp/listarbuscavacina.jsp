<%@page import="negocio.Vacina"%>
<%@page import="java.util.List"%>
<jsp:include page="cabecalho.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	
	<%
		@SuppressWarnings("unchecked")
		List<Vacina> listarVacinas = (List<Vacina>) request.getAttribute("vacinas");
	%>

</head>
<body>
	<div class="container">
		<div class="row py-3">
			<div class="col">
				<h4 class="my-1 py-2 text-sm-center">Resultado da busca</h4>
				
				<% if(listarVacinas.isEmpty()) {%>
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
						<th>Titulo</th>
						<th>Descrição</th>
						<th>Doses</th>
						<th>Periodicidade</th>
						<th>Intervalo</th>
						
					</tr>
					
					<% for (Vacina v : listarVacinas) { %>
					
					<tr class="text-right">
						<td><%=v.getTitulo()%></td>
						<td><%=v.getDescricao()%></td>
						<td><%=v.getDoses()%></td>
						<td><%=v.getPeriocidade()%></td>
						<td><%=v.getIntervalo()%></td>
					<% } %>
				<%}%>
				</table>		
			</div>
		</div>
	</div>
	
	
</body>
</html>