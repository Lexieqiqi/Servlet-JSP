package com.example.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeReturn extends HttpServlet{
	public  void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException
	{
		// We want the browser to recognize that this is a JAR
		response.setContentType("application/jar");
		
		ServletContext ctx = getServletContext();
		// give me an input stream for the resource named bookCode,jar
		InputStream is = ctx.getResourceAsStream("/bookCode.jar");
				
		int read = 0;
		byte[] bytes = new byte[1024];
		
		// Here's the key part,but its just plain old I/O.
		// Just read the JAR bytes, then write the bytes to the output stream that we get from the response object.
		OutputStream os = response.getOutputStream();
		while ((read = is.read(bytes)) != 1) {
			os.write(bytes,0,read);
		}
		os.flush();
		os.close();
	}
}
