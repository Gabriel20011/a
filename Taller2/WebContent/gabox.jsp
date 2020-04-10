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
		for(int i = 0 ; i < usus.size(); i++){
			out.println("<script>"+ "cargarUsuarios(\"" + usus.get(i)+"\")" + "</script>");
		}
		%>
		
		<input type="button" id="first" onclick="firstPage()" value="first" />
		<input type="button" id="next" onclick="nextPage()" value="next" />
		<input type="button" id="previous" onclick="previousPage()" value="previous" />
		<input type="button" id="last" onclick="lastPage()" value="last">	
	</body>
</html>