package com.ramya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin_login.AdminLoginModel;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message=null;
		PrintWriter out=response.getWriter();
		String  emailId=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(emailId + password);
		try {
			int a=AdminLoginModel.adminLogin(emailId, password);
		if(a==1) {
			message="Login Successful ";
			} 
		else if(a==0)
		{
			message="Invalid Login";
			}
		}
		catch (Exception e) 
		{
		//	e.printStackTrace();
			message=e.getMessage();	
		}
		out.println(message);
		out.flush();
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
