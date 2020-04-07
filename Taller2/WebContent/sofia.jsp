<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="Filo.css" /><meta charset="ISO-8859-1">
<title>Taller 2</title>
</head>
<body>
<div class="cuerpo">
<div id="Nombre">
<h4>Nombre</h4>
	<select id="Nombre">
	<c:forEach items="${lista_usuario}" var="nombres">
	<option>${nombres}</option>
	</c:forEach>
	</select>
	</div>
	<div id="Apellido">
	<h4>Apellido</h4>
	<select id="Apellido">
	<option>Todos</option>
	<option>Nombre</option>
	<option>Nombre</option>
	<option>Nombre</option>
	</select>
	</div>
	<div id="Edad">
	<h4>Edad</h4>
	<select id="Edad">
	<option>Todos</option>
	<option>Nombre</option>
	<option>Nombre</option>
	<option>Nombre</option>
	</select>
	</div>
	<div id="Genero">
		<h4>Genero</h4>
	<select id="Genero">
	<option>Todos</option>
	<option>Nombre</option>
	<option>Nombre</option>
	<option>Nombre</option>
	</select>
	</div>
	<div id="Pais">
		<h4>Pais</h4>
	<select id="Pais">
	<option>Todos</option>
	<option>Nombre</option>
	<option>Nombre</option>
	<option>Nombre</option>
	</select>
	</div>
	<div id="Ciudad">
		<h4>Ciudad</h4>
	<select id="Ciudad">
	<option>Todos</option>
	<option>Nombre</option>
	<option>Nombre</option>
	<option>Nombre</option>
	</select>
</div>
	<input type="button" value="buscar">
	</div>
</body>
</html>