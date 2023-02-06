<jsp:include page="cabecalho.jsp" />
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
	
	<div class="container">
		<div class="row py-3">
			<div class="col">
					
				<h4 class="my-1 py-2 text-sm-center">Relação de Agendas Cadastradas</h4>
				
				<table class="table">
					<tr>
						<th>Data</th>
						<th>hora</th>
						<th>Situacao</th>
						<th>Data Situacao</th>
						<th>Observações</th>
						<th></th>
					</tr>
					
					<% for(Agenda a : listaAgendas) { %>		
					<tr>
						<td><%=a.getData()%></td>
						<td><%=a.getHora() %></td>
						<td><%=a.getSituacao() %></td>
						<td><%=a.getDataSituacao() %></td>
						<td><%=a.getObservacoes() %></td>
						<td><button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal"
								onclick="onDelete('<%=a.getId()%>','<%=a.getData()%>', '<%=a.getHora()%>' )" >Deletar</button></td>
					</tr>
					<% } %>		
				</table>
				
				
				<!-- Modal Delete -->
				<div class="modal fade" id="deleteModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Realmente deseja apagar?</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							</div>
							<div class="modal-body">
	
								<form method="post" action="ExcluirAgenda">
	
									<div class="mb-3">
										<input type="text" class="form-control-plaintext" id="txtData" name="txtData">
									</div>
									<div class="mb-3">
										<input type="text" class="form-control-plaintext" id="txtHora" name="txtHora">
									</div>
	
									<input type="hidden" name="id" value="">
	
									<button type="submit" class="btn btn-danger mt-2">Deletar</button>
									<button type="button" class="btn btn-secondary mt-2" data-bs-dismiss="modal">Cancelar</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div><!-- Modal Delete Fim -->						
				
		</div>
	</div>
	
	<script type="text/javascript">
		function onDelete(id, nome, hora) {			
			var idEl = document.querySelector("div#deleteModal input[name='id']");
			var dataEl = document.querySelector("div#deleteModal input[name='txtData']");
			var horaEl = document.querySelector("div#deleteModal input[name='txtHora']");
			
			idEl.value = id;
			dataEl.value = nome;
			horaEl.value = hora;
		}
	</script>
	
	
</body>
</html>