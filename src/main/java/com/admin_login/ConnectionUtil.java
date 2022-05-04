package com.admin_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionUtil {

		public static Connection getConnection() throws ClassNotFoundException {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://training-db.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com:3306/ramya_anbazhagan_db";
			String userName="ramya";
			String password="anbazhagan_ramya";
			Connection connection=null;
			try {
				connection=DriverManager.getConnection(url,userName,password);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				throw new RuntimeException("Invalid Login \n Login Again");
			}
			return connection;
		}
		public static void close(Statement statement,Connection connection) {
			try {
				if(statement!=null)
				{
					statement.close();
				
				}
				if(connection!=null)
				{
					connection.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			}

	}


