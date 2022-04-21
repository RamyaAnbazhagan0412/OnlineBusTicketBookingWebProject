package com.admin_login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DisplayBusDAO {
	public static List<DisplayBusModel>displayBusDAO(DisplayBusDAO displayObj)throws SQLException, ClassNotFoundException
	{
		//1. create list 
		List<DisplayBusModel> displayBus=new ArrayList<DisplayBusModel>();

		// 2.get connection
		Connection connection=null;
		PreparedStatement statement=null;
		connection=ConnectionUtil.getConnection();
		
		//3.select  query
		String query="SELECT bus_id,bus_name,bus_from ,bus_to ,bus_date, bus_timing, bus_tickets,bus_ticket_price FROM bus_ticket_booking_app_display";
		statement=connection.prepareStatement(query); 
		 
		     //4.using executeQuery() passing query
			ResultSet rs=statement.executeQuery();
			
			System.err.println("\nBus Id      Bus Name       Bus From      Bus To      Bus Date    Bus Timing     BusTicketsAvailable     BusTicketPrice");
			while(rs.next()) {
	       
				int id=rs.getInt("bus_id");
				String busName=rs.getString("bus_name");
				String busFrom=rs.getString("bus_from");
				String busTo=rs.getString("bus_to");
				String busDate=rs.getString("bus_date");
				String busTiming=rs.getString("bus_timing");
				int busTickets=rs.getInt("bus_tickets");
				int busTicketPrice=rs.getInt("bus_ticket_Price");
				
				DisplayBusModel obj=new DisplayBusModel();
				
				obj.setBusId(id);
				obj.setBusName(busName);
				obj.setBusFrom(busFrom);
				obj.setBusTo(busTo);
				obj.setBusDate(busDate);
				obj.setBusTiming(busTiming);
				obj.setBusTicketsAvailable(busTickets);
				obj.setBusTicketPrice(busTicketPrice);
				
				displayBus.add(obj);
			}
			connection.close();
			return displayBus;
			

		}
	}


