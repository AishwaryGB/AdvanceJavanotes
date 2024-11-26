<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="hello"  uri="/mytaglib"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

    String fnm="Kishori";
	String lnm="Khadilkar";
%>
<h1>Customtag demo</h1>
<hello:myhello fname="<%=fnm%>" lname="<%=lnm %>"></hello:myhello>
<hello:calculate num1='<%=Integer.parseInt(request.getParameter("num1")) %>' num2='<%=Integer.parseInt(request.getParameter("num2"))%>'>
</hello:calculate>
</body>
</html>