package com.admin_login;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UpdateBusDetailsDAO {
	// This method is used to update the price of the bus ticket
		public static int updateBusPrice(Bus bus) throws Exception {
			// 1.get connection
			
		Connection connection=null;
		PreparedStatement statement=null;
		connection=ConnectionUtil.getConnection();
		int rows=0;
			//2.query passing
		
		String query="UPDATE bus_ticket_booking_app_display SET bus_name=?,bus_from=? ,bus_to=?, bus_timing=?, bus_tickets=?,bus_ticket_price=? where bus_id=?";
	    statement=connection.prepareStatement(query);
	    statement.setString(1, bus.getBusName());
	    statement.setString(2,bus.getBusFrom());
	    statement.setString(3,bus.getBusTo());
	    statement.setString(4,bus.getBusTiming());
	    statement.setInt(5,bus.getBusTicketsAvailable());
	    statement.setInt(6,bus.getBusTicketPrice());
	    statement.setInt(7,bus.getBusId());
		rows=statement.executeUpdate();
			
		if (rows==1) {
			System.out.println("updation successful");
		}
		else {
			System.out.println("Update Unsuccessful");
		}
		
		
		//close connection
		connection.close();
		return rows;
		}

}
