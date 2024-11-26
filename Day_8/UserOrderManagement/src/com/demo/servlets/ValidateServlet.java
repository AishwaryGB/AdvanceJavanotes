package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
   		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		LoginService lservice= new LoginServiceImpl();
		MyUser user=lservice.validateUser(uname,pass);
		 if(user!=null && user.getRole().equals("user")) {
			 HttpSession sesh = request.getSession();
			 sesh.setAttribute("user",user );
			 RequestDispatcher rd= request.getRequestDispatcher("categories");
			 rd.forward(request, response);
		 }else {
			 out.println("InValid Credentials");
			 RequestDispatcher rd= request.getRequestDispatcher("Loginpage.jsp");
			 rd.include(request, response);
		 }
		
	}

}
