<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxDatatypes.Array"%>
<%@page import="co.edu.unbosque.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Resultado</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link type="text/css" rel="stylesheet" href="Filo.css">
	</head>
	<body>
		<h1>${respuesta}</h1>
		<table>
			<tbody>
			<% for(Usuario i : (ArrayList<Usuario>) request.getAttribute("Filtrados")){
				out.println("<tr>");
				out.println("<td>" + i.getNombre() + "</td>");
				out.println("<td>" + i.getApellido() + "</td>");
				out.println("<td>" + i.getEdad() + "</td>");
				out.println("<td>" + i.getGenero() + "</td>");
				out.println("<td>" + i.getPais() + "</td>");
				out.println("<td>" + i.getCiudad() + "</td>");
				out.println("</tr>");
			}
				%>
			</tbody>
			
		</table>
		<ul class="pagination" style="margin-bottom: 20px;">
			<% 
			int lim = (int) request.getAttribute("nPaginas");
			for (int i = 1 ; i <= lim ; i++){
				out.println("<li><a href=\"#\">"+i+"</a></li>");
			}
			%>
          </ul>
	</body>
</html>