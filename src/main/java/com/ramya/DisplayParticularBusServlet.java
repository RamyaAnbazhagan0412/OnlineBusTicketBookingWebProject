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

import com.admin_login.DisplayBusDetailsDAO;
import com.admin_login.Bus;
import com.google.gson.Gson;

/**
 * Servlet implementation class DisplayParticularBusServlet
 */
@WebServlet("/DisplayParticularBusServlet")
public class DisplayParticularBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayParticularBusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out = response.getWriter();
	String busId=request.getParameter("busId");
	int id=Integer.parseInt(busId);
Bus displayBus=new Bus();
displayBus.setBusId(id);
				try {
					Bus displayObj=DisplayBusDetailsDAO.displayBusDetailsDAO(displayBus);
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
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
