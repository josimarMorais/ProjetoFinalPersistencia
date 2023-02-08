<%@page import="negocio.Vacina"%>
<%@page import="negocio.Usuario"%>
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
List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("usuarios");

@SuppressWarnings("unchecked")
List<Vacina> listaVacinas = (List<Vacina>) request.getAttribute("vacinas");

@SuppressWarnings("unchecked")
List<Agenda> listaAgendas = (List<Agenda>) request.getAttribute("agendas");
%>

</head>
<body>

	<div class="container">
		<div class="row py-3">
			<div class="col">

				<div class="container">
					<div class="row">
						<div class="col-3">
							<button class="btn btn-success mb-5  " data-bs-toggle="modal"
								data-bs-target="#createModal">+ Adicionar Nova Agenda</button>
						</div>
						<div class="col-3">
							<form action="listarbuscaagenda.jsp">
							<button type="submit" class="btn btn-primary"> Realizar Nova Consulta</button>
							</form>
						</div>
					</div>
				</div>

				<h4 class="my-1 py-2 text-sm-center">Relação de Agendas
					Cadastradas</h4>

				<table class="table">
					<tr>
						<th>Pessoa</th>
						<th>Vacina</th>
						<th>Data</th>
						<th>hora</th>
						<th>Situacao</th>
						<th>Observações</th>
						<th></th>
					</tr>

					<%
					for (Agenda a : listaAgendas) {
					%>
					<tr>
						<td><%=a.getUsuario().getNome()%></td>
						<td><%=a.getVacina().getTitulo()%></td>
						<td><%=a.getData()%></td>
						<td><%=a.getHora()%></td>
						<td><%=a.getSituacao()%></td>
						<td><%=a.getObservacoes()%></td>
						<td>
							<div class="row">
								<div class="col-3">
									<form method="get" action="MudarSituacao">

										<input type="hidden" name="txtRealizada" value="REALIZADA" />
										<input type="hidden" name="id" value="<%=a.getId()%>" />
										<button type="submit" class="btn btn-success btn-sm">
											Realizada</button>
									</form>
								</div>
								<div class="col-3">
									<form method="get" action="MudarSituacao">
										<input type="hidden" name="txtRealizada" value="CANCELADA" />
										<input type="hidden" name="id" value="<%=a.getId()%>" />
										<button type="submit" class="btn btn-primary btn-sm">
											Cancelada</button>
									</form>
								</div>

								<div class="col-4 mx-1">
									<button class="btn btn-danger btn-sm" data-bs-toggle="modal"
										data-bs-target="#deleteModal"
										onclick="onDelete('<%=a.getId()%>','<%=a.getData()%>','<%=a.getHora()%>' )">Deletar</button>
								</div>
							</div>
						</td>
					</tr>
					<%
					}
					%>
				</table>

				<!-- Modal Create-->
				<div class="modal fade" id="createModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Adicionar Nova Agenda</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<form method="post" action="IncluirAgenda">

									<div class="mb-3">
										<!-- 											<label for="dateData" class="form-label">Data </label>  -->
										<select class="form-select" name="selUsuario" required>
											<option value="">Selecione uma pessoa</option>
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
										<label for="dateData" class="form-label">Data </label> <input
											type="date" class="form-control" id="dateData"
											name="dateData" required>
									</div>

									<div class="mb-3">
										<label for="timeHora" class="form-label">Hora </label> <input
											type="time" class="form-control" id="timeHora"
											name="timeHora" required>
									</div>

									<div class="mb-3">
										<label for="TextObservacoes" class="form-label">Observações</label>
										<textarea id="TextObservacoes" name="TextObservacoes"
											class="form-control" rows="2" cols="30"
											placeholder="Existe alguma observação?"></textarea>
									</div>

									<div class="mb-3">
										<select class="form-select" name="selVacina" required>
											<option value="">Selecione uma Vacina</option>
											<%
											for (Vacina v : listaVacinas) {
											%>
											<option value="<%=v.getId()%>"><%=v.getTitulo()%></option>
											<%
											}
											%>
										</select>
									</div>


									<div>
										<button type="submit" class="btn btn-success mt-2">Adicionar</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- Modal Create Fim -->


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
				</div>
			</div>
			<!-- Modal Delete Fim -->

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