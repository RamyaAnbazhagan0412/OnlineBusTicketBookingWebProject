package com.ramya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin_login.Bus;
import com.admin_login.InsertBusDAO;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("busName");
		String from=request.getParameter("busFrom");
		String to=request.getParameter("busTo");
		String timing=request.getParameter("busTiming");
		String tickets=request.getParameter("busTicketsAvailable");
		 System.out.println("t="+tickets);
		int ticketsAvailable=Integer.parseInt(tickets);
		String price=request.getParameter("busTicketPrice");
		System.out.println("t="+price);
		int ticketPrice=Integer.parseInt(price);
		 
		   
		
		Bus obj=new Bus();
		obj.setBusName(name);
		obj.setBusFrom(from);
		obj.setBusTo(to);
		obj.setBusTiming(timing);
		obj.setBusTicketsAvailable(ticketsAvailable);
		obj.setBusTicketPrice(ticketPrice);
		try {
			int insert=InsertBusDAO.insertBus(obj);
			if (insert==1) {
			out.println(1);
			System.out.println("success");
			}
		} 
		catch (Exception e) {
			System.out.println("unsuccessful");
			
		}
		
		out.flush();
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	//    http://localhost:8080/WebApplicationProject/InsertServlet?busName=+name&busFrom=+From&busTo=+To&busTiming=+Timing&busTicketsAvailable=+TicketsAvailable&busTicketPrice=TicketsPrice;

	

}
