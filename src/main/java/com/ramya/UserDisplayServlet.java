package com.ramya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin_login.DisplayBusDAO;
import com.admin_login.Bus;
import com.admin_login.UserDisplayDAO;
import com.admin_login.UserRegistrationModel;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserDisplayServlet
 */
@WebServlet("/UserDisplayServlet")
public class UserDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
UserDisplayDAO userDisplay=new UserDisplayDAO();
		try {
			List<UserRegistrationModel> displayObj=userDisplay.UserDisplayDAO(userDisplay);
			Gson gson= new Gson();
			String json=gson.toJson(displayObj);
			out.println(json);
			System.out.println(json);
			out.flush();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		out.flush();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
