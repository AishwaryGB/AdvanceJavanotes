package com.demo.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int pid=Integer.parseInt(request.getParameter("pid"));
    	String pname=request.getParameter("pname");
    	int qty=Integer.parseInt(request.getParameter("qty"));
    	double price=Double.parseDouble(request.getParameter("price"));
    	String dt=request.getParameter("expdate");
    	LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	int cid=Integer.parseInt(request.getParameter("cid"));
    	Product p=new Product(pid,pname,qty,price,ldt,cid);
    	ProductService pservice=new ProductServiceImpl();
    	pservice.insertProduct(p);
    	RequestDispatcher rd=request.getRequestDispatcher("showprod");
    	rd.forward(request, response);;
    	
    }

}
