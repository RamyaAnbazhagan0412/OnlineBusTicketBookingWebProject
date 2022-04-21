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
import com.admin_login.UserValidation;

@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=null;
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String emailId=request.getParameter("email");
		String password=request.getParameter("password");
		String phoneNumber=request.getParameter("phoneNumber");
        out.println(emailId);
		UserRegistrationModel userObj=new UserRegistrationModel();
		userObj.setUserName(name);
		userObj.setEmailId(emailId);
		userObj.setPassword(password);
		userObj.setPhoneNumber(phoneNumber);
		int a=0;
		try {
			UserRegistrationDAO.userRegistrationDAO(userObj);;
			a=1;
			if(a==1)
			{
				message="success";
			}
			else if(a==0)
			{
				message="Register Again";
				
			}
				} catch (Exception e) {
			message=e.getMessage();
		}
		
		out.println(message);
		
		
		
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
