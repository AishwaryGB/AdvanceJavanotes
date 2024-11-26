<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
     int n1=Integer.parseInt(request.getParameter("num1"));
     int n2=Integer.parseInt(request.getParameter("num2"));
     int addition=n1+n2;
     String msg="Addition : "+addition;
     
  %>
  
  <jsp:forward page="displaydata.jsp">
      <jsp:param value="<%=msg%>" name="msg"/>
  </jsp:forward>
  
</body>
</html>