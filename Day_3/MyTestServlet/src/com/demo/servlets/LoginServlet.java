package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String passwd=request.getParameter("passwd");
		if(uname.equals("admin") && passwd.equals("admin")) {
			out.println("<h1>Login successful!!!</h1>");
			
				
		}else {
			out.println("<h1>Login unsuccessful!!!</h1>");
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		doGet(request,response);
	}
	
}
