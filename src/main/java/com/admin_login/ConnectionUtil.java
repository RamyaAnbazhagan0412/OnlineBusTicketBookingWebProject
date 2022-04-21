package com.admin_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionUtil {

		public static Connection getConnection() throws ClassNotFoundException {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://101.53.133.59:3306/revature_training_db";
			String userName="rev_user";
			String password="rev_user";
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


