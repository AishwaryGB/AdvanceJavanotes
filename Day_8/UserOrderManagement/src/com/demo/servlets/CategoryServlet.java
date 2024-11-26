package com.demo.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Category;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductService pservice = new ProductServiceImpl();
		List<Category> clist=pservice.getAllCategory();
		request.setAttribute("clist",clist);
		RequestDispatcher rd= request.getRequestDispatcher("categorypage.jsp");
		rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doPost(request,response);
	}
	
}
