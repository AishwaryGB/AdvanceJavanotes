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
<h1> Select Products</h1>
<table>
<form action="addToCart"> 
<tr> <th> </th>
<th>Product Name </th>
<th>Price </th>
<th> Quantity</th>
</tr>
<c:forEach var="p" items="${plist}">
<tr><td> <input type="checkbox" name="prod" id="${p.pid }" value="${p.pid}">
</td> 
<td> ${p.pname} </td> 
<td> ${p.price}</td> 
<td><input type="text" name="p${p.pid}" id="${p.pid }" ></td> </tr>
</c:forEach>
<tr>
<td colspan="2"><button type="submit" name="btn" id="add" value="add">Add to Cart</button> </td>
<td colspan="2"> <button type="submit" name="btn" id="show" value="show">Show Cart</button></td>
</tr>
</form>
</table>
</body>
</html>