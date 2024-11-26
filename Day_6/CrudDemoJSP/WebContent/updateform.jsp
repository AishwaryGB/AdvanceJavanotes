<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.demo.beans.Product,java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   Product p=(Product)request.getAttribute("prod");
%>
<form action="updateprod">
   Product Id : <input type="text" name="pid" id="pid" value="<%=p.getPid()%>" readonly><br>
   Product name: <input type="text" name="pname"  id="pname" value="<%=p.getPname()%>"><br>
   Product Qty : <input type="text" name="qty" id="qty" value="<%=p.getQty()%>"><br>
   Product Price : <input type="text" name="price" id="price" value="<%=p.getPrice()%>"><br>
   Product Exp date : <input type="text" name="expdate" id="expdate" value="<%=p.getExpdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))%>"><br>
   Product cid : <input type="text" name="cid" id="cid" value="<%=p.getCid()%>"><br>
   <button type="submit" name="btn" id="btn" value="btn">Update product</button>
</form>
</body>
</html>