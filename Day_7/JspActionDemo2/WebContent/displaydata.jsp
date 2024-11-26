<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> number 1: <%=request.getParameter("num1") %></h3>
<h3> number 2: <%=request.getParameter("num2") %></h3>
<h3> Message: <%=request.getParameter("msg") %></h3>
</body>
</html>