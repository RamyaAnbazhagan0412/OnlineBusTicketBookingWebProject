package com.admin_login;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class UserRegistrationDAO {
			public static int userRegistrationDAO( UserRegistrationModel us) throws Exception {
				//1.get connection
				
				Connection connection=null;
				PreparedStatement statement=null;
				connection=ConnectionUtil.getConnection();
				
				//2.passing insert query
				
				String query="INSERT INTO user_registration(full_name,email_id,PASSWORD,phone_number)VALUES( ?,?,?,?)";
	            statement=connection.prepareStatement(query); 
	            
				//3.using prepared statement
	            
				statement.setString(1,us.getUserName());
			    statement.setString(2,us.getEmailId());
			    statement.setString(3,us.getPassword());
			    statement.setString(4,us.getPhoneNumber());
			    
			    //4.using executeUpdate() passing query
			    
				int row=statement.executeUpdate();
				
				
				
			int a=0;
				if(row==1) {
				System.out.println("Successfully Registerd");
				a=1;
			    }
				else {
					a=0;
				}
				
				return a;
				
				}
			

			public static int userLogin(String emailId,String password) throws SQLException, ClassNotFoundException {
			//2. Get connection
			Connection connection=null;
			 connection=ConnectionUtil.getConnection();
		    PreparedStatement statement=null;
		   
		    		
		   //3. Passing query 
		    String query="SELECT email_id,PASSWORD FROM user_registration WHERE email_id=?";
		    statement=connection.prepareStatement(query);
		   statement.setString(1,emailId);
		   
		   //4.storing values from database to rs
		   ResultSet rs=statement.executeQuery();
		  String userEmailId=null;
		  String userPassword=null;
		  int a=0;
		  //5.using if condition storing values to userEmailId,userpassword
		   if(rs.next())
		   {
			   userEmailId=rs.getString("email_id");
			  userPassword=rs.getString("PASSWORD");
			
			     }
		   if(userEmailId==null)
		   {
			  System.out.println("Invalid Login");
			  // UserRegistrationDAO.userLogin(emailId,password);
			   a=0;
			 //  userLogin.userLogin();
			   /*while(userEmailId!=null) {
			   userLogin.userLogin();
			   }*/
		   }
		   else if(userEmailId.equals(emailId.trim())&&userPassword.equals(password.trim()))
		   {
			   System.out.println("---------------USER LOGIN SUCCESSFUL-------------");
			   a=1;
		   }
	 
		   else {
			  System.out.println("emailId and password does not match");
			 //  UserRegistrationDAO.userLogin(emailId,password);
			   a=0;
			   
		   }
		  
		  
		   ConnectionUtil.close(statement,connection);
		return a;
		   
	}


	}


