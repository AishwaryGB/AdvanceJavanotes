<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> select category</h1>
<form action="getProducts" >
<select name="cid" id="cid"> 
<c:forEach var="c" items="${clist}" >
<option value="${c.cid}"> ${c.cname}</option>

</c:forEach>

</select>
<button type="submit" name="btn" id="btn">Show Products</button>
</form>
<a href="showcart.jsp">Show cart</a>
</body>
</html>