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


@WebServlet("/SearchByBusTo")
public class SearchByBusTo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchByBusTo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		String to=request.getParameter("busTo");
	    //String to="padalam";
		Bus busObj = new Bus();
		busObj.setBusTo(to);
		
			try {
				List<Bus> busList=SearchBusDAO.BusListByBusTo(busObj);
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
