<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="../css/bootstrap.min.css" rel="stylesheet" >
	<link href="../css/bootstrap-theme.min.css" rel="stylesheet">
	<title>Listado de Usuarios</title>
</head>
<body>
<h1>Usuarios solicitados en la url: ${cantidad}</h1>

	<h2>Lista de usuarios solicitados</h2>
	<div class="table-responsive">
		<table class="table">
			<tbody>

			<c:forEach var="item" items="${lista}" begin="0" end="${cantidad-1}" >	<!-- cantidad -1 porque empezamos del incice 0 -->
				<tr>
					<td>${item.email}</td>
					<td>${item.password}</td>
					<td>${item.rol}</td>
				</tr>	
			</c:forEach>
	
			</tbody>
		</table>
	</div>
	
	<h2>Listado completo</h2>
	<div class="table-responsive">
		<table class="table">
			<tbody>

			<c:forEach var="item" items="${lista}" varStatus="loop">
				<tr>
					<td>${loop.count}</td>	<!-- si usaramos  loop.index comensaria de 0-->
					<td>${item.email}</td>
					<td>${item.password}</td>
					<td>${item.rol}</td>
				</tr>	
			</c:forEach>
	
			</tbody>
		</table>
	</div>
	
	
	<a href="http://zetcode.com/articles/jstlforeach/"  target="_blank">Ejemplos JSTL forEach</a>
</body>
</html>