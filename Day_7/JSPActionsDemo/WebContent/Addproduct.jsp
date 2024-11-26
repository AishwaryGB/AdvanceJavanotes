<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="adddata.jsp">
   Product id: <input type="text" name="pid" id="pid">
   Product name: <input type="text" name="pname" id="pname">
   Product qty: <input type="text" name="qty" id="qty">
   Product price: <input type="text" name="price" id="price">
   <button type="submit" name="add" id="add">Add product</button>
   </form>
</body>
</html>