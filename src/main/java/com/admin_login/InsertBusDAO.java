package com.admin_login;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class InsertBusDAO {
	public static int insertBus(Bus bus)throws Exception
	{
		// 1.get connection

		Connection connection = null;
		PreparedStatement statement = null;
		connection=ConnectionUtil.getConnection();
		int rows = 0;

		    // 2.query passing

		    String query = "INSERT INTO bus_ticket_booking_app_display (bus_name,bus_from,bus_to,bus_timing ,bus_tickets,bus_ticket_price)VALUES(?,?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, bus.getBusName());
			statement.setString(2, bus.getBusFrom());
			statement.setString(3, bus.getBusTo());
			statement.setString(4, bus.getBusTiming());
			statement.setInt(5, bus.getBusTicketsAvailable());
			statement.setInt(6, bus.getBusTicketPrice());
			rows = statement.executeUpdate();
      System.out.println(rows);
		// 3.close connection
		
		connection.close();
		
		// 4.return number of inserted row
		return rows;
		
	}

}
