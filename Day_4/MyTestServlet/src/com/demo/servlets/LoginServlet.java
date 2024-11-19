package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//send credentials for validation
		String uname=request.getParameter("uname");
		String passwd=request.getParameter("passwd");
		LoginService ls=new LoginServiceImpl();
		MyUser user=ls.validateUser(uname,passwd);
		if(user!=null && user.getRole().equals("admin")) {
			//out.println("<h1>Login successful!!!</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("showprod");
			rd.forward(request, response);
				
		}else {
			out.println("<h1>Wrong credentialsl!!!</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			out.println("text below form");
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		doGet(request,response);
	}
	
}
