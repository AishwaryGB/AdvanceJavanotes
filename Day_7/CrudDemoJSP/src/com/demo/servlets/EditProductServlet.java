package com.demo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editprod")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		ProductService pservice=new ProductServiceImpl();
		Product p=pservice.getById(pid);
		request.setAttribute("prod",p);
		RequestDispatcher rd=request.getRequestDispatcher("updateform.jsp");
		rd.forward(request, response);
		
	}

}
