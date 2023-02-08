<%@page import="negocio.Agenda"%>
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

List<Agenda> listaAgendas = (List<Agenda>) request.getAttribute("agendas");

%>

</head>

<body>

	<div class="container">
		<div class="row py-3">
			<div class="col">
				
				<h4 class="my-5 py-2 text-sm-center">Área de listagem das agendas utilizando filtros</h4>
				
				<div class="row justify-content-around">
					<div class="col-3">
						<form method="get" action="BuscarAgenda">

							<input type="hidden" name="btnBuscar" value="REALIZADA" />
							<button type="submit" class="btn btn-info text-white">Realizada</button>
						</form>
					</div>
					<div class="col-3">
						<form method="get" action="BuscarAgenda">
							<input type="hidden" name="btnBuscar" value="CANCELADA" /> 
							<button type="submit" class="btn btn-info text-white"> Cancelada</button>
						</form>
					</div>

					<div class="col-3">
						<input type="hidden" name="btnBuscar" value="DATA" />
						<button class="btn btn-info text-white" data-bs-toggle="modal" data-bs-target="#deleteModal" >Data atual</button>
					</div>
					
					<div class="col-3">
						<input type="hidden" name="btnBuscar" value="USUARIO" />
						<button class="btn btn-info text-white" data-bs-toggle="modal" data-bs-target="#searchModal"> Busca por Usuário</button>						
					</div>
				</div>
				
				
				<table class="table my-4">
					<tr>
						<th>Data</th>
						<th>Situacao</th>
						<th>Vacina</th>
						<th>Dose</th>
						<th></th>
					</tr>

					<%
					for (Agenda a : listaAgendas) {
					%>
					<tr>
						<td><%=a.getData()%></td>
						<td><%=a.getSituacao()%></td>
						<td><%=a.getVacina().getTitulo()%></td>
						<td><%=a.getVacina().getDoses()%></td>
					</tr>
					<%
					}
					%>
				</table>
				
				
				
				<!-- Modal Delete -->
				<div class="modal fade" id="deleteModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Realmente deseja apagar?</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<form method="post" action="ExcluirAgenda">

									<div class="mb-3">
										<input type="text" class="form-control-plaintext" id="txtData"
											name="txtData">
									</div>
									<div class="mb-3">
										<input type="text" class="form-control-plaintext" id="txtHora"
											name="txtHora">
									</div>

									<input type="hidden" name="id" value="">

									<button type="submit" class="btn btn-danger mt-2">Deletar</button>
									<button type="button" class="btn btn-secondary mt-2"
										data-bs-dismiss="modal">Cancelar</button>
								</form>
							</div>
						</div>
					</div>
				</div><!-- Modal Delete Fim -->
				
				
				
				
				

			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function onDelete(id, nome, hora) {
			var idEl = document
					.querySelector("div#deleteModal input[name='id']");
			var dataEl = document
					.querySelector("div#deleteModal input[name='txtData']");
			var horaEl = document
					.querySelector("div#deleteModal input[name='txtHora']");

			idEl.value = id;
			dataEl.value = nome;
			horaEl.value = hora;
		}
	</script>
	

</body>
</html>