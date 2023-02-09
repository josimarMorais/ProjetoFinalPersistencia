<%@page import="negocio.Usuario"%>
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


List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("usuarios");

%>

</head>

<body>

	<div class="container">
		<div class="row py-3">
			<div class="col">

				<h4 class="my-5 py-2 text-sm-center">Área de listagem das
					agendas utilizando filtros</h4>

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
							<button type="submit" class="btn btn-info text-white">
								Cancelada</button>
						</form>
					</div>

					<div class="col-3">
						<form method="get" action="BuscarAgenda">
							<input type="hidden" name="btnBuscar" value="DATA" />
							<button type="submit" class="btn btn-info text-white">
								Agendadas hoje</button>
						</form>
					</div>

					<div class="col-3">
						<input type="hidden" name="btnBuscar" value="USUARIO" />
						<button class="btn btn-info text-white" data-bs-toggle="modal"
							data-bs-target="#searchModal">Busca por Usuário</button>
					</div>
				</div>


				<table class="table my-4">
					<tr>					
						<th>Usuário</th>
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
						<td><%=a.getUsuario().getNome()%></td>
						<td><%=a.getData()%></td>
						<td><%=a.getSituacao()%></td>
						<td><%=a.getVacina().getTitulo()%></td>
						<td><%=a.getVacina().getDoses()%></td>
					</tr>
					<%
					}
					%>
				</table>


				<!-- Modal Search-->
				<div class="modal fade" id="searchModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Buscar Agendas por Usuário</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form method="get" action="BuscarAgenda">
								
								<div class="mb-3">
										<select class="form-select" name="selUsuario" required>
											<option value="">Selecione um Usuário</option>
											<%
											for (Usuario u : listaUsuarios) {
											%>
											<option value="<%=u.getId()%>"><%=u.getNome()%></option>
											<%
											}
											%>
										</select>
									</div>
									<div class="mb-3">
										<input type="hidden" name="btnBuscar" value="USUARIO" />
									</div>
									<div>
										<button type="submit" class="btn btn-primary mt-2">Buscar</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- Modal Search Fim -->



			</div>
		</div>
	</div>

</body>
</html>