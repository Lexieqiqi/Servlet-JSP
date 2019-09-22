package com.example.web;

import com.example.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class BeerSelect extends HttpServlet{
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{

// The servlet outputs the response(which prints the advice)
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		out.println("Beer Selection Advice<br>");
//		String c = request.getParameter("color");
		out.println("Beer Selection Advice<br> ");
		
// The expert class returns an answer, which the servlet adds to the request object
// The servlet dispatches to the JSP
// The JSP gets the answer from the request object
// The JSP generates a page for the Container
// The Container returns the the page to the happy user
//		String c = request.getParameter("color");
//		BeerExpert be = new BeerExpert();
//		List result = be.getBrands(c);
//		
//		// Add an attribute to the request object from the JSP to use. Notice the JSP is looking for styles.
//		request.setAttribute("styles",result);
//		
//
//		
//		//Version 2
////		Iterator it = result.iterator();
////		while(it.hasNext()){
////			out.print("<br>try: "+it.next());
////		}
//		
//		//Version 3
//		// Instantiate a request dispatcher for the JSP
//		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
//		// Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response
//		view.forward(request,response);
//		
//		
//		String bodyParam = request.getParameter("body");
		
		String one = request.getParameterValues("sizes")[0];
		String[] sizes = request.getParameterValues("sizes");
		for(int x=0; x<sizes.length;x++) {
			out.println("<br>sizes: "+sizes[x]);
		}
	}
}
