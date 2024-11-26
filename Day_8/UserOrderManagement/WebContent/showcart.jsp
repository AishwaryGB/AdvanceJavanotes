<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.time.LocalDate,java.util.List,com.demo.beans.CartItem"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
User Name : ${user.uname}
Date: <%=LocalDate.now() %>
<table border='2'>
<tr>
  <th>Product pid</th>
  <th> Product name</th>
  <th>Order Qty</th>
  <th>Product Price</th>
  <th>Amount</th>
</tr>
<%double amt=0; 
List<CartItem> cart=(List<CartItem>)session.getAttribute("cart");
for(CartItem ci:cart){
%>

<tr>
<td><%=ci.getPid()%></td>
<td><%=ci.getPname()%></td>
<td><%=ci.getOrdQty() %></td>
<td><%=ci.getPrice() %></td>
<td><%=ci.getPrice()*ci.getOrdQty() %></td>
<%-- <td><%=!ci.getComment().equals("ok")? ci.getComment():""%></td> --%>
<tr>
<%amt+=ci.getPrice()*ci.getOrdQty();
} %>

<tr>
<th colspan="4" align="right">Total bill amount</th>
<td><%=amt%></td>
</tr>

</table>
<a href="categories">add more products</a>
<form action="payment.jsp">
   <button type="submit" name="btn" id="btn">Payment</button>
</form>
</body>
</html>