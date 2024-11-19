package com.demo.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitparamServlet
 */
@WebServlet("/initservlet")
public class InitparamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void init(ServletConfig config){
    	System.out.println("in init method of initparamservlet");
    } 
    public void destroy(){
    	System.out.println("in destroy method of initparamservlet");
    } 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
