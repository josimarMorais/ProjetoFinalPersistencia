<%@page import="negocio.Alergia"%>
<jsp:include page="cabecalho.jsp" />
<%@page import="negocio.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usu�rios Cadastrados</title>
<%
@SuppressWarnings("unchecked")
List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("usuarios");

@SuppressWarnings("unchecked")
List<Alergia> listaAlergias = (List<Alergia>) request.getAttribute("alergias");

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
							+ Adicionar Novo usu�rio</button>
							</div>
							<div class="col-9">
							<button class="btn btn-primary mb-5 col-3 " data-bs-toggle="modal" data-bs-target="#searchModal">
							Buscar Usu�rio</button>						
						</div>
					</div>
				</div>
		
				<h4 class="my-1 py-2 text-sm-center">Rela��o de usu�rios
					cadastrados</h4>
				<table class="table">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Data Nascimento</th>
							<th>Sexo</th>
							<th>Logradouro</th>
							<th>Numero</th>
							<th>Setor</th>
							<th>Cidade</th>
							<th>Estado</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Usuario u : listaUsuarios) {
						%>
						<tr>
							<td><%=u.getNome()%></td>
							<td><%=u.getDataNascimento()%></td>
							<td><%=u.getSexo()%></td>
							<td><%=u.getLougradouro()%></td>
							<td><%=u.getNumero()%></td>
							<td><%=u.getSetor()%></td>
							<td><%=u.getCidade()%></td>
							<td><%=u.getUf()%></td>
							<td><button class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal"
								onclick="onDelete('<%=u.getId()%>', '<%=u.getNome()%>')" >Deletar</button></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>

				<!-- Modal Create-->
				<div class="modal fade" id="createModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Adicionar Novo Usu�rio</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<form method="post" action="IncluirUsuario">

									<div class="mb-3">
										<label for="txtNome" class="form-label">Nome </label> <input
											type="text" class="form-control" id="txtNome" name="txtNome" required>
									</div>

									<div class="mb-3">
										<label for="dateDataNascimento" class="form-label">Data
											de Nascimento </label> <input type="date" class="form-control"
											id="dateDataNascimento" name="dateDataNascimento" required>
									</div>
									
									
									<div class="form-check">
										<input class="form-check-input" type="radio" name="sexo" id="F" value="F" required>
										<label class="form-check-label" for="F">Feminino</label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="sexo" id="M" value="M"> 
										<label class="form-check-label" for="M">Masculino</label>
									</div>


									<div class="mb-3">
										<label for="txtLogradouro" class="form-label">Logradouro
										</label> <input type="text" class="form-control" id="txtLogradouro"
											name="txtLogradouro" required>
									</div>

									<div class="mb-3">
										<label for="txtNumero" class="form-label">N�mero</label> <input
											type="number" class="form-control" id="txtNumero"
											name="txtNumero" required>
									</div>

									<div class="mb-3">
										<label for="txtSetor" class="form-label">Setor</label> <input
											type="text" class="form-control" id="txtSetor"
											name="txtSetor" required>
									</div>

									<div class="mb-3">
										<label for="txtCidade" class="form-label">Cidade</label> <input
											type="text" class="form-control" id="txtCidade"
											name="txtCidade" required>
									</div>

									<select class="form-select" name="selEstado" required>
										<option value=""  >Estado</option>
										<option value="AC">Acre</option>
										<option value="AL">Alagoas</option>
										<option value="AP">Amap�</option>
										<option value="AM">Amazonas</option>
										<option value="BA">Bahia</option>
										<option value="CE">Cear�</option>
										<option value="DF">Distrito Federal</option>
										<option value="ES">Esp�rito Santo</option>
										<option value="GO">Goi�s</option>
										<option value="MA">Maranh�o</option>
										<option value="MT">Mato Grosso</option>
										<option value="MS">Mato Grosso do Sul</option>
										<option value="MG">Minas Gerais</option>
										<option value="PA">Par�</option>
										<option value="PB">Para�ba</option>
										<option value="PR">Paran�</option>
										<option value="PE">Pernambuco</option>
										<option value="PI">Piau�</option>
										<option value="RJ">Rio de Janeiro</option>
										<option value="RN">Rio Grande do Norte</option>
										<option value="RS">Rio Grande do Sul</option>
										<option value="RO">Rond�nia</option>
										<option value="RR">Roraima</option>
										<option value="SC">Santa Catarina</option>
										<option value="SP">S�o Paulo</option>
										<option value="SE">Sergipe</option>
										<option value="TO">Tocantins</option>
										<option value="EX">99-Estrangeiro</option>
									</select>
									
									<div>
									<label class="form-label mt-3">Alergias</label>
									</div>
									<%
									for (Alergia a : listaAlergias) {
									%> 										
										<div class="form-check form-check-inline">
											<input class="form-check-input" type="checkbox" value="<%=a.getId()%>" name="checkAlergia">
											<label class="form-check-label"><%=a.getNome()%></label>
										</div>
									<%
									}
									%>
									<div>
									<button type="submit" class="btn btn-success mt-2">Adicionar</button>
									</div>
								</form>
							</div>
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
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<form method="post" action="ExcluirUsuario">

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
								<h5 class="modal-title">Buscar Usu�rio</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
									<form method="get" action="BuscarUsuario">
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