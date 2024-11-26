<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.demo.beans.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="MyHeader.html" %>
<table border=2>
<tr>
    <th>Product pid</th>
    <th>Product pname</th>
    <th>Product qty</th>
    <th>Product price</th>
    <th>Product Expiry date</th>
    <th>Product cid</th>
    <th>actions</th>
</tr>
<c:forEach var="p" items="${plist}">
<tr>
   <td>${p.pid}</td>
   <td>${p.pname}</td>
   <td>${p.qty}</td>
   <td>${p.price}</td>
   <td>${p.expdate}</td>
   <td>${p.cid}</td>
   <td>
      <a href="editprod?pid=${p.pid}">edit</a>/
      <a href="deletprod?pid=${p.pid}">delete</a>
      
   </td>
</tr>
</c:forEach>
</table>
<a href="addproduct.jsp">Add new product</a>
<%@include file="MyFooter.html" %>
</body>
</html>