package com.admin_login;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class DeleteBusDAO {
		// This method is used to delete the particular bus details in the database
		public static int busDAODelete(Bus ds)throws Exception
		{
			//1.get connection
			
			Connection connection=null;
			PreparedStatement statement=null;
			connection=ConnectionUtil.getConnection();
			
			//2.pass query
			
			String query="DELETE FROM  bus_ticket_booking_app_display WHERE  bus_id=?";
			statement=connection.prepareStatement(query);
			statement.setInt(1,ds.getBusId());
			int row=statement.executeUpdate();
			
			//3.close the connection	
			
			connection.close();
			
			//4.return the number of deleted
			return row;
			
		}
	}

