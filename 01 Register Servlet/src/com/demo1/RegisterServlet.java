package com.demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out= response.getWriter();
		out.println("<h2>Welcome to RegisterServlet</h2>");
		
		String name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String email = request.getParameter("user_email");
		String gender = request.getParameter("user_gender");
		String course = request.getParameter("user_course");
		String cond = request.getParameter("condition");
		
		// 	out.println(cond);
		if(cond!=null) 
		{ 
			
			if(cond.equals("checked")) {
				out.println("<h2>Name: "+ name + "</h2>");
				out.println("<h2>password: "+ password + "</h2>");
				out.println("<h2>email: "+ email + "</h2>");
				out.println("<h2>gender: "+ gender + "</h2>");
				out.println("<h2>course: "+ course + "</h2>");
				
				//can add data in DB using JDBC code
				
				//saved the data in DB 
				
				RequestDispatcher rd= request.getRequestDispatcher("SuccessServlet");
				
				//include
				
				rd.include(request, response);
				
	
			}else {
				out.println("<h2>Please accept the terms and conditions</h2>");
			}
		}else {
			out.println("<h2>Please accept the terms and conditions</h2>");
			
			//adding request dispatcher
			
			//get the object of request disp..
			
			RequestDispatcher rd= request.getRequestDispatcher("index.html");
			
			//include
			
			rd.include(request, response);
		}
	}

}
