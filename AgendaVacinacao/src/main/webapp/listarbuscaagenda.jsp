<%@page import="negocio.Alergia"%>
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
List<Alergia> listarAlergias = (List<Alergia>) request.getAttribute("alergias");
%>

</head>

<body>

	<div class="container">
		<div class="row py-3">
			<div class="col">
				
				<h4 class="my-5 py-2 text-sm-center">Área de listagem das agendas utilizando filtros</h4>
				
				<div class="row justify-content-around">
					<div class="col-3">
						<form method="get" action="MudarSituacao">

							<input type="hidden" name="txtRealizada" value="REALIZADA" />
							<input type="hidden" name="id" value="" />
							<button type="submit" class="btn btn-info">Realizada</button>
						</form>
					</div>
					<div class="col-3">
						<form method="get" action="MudarSituacao">
							<input type="hidden" name="txtRealizada" value="CANCELADA" /> 
							<input type="hidden" name="id" value="" />
							<button type="submit" class="btn btn-info">
								Cancelada</button>
						</form>
					</div>

					<div class="col-3">
						<button class="btn btn-info" data-bs-toggle="modal"
							data-bs-target="#deleteModal" >Data atual</button>
					</div>
					
					<div class="col-3">
							<button class="btn btn-info" data-bs-toggle="modal" data-bs-target="#searchModal">
							Busca por Usuário</button>						
					</div>
					
				</div>

			</div>
		</div>
	</div>


</body>
</html>