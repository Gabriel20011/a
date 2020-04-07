<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="Filo.css" /><meta charset="UTF-8">
<title>Taller 2</title>
</head>
<body>
<div id="Nombre">
<h4>Nombre</h4>
	<select id="Nombre">
	<option>-todos</option>
	<c:forEach items="${Nombre_usuario}" var="nombres">
	<option>${nombres}</option>
		</c:forEach>
	</select>
	</div>
	<div id="Apellido">
	<h4>Apellido</h4>
	<select id="Apellido">
		<option>-todos</option>
		<c:forEach items="${Apellido_usuario}" var="apellidos">
	<option>${apellidos}</option>
	</c:forEach>
	</select>
	</div>
	<div id="Edad">
	<h4>Edad</h4>
	<select id="Edad">
		<option>-todos</option>
		<c:forEach items="${Edad_usuario}" var="edad">
	<option>${edad}</option>
	</c:forEach>
	</select>
	</div>
	<div id="Genero">
		<h4>Genero</h4>
	<select id="Genero">
		<option>-todos</option>
		<c:forEach items="${Genero_usuario}" var="genero">
	<option>${genero}</option>
	</c:forEach>
	</select>
	</div>
	<div id="Pais">
		<h4>Pais</h4>
	<select id="Pais">
		<option>-todos</option>
		<c:forEach items="${Pais_usuario}" var="pais">
	<option>${pais}</option>
	</c:forEach>
	</select>
	</div>
	<div id="Ciudad">
		<h4>Ciudad</h4>
	<select id="Ciudad">
		<option>-todos</option>
		<c:forEach items="${Ciudad_usuario}" var="ciudad">
	<option>${ciudad}</option>
	</c:forEach>
	</select>
</div>
<form method="post">
	<input type="button" value="buscar" >
	</form>
</body>
</html>