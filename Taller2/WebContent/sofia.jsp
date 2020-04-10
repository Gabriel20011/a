<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="Filo.css" /><meta charset="UTF-8">
<title>Taller 2</title>
<h1>FILTRO DE DATOS</h1>
</head>
<body id = 'content'>
<form action="<%= request.getContextPath() %>/Controlador"
	method="post">
<div id="Nombre">
<h4>NOMBRE</h4>
	<select id="Nombre" name= "Nombre_usuario">
	<option >-Nombres-</option>
	<c:forEach items="${Nombre_usuario}" var="nombres" >
	<option>${nombres}</option>
		</c:forEach>
	</select>
	</div>
	<div id="Apellido">
	<h4>APELLIDO</h4>
	<select id="Apellido" name= "Apellido_usuario">
		<option >-Apellidos-</option>
		<c:forEach items="${Apellido_usuario}" var="apellidos" >
	<option>${apellidos}</option>
	</c:forEach>
	</select>
	</div>
	<div id="Edad">
	<h4>EDAD</h4>
	<select id="Edad" name= "Edad_usuario">
		<option >-Edades-</option>
		<c:forEach items="${Edad_usuario}" var="edad" >
	<option>${edad}</option>
	</c:forEach>
	</select>
	</div>
	<div id="Genero">
		<h4>GENERO</h4>
	<select id="Genero" name= "Genero_usuario">
		<option >-Generos-</option>
		<c:forEach items="${Genero_usuario}" var="genero"  >
	<option>${genero}</option>
	</c:forEach>
	</select>
	</div>
	<div id="Pais">
		<h4>PAIS</h4>
	<select id="Pais" name= "Pais_usuario">
		<option >-Paises-</option>
		<c:forEach items="${Pais_usuario}" var="pais"  >
	<option>${pais}</option>
	</c:forEach>
	</select>
	</div>
	<div id="Ciudad">
		<h4>CIUDAD</h4>
	<select id="Ciudad" name= "Ciudad_usuario">
		<option >-Ciudades-</option>
		<c:forEach items="${Ciudad_usuario}" var="ciudad" >
	<option>${ciudad}</option>
	</c:forEach>
	</select>
</div>
	<input type="submit" value="buscar" class="button" >
</form>
</body>
</html>