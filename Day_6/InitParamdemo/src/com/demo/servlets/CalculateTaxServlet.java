package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateTaxServlet
 */
//@WebServlet("/calctax")
@WebServlet(
        name = "calc",
        description = "tax calculation",
        urlPatterns = {"/calctax"},
        initParams={
            @WebInitParam(name="num1", value="500000"),
            @WebInitParam(name="num2", value="1000000")
        }
    )
public class CalculateTaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    double slab1,slab2;
    
	/*public void init(ServletConfig config) throws ServletException {
		super.init(config);
		slab1=Double.parseDouble(config.getInitParameter("num1"));
		slab2=Double.parseDouble(config.getInitParameter("num2"));
	}*/
    
    public void init() {
    	System.out.println("in init method");
    	ServletConfig config=this.getServletConfig();
    	ServletContext context=this.getServletContext();
    	slab1=Double.parseDouble(config.getInitParameter("num1"));
		slab2=Double.parseDouble(config.getInitParameter("num2"));
		System.out.println(slab1+"---->"+slab2);
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in clactax destroy method");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		double inc=Double.parseDouble(request.getParameter("inc"));
		double tax=0;
		if(inc<=slab1) {
			tax=0;
		}else {
			double amt=inc-slab1;
			if(amt<=slab2) {
				tax=0.10*amt;
			}else {
				tax=slab2*0.10;
			    tax=tax+0.20*(amt-slab2);	
			}
		}
		out.println("<h1>Tax: "+tax+"</h1>");
	}

}
