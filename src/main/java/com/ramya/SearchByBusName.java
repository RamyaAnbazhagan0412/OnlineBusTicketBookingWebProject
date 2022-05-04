package com.ramya;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin_login.Bus;
import com.admin_login.SearchBusDAO;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchByBusName
 */
@WebServlet("/SearchByBusName")
public class SearchByBusName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByBusName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		String name=request.getParameter("busName");
		//String name="nithya";
		Bus busObj = new Bus();
		busObj.setBusName(name);
		
			try {
				List<Bus> busList=SearchBusDAO.BusListByName(busObj);
				Gson gson= new Gson();
				String json=gson.toJson(busList);
				out.println(json);
				System.out.println(json);
				out.flush();
				
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
