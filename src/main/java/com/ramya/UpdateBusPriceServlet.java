package com.ramya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin_login.Bus;
import com.admin_login.UpdateBusDetailsDAO;

/**
 * Servlet implementation class UpdateBusPriceServlet
 */
@WebServlet("/UpdateBusPriceServlet")
public class UpdateBusPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBusPriceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String id=request.getParameter("busId");
		int busid=Integer.parseInt(id);
		System.out.println("ramya"+busid);
		String busName=request.getParameter("busName");
		String busFrom=request.getParameter("busFrom");
		String busTo=request.getParameter("busTo");
		String busTiming=request.getParameter("busTiming");
		String TicketAvailable=request.getParameter("busTicketsAvailable");
		int busTicketAvailable=Integer.parseInt(TicketAvailable);
		String busPrice=request.getParameter("busTicketPrice");
		int price=Integer.parseInt(busPrice);
		
		Bus bus=new Bus();
		bus.setBusId(busid);
		bus.setBusName(busName);
		bus.setBusFrom(busFrom);
		bus.setBusTo(busTo);
		bus.setBusTiming(busTiming);
		bus.setBusTicketsAvailable(busTicketAvailable);
		bus.setBusTicketPrice(price);
	
		bus.setBusTicketPrice(price);
		
try {
	int updated=UpdateBusDetailsDAO.updateBusPrice(bus);
	System.out.println(updated);
	out.println(1);
} catch (Exception e) {
	// TODO Auto-generated catch block
	out.println(e);
	out.println("unsuccessful");
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
