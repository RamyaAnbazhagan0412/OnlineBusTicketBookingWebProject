package com.ramya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin_login.UserRegistrationDAO;
import com.admin_login.UserRegistrationModel;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String emailId=request.getParameter("email");
		String password=request.getParameter("password");
		String phoneNumber=request.getParameter("phoneNumber");
    
		UserRegistrationModel userObj=new UserRegistrationModel();
		userObj.setUserName(name);
		userObj.setEmailId(emailId);
		userObj.setPassword(password);
		userObj.setPhoneNumber(phoneNumber);
		
		try {
			int a=UserRegistrationDAO.userRegistrationDAO(userObj);
			out.println(a);
		} 
		catch (Exception e) {
			out.println(e.getMessage());
			
		}
		

		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
}
