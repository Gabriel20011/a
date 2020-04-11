<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxDatatypes.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Resultado</title>
		<script type="text/javascript" src="Juanito.js"></script>
        <link type="text/css" rel="stylesheet" href="Filo.css">
	</head>
	<body>
		<h1>${respuesta}</h1>
		<% 
		ArrayList<String> usus = (ArrayList<String>) request.getAttribute("Filtrados");
		System.out.println(usus.size());
		for(int i = 0 ; i < usus.size(); i++){
			out.println("<script>"+ "loadList('" + usus.get(i) +"')" + "</script>");
		}
		
		%>
		<div id= "list" style="margin-top: 35px">
		<script type="text/javascript">cargarListaP()</script>
		<h4 id = "nPagina" ><script type="text/javascript">cargarNPagina()</script></h4>
		<button class="button" id="first" onclick="firstPage()" >Primero</button>
		<button class="button" id="previous" onclick="previousPage()" >Anterior</button>
		<button class="button" id="next" onclick="nextPage()"  >Siguiente</button>
		<button class="button" id="last" onclick="lastPage()" >Último</button>
		</div>
	</body>
</html>