package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 HttpSession sess=request.getSession();
		 String role=(String)sess.getAttribute("role");
		 if(role!=null && role.equals("admin")) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			ProductService pservice=new ProductServiceImpl();
			boolean status=pservice.deletById(pid);
			RequestDispatcher rd=request.getRequestDispatcher("showprod");
			rd.forward(request, response);
		}else {
			   out.println("Pls login to the application!!");
			   RequestDispatcher rd=request.getRequestDispatcher("login.html");
			   rd.include(request, response);
		   }
	}

}
