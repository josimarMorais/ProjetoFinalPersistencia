<jsp:include page="cabecalho.jsp" />
<%@page import="negocio.Alergia"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<title>Alergias Cadastradas</title>
	
	<%
		@SuppressWarnings("unchecked")
		List<Alergia> listarAlergias = (List<Alergia>) request.getAttribute("alergias");
	%>
	
</head>
<body>
	<div class="container">
		<div class="row py-3">
			<div class="col">
					<div class="container">
						<div class="row">
							<div class="col-3">
							<button class="btn btn-success mb-5  " data-bs-toggle="modal" data-bs-target="#createModal">
							+ Adicionar Nova Alergia</button>
							</div>
							<div class="col-9">
							<button class="btn btn-primary mb-5 col-3 " data-bs-toggle="modal" data-bs-target="#searchModal">
							Buscar Alergia</button>						
						</div>
					</div>
				</div>	
					<h4 class="my-1 py-2 text-sm-center">Relação de Alergias Cadastradas</h4>
				
				<table class="table">
					<tr>
						<th>Nome</th>
						<th></th>

					</tr>
					
					<% for (Alergia alergia : listarAlergias) { %>
					
					<tr class="text-right">
						<td class="col-11"><%=alergia.getNome()%></td>
						<td class="col-1"><button class="btn btn-danger btn-sm mx-3" data-bs-toggle="modal" data-bs-target="#deleteModal"
								onclick="onDelete('<%=alergia.getId()%>','<%=alergia.getNome()%>')" >Deletar</button></td>
					</tr>
					<% } %>
				</table>
				
				<!-- Modal Create-->
				<div class="modal fade" id="createModal">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">Adicionar Nova Alergia</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
	
									<form method="post" action="IncluirAlergia">
	
										<div class="mb-3">
											<label for="txtNome" class="form-label">Nome </label> <input
												type="text" class="form-control" id="txtNome" name="txtNome" autofocus required>
										</div>
										<div>
										<button type="submit" class="btn btn-success mt-2">Adicionar</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div><!-- Modal Create Fim -->
				</div>
				
				<!-- Modal Delete -->
			<div class="modal fade" id="deleteModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">Realmente deseja apagar?</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<form method="post" action="ExcluirAlergia">

								<div class="mb-3">
									<input type="text" class="form-control-plaintext" id="txtNome" name="txtNome">
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
								<h5 class="modal-title">Buscar Alergia</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
									<form method="get" action="BuscarAlergia">
										<div class="mb-3">
										<label for="txtNome" class="form-label">Nome</label>
										<input type="text" class="form-control" id="txtNome" name="txtNome" required>
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
	
	<script type="text/javascript">
		function onDelete(id, nome) {			
			var idEl = document.querySelector("div#deleteModal input[name='id']");
			var NomeEl = document.querySelector("div#deleteModal input[name='txtNome']");
			idEl.value = id;
			NomeEl.value = nome;
		}
	</script>
		
</body>
</html>