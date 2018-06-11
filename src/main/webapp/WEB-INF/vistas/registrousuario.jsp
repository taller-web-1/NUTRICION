<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro Usuario</title>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class = "container">
		<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<h1>Registro Usuario</h1>
			<form:form action="mostrar-usuario-cargado-en-el-form" method="POST" modelAttribute="usuario">
				<label for="email">Email:</label>
				<form:input path="email" id="email" type="email" class="form-control"/><br>
				<label for="password">Password:</label>
				<form:input path="password" type="password" id="password" class="form-control"/> <br> 
				<label for="rol">Rol:</label>
				<form:input path="rol" type="text" id="rol" class="form-control"/> <br>   		  
					
				<button class="btn btn-lg btn-primary btn-block" Type="Submit">Registrar</button>
			</form:form>
		</div>
	</div>
</body>
</html>