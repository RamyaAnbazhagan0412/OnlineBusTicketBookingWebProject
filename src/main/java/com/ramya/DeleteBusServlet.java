package com.ramya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin_login.Bus;
import com.admin_login.DeleteBusDAO;

/**
 * Servlet implementation class DeleteBusServlet
 */
@WebServlet("/DeleteBusServlet")
public class DeleteBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 	@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	// 1.get bus id using get parameter
		
	String id=request.getParameter("busId")	;
	int busId=Integer.parseInt(id);
	
	//2.set the bus id to bus model class using setter method
	Bus busObj=new Bus();
	busObj.setBusId(busId);
	//3.pass the bus object to deleteDAO class

	try {
		int number=DeleteBusDAO.busDAODelete(busObj);
		out.println(number);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	out.flush();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
            