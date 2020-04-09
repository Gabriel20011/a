<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>
<table>
<c:forEach var="usuarios" items="${usuarios}">
<tr>
<th>${usuarios}</th>
</tr>
</c:forEach>
</table>
</body>
</html>