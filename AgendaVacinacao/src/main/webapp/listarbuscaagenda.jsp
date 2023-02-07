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
	
	
	


</body>
</html>