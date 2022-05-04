package com.admin_login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DisplayBusDetailsDAO {
			// this method is used to display particular bus details by bus id
		public static Bus displayBusDetailsDAO(Bus obj) throws ClassNotFoundException, SQLException {
			
			Bus db = null;
			//1. Get Connection from util package
			
			Connection connection=null;
			PreparedStatement statement=null;
			connection=ConnectionUtil.getConnection();
			// 2.Passing sql query by id
					
			
					String query="SELECT bus_id,bus_name,bus_from ,bus_to, bus_timing, bus_tickets,bus_ticket_price FROM bus_ticket_booking_app_display WHERE bus_id=? ";
					statement=connection.prepareStatement(query);
					statement.setInt(1,obj.getBusId());
					ResultSet rs=statement.executeQuery();
					
					if(rs.next())
					{
						//3.data from database get stored in local variable
						Integer id=rs.getInt("bus_id");
						String busName=rs.getString("bus_name");
						String busFrom=rs.getString("bus_from");
						String busTo=rs.getString("bus_to");
						String busTiming=rs.getString("bus_timing");
						Integer busTickets=rs.getInt("bus_tickets");
						Integer busTicketPrice=rs.getInt("bus_ticket_Price");
						
						//4. values setted to bus Model class
						 db=new Bus();
						
						db.setBusId(id);
						db.setBusName(busName);
						db.setBusFrom(busFrom);
						db.setBusTo(busTo);
						db.setBusTiming(busTiming);
						db.setBusTicketsAvailable(busTickets);
						db.setBusTicketPrice(busTicketPrice);
						
						//5.list added
					}
					//6.connection is closed
					connection.close();
					return db;
			
		}
		

	}
