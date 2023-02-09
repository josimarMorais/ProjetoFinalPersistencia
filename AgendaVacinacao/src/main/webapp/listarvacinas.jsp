<jsp:include page="cabecalho.jsp" />
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
	
	<div class="container">
		<div class="row py-3">
			<div class="col">
			
				<div class="container">
						<div class="row">
							<div class="col-3">
							<button class="btn btn-success mb-5" data-bs-toggle="modal" data-bs-target="#createModal">
							+ Adicionar Nova Vacina</button>
							</div>
							<div class="col-9">
							<button class="btn btn-primary mb-5 col-3 " data-bs-toggle="modal" data-bs-target="#searchModal">
							Buscar Vacina</button>						
						</div>
					</div>
				</div>	
				
				<h4 class="my-1 py-2 text-sm-center">Relação de Vacinas Cadastradas</h4>
				
				<% if(listaVacinas.isEmpty()) {%>
					<div class="container">
					<div class="row py-3">
						<div class="col">
							<h5 class="my-1 py-2 text-sm-center">nenhum Resultado encontrado!</h5>
						</div>
					</div>
				</div>
					
				<%} else {%>
				<table class="table" >
					<tr>
						<th>Titulo</th>
						<th>Descricao</th>
						<th>Doses</th>
						<th>Intervalo</th>
						<th></th>
					</tr>
					
					<% for(Vacina v : listaVacinas) { %>
					
					<tr>
						<td><%=v.getTitulo() %></td>
						<td><%=v.getDescricao() %></td>
						<td><%=v.getDoses() %></td>
						<td><%=v.getIntervalo() %></td>
						<td><button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal"
								onclick="onDelete('<%=v.getId()%>','<%=v.getTitulo()%>')" >Deletar</button></td>
					</tr>
					<% }%>
				</table>
		<% } %>		
				<!-- Modal Create-->
				<div class="modal fade" id="createModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Adicionar Nova Vacina</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<form method="post" action="IncluirVacina">

									<div class="mb-3">
										<label for="txtTitulo" class="form-label">Titulo </label> 
										<input type="text" class="form-control" id="txtTitulo" name="txtTitulo" required>
									</div>
									
									<div class="mb-3">
										<label for="TextDescricao" class="form-label">Descrição</label>
										<textarea  class="form-control" name="TextDescricao" rows="3" cols="40" 
										placeholder="Digite uma breve descrição da vacina" required></textarea>
									</div>
									
									<div class="mb-3">
										<label for="txtDoses" class="form-label">Doses </label> 
										<input type="number" class="form-control" id="txtDoses" name="txtDoses" required>
									</div>
									
									<div class="mb-3">
										<label for="SelPeriodicidade" class="form-label">Periodicidade</label> 
										<select class="form-select" name="SelPeriodicidade" id="SelPeriodicidade" required>
											<option value="" > Selecione</option>
											<option value="0"> Dose única</option>
											<option value="1"> Dia</option>
											<option value="2"> Semana</option>
											<option value="3"> Mês</option>
											<option value="4"> Ano</option>
										</select>
									</div>
									
									<div class="mb-3">
										<label for="txtIntervalo" class="form-label">Intervalo</label> 
										<input type="number" class="form-control" id="txtIntervalo" name="txtIntervalo" 
											placeholder="Se for dose única, DIGITE 1" required>
									</div>
									
									<div>
										<button type="submit" class="btn btn-success mt-2">Adicionar</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div><!-- Modal Create Fim -->
				
				
				
				<!-- Modal Delete -->
				<div class="modal fade" id="deleteModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Realmente deseja apagar?</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							</div>
							<div class="modal-body">
	
								<form method="post" action="ExcluirVacina">
	
									<div class="mb-3">
										<input type="text" class="form-control-plaintext" id="txtTitulo" name="txtTitulo">
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
				
							<!-- Modal Search-->
			<div class="modal fade" id="searchModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Buscar Vacina</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
									<form method="get" action="BuscarVacina">
										<div class="mb-3">
										<label for="txtTitulo" class="form-label">Titulo</label>
										<input type="text" class="form-control" id="txtTitulo" name="txtTitulo" required>
									</div>										
									
									<div>
									<button type="submit" class="btn btn-primary mt-2">Buscar</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div><!-- Modal Search Fim -->
						
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function onDelete(id, nome) {			
			var idEl = document.querySelector("div#deleteModal input[name='id']");
			var NomeEl = document.querySelector("div#deleteModal input[name='txtTitulo']");
			idEl.value = id;
			NomeEl.value = nome;
		}
	</script>
	
</body>
</html>