<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<title>Mostrar Usuario</title>
</head>
<body>
	<h1>Usuario Creado</h1>
	<h2>${usuario.email}</h2>
	<h2>${usuario.password}</h2>
	<h2>${usuario.rol}</h2>
</body>
</html>