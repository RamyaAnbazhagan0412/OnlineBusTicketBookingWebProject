package com.ramya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin_login.AdminLoginModel;
import com.admin_login.UserRegistrationDAO;
import com.admin_login.UserRegistrationModel;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message=null;
		PrintWriter out=response.getWriter();
		String  emailId=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(emailId + password);
		try {
			int a=UserRegistrationDAO.userLogin(emailId,password);
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
