<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--calls default constructor  --%>
<jsp:useBean id="p" class="com.demo.beans.Product"></jsp:useBean>
<%-- ProductService pservice=new ProductServiceImpl() 
<jsp:useBean id="pservice" class="com.demo.service.ProductServiceImpl" type="com.demo.service.ProductService></jsp:useBean>
--%>
<%--calls setter  --%>
<%-- <jsp:setProperty property="pid" name="p" value='<%=Integer.parseInt(request.getParameter("pid")) %>'/>
<jsp:setProperty property="pname" name="p" value='<%=request.getParameter("pname") %>'/>
<jsp:setProperty property="qty" name="p" value='<%=Integer.parseInt(request.getParameter("qty")) %>'/>
<jsp:setProperty property="price" name="p" value='<%=Double.parseDouble(request.getParameter("price")) %>'/>
 --%>
 <jsp:setProperty property="*" name="p" />
 
<%--to display product , calls getter methods --%>
Pid : <jsp:getProperty property="pid" name="p"/>
Pname : <jsp:getProperty property="pname" name="p"/>
qty : <jsp:getProperty property="qty" name="p"/>
Price : <jsp:getProperty property="price" name="p"/>
</body>
</html>